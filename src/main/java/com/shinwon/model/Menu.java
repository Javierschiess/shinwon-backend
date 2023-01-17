package com.shinwon.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {

    @Id
    @Column(name = "id_menu")
    private Integer idMenu;

    @Column(name = "icono", length = 20)
    private String icono;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "url", length = 50)
    private String url;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_rol", joinColumns = @JoinColumn(name = "id_meu", referencedColumnName = "id_menu"),
                        inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol"))
     private List<Rol> roles;
}
