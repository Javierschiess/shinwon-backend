package com.shinwon.model;

import com.shinwon.dto.BodegaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produccion")
public class Produccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produccion")
    private Long idProduccion;

    @ManyToOne
    @JoinColumn(name = "id_bodega", nullable = false, foreignKey = @ForeignKey(name = "FK_produccion_bodega"))
    private Bodega bodega;

    @ManyToOne
    @JoinColumn(name = "id_linea", nullable = false, foreignKey = @ForeignKey(name = "FK_produccion_linea"))
    private Linea linea;

    @ManyToOne
    @JoinColumn(name = "id_file", nullable = false, foreignKey = @ForeignKey(name = "FK_produccion_file"))
    private File file;

    @ManyToOne
    @JoinColumn(name = "id_detalle", nullable = false, foreignKey = @ForeignKey(name = "FK_produccion_detalle"))
    private DetalleFile detalleFile;

    @ManyToOne
    @JoinColumn(name = "id_talla", nullable = false, foreignKey = @ForeignKey(name = "FK_produccion_talla"))
    private Talla talla;

    @ManyToOne
    @JoinColumn(name = "id_color", nullable = false, foreignKey = @ForeignKey(name = "FK_produccion_color"))
    private Color color;

    @Column(name = "cantidad", nullable = false , length = 25)
    private int cantidad;

    @CreationTimestamp
    @Column(name = "hora", nullable = false)
    private LocalDateTime hora;

    @Column(name = "producido", nullable = false, length = 50)
    private int producido;

    @Column(name = "restante", nullable = false, length = 50)
    private int restante;

    @Column(name = "dias_habiles")
    private Integer diasHabiles;

    @Column(name = "horas_habiles")
    private Integer horasHabiles;

    @Column(name = "porcentaje")
    private float porcentaje;

}
