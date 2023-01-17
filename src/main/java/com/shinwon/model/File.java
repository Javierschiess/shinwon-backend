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
@Table(name = "file")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_file")
    private Integer idFile;

    @Column(name = "file", nullable = false, length = 25)
    private String file;

    @Column(name = "descripcion", length = 150)
    private String descripcion;

    @Column(name = "estado")
    private Boolean estado;

    @CreationTimestamp
    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false, foreignKey = @ForeignKey(name = "FK_file_cliente"))
    private Cliente cliente;

    @OneToMany(mappedBy = "file", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<DetalleFile> detalleFile;


}
