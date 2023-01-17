package com.shinwon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bodega")
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bodega")
    private Integer idBodega;

    @Column(name = "bodega", nullable = false, length = 15)
    private String bodega;

    @Column(name = "ubicacion", nullable = false, length = 50)
    private String ubicacion;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column(name = "estado")
    private Boolean estado;

    @CreationTimestamp
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_empleado", nullable = false, foreignKey = @ForeignKey(name = "FK_bodega_empleado"))
    private Empleado encargado;

    @OneToMany(mappedBy = "bodega", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Linea> linea;


}
