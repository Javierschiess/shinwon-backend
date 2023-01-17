package com.shinwon.repo;

import com.shinwon.model.DetalleFile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface IDetalleFileRepo extends IGenericRepo<DetalleFile, Integer> {

    @Query("SELECT d.cantPiezas FROM DetalleFile d WHERE d.file.idFile=:idFile AND  d.idDetalleFile=:idDetalle AND d.color.idColor=:idColor AND d.talla.idTalla=:idTalla")
    Integer cantPiezas (@Param("idFile") Integer idFile, @Param("idDetalle") Integer idDetalle, @Param("idColor") Integer idColor, @Param("idTalla") Integer idTalla);

    @Query(value = "SELECT fecha_inicio_produ FROM detalle_file  WHERE id_file=:idFile AND id_detalle_file=:idDetalle AND id_color=:idColor AND id_talla=:idTalla", nativeQuery = true)
    LocalDate fechaInicio (@Param("idFile") Integer idFile, @Param("idDetalle") Integer idDetalle, @Param("idColor") Integer idColor, @Param("idTalla") Integer idTalla);

    @Query(value = "SELECT fecha_expo FROM detalle_file  WHERE id_file=:idFile AND id_detalle_file=:idDetalle AND id_color=:idColor AND id_talla=:idTalla", nativeQuery = true)
    LocalDate fechaExpo (@Param("idFile") Integer idFile, @Param("idDetalle") Integer idDetalle, @Param("idColor") Integer idColor, @Param("idTalla") Integer idTalla);

}
