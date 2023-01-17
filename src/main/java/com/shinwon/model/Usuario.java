package com.shinwon.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "nombre", nullable = false, unique = true, length = 25)
    private String username;

    @Column(name = "clave", nullable = false, length = 25)
    private String password;

    @Column(name = "estado", nullable = false)
    private boolean enabled;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
                        joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"),
                        inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
    private List<Rol> roles;

}
