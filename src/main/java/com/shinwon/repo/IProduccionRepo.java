package com.shinwon.repo;

import com.shinwon.model.Produccion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProduccionRepo extends IGenericRepo<Produccion, Long> {

    @Query("SELECT MAX(p.producido) FROM Produccion p WHERE p.file.idFile=:idFile AND p.detalleFile.idDetalleFile=:idDetalle AND p.color.idColor=:idColor AND p.talla.idTalla=:idTalla")
    Integer producido (@Param("idFile") Integer idFile, @Param("idDetalle") Integer idDetalle, @Param("idColor") Integer idColor, @Param("idTalla") Integer idTalla);

    @Query("SELECT MAX(p.restante) FROM Produccion p WHERE p.file.idFile=:idFile AND p.detalleFile.idDetalleFile=:idDetalle AND p.color.idColor=:idColor AND p.talla.idTalla=:idTalla")
    Integer restante (@Param("idFile") Integer idFile, @Param("idDetalle") Integer idDetalle, @Param("idColor") Integer idColor, @Param("idTalla") Integer idTalla);

}
