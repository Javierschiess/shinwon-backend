package com.shinwon.service.serviceImpl;

import com.shinwon.model.Produccion;
import com.shinwon.repo.IDetalleFileRepo;
import com.shinwon.repo.IGenericRepo;
import com.shinwon.repo.IProduccionRepo;
import com.shinwon.service.IProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProduccionServiceImpl extends CRUDImpl<Produccion, Long> implements IProduccionService {

    @Autowired
    private IProduccionRepo repo;

    @Autowired
    private IDetalleFileRepo detalleRepo;

    @Override
    protected IGenericRepo<Produccion, Long> getRepo() {
        return repo;
    }

    //@Transactional
    @Override
    public Produccion registrarProduccion(Produccion produccion) throws Exception {

        Integer cantPiezas = detalleRepo.cantPiezas(produccion.getFile().getIdFile(), produccion.getDetalleFile().getIdDetalleFile(), produccion.getColor().getIdColor(), produccion.getTalla().getIdTalla());
        Integer producido = repo.producido(produccion.getFile().getIdFile(), produccion.getDetalleFile().getIdDetalleFile(), produccion.getColor().getIdColor(), produccion.getTalla().getIdTalla());
        Integer restante = repo.restante(produccion.getFile().getIdFile(), produccion.getDetalleFile().getIdDetalleFile(), produccion.getColor().getIdColor(),produccion.getTalla().getIdTalla());
        LocalDate fechaInicio =  LocalDate.now();//detalleRepo.fechaInicio(produccion.getFile().getIdFile(), produccion.getDetalleFile().getIdDetalleFile(), produccion.getColor().getIdColor(), produccion.getTalla().getIdTalla());
        LocalDate fechaExpo = detalleRepo.fechaExpo(produccion.getFile().getIdFile(), produccion.getDetalleFile().getIdDetalleFile(), produccion.getColor().getIdColor(), produccion.getTalla().getIdTalla());

        List<LocalDate> diasEntre  = new ArrayList<>();
        List<LocalDate> feriados = Arrays.asList(LocalDate.of(2023,03,12),
                                                 LocalDate.of(2023,03,15));

        for (LocalDate date = fechaExpo; date.isAfter(fechaInicio); date = date.minusDays(1)){
            diasEntre.add(date);
        }

        System.out.println(diasEntre);

        List<LocalDate> diasNohabiles = diasEntre.stream().filter(feriados :: contains).collect(Collectors.toList());

        Integer diasMuertos = diasNohabiles.size();
        Integer diasEntr = diasEntre.size();
        Integer weekend = 0;

        for (LocalDate date : diasEntre){
            Date dias = Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dias);
            Integer diasDeLaSemana = calendar.get(Calendar.DAY_OF_WEEK);

            if (diasDeLaSemana == Calendar.SATURDAY || diasDeLaSemana == Calendar.SUNDAY){
                weekend++;
            }
        }

        Integer diasVivos = diasEntr - (diasMuertos + weekend);
        Integer horasVivas = diasVivos * 11;

        if (producido == null){
            produccion.setProducido(produccion.getCantidad());
        }else {
            produccion.setProducido(producido + produccion.getCantidad());
        }

        if (restante == null){
            produccion.setRestante(cantPiezas - produccion.getCantidad());
        }else {
            produccion.setRestante(cantPiezas- produccion.getProducido());
        }

        produccion.setDiasHabiles(diasVivos);
        produccion.setHorasHabiles(horasVivas);
        produccion.setPorcentaje(produccion.getProducido() * 100 / cantPiezas);
        produccion.setHora(LocalDateTime.now());

        return repo.save(produccion);
    }
}
