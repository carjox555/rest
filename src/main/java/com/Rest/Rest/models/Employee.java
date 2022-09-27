package com.Rest.Rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String correo;
    @JsonIgnore  //-> Ignora el set y get del atributo
    @OneToMany(mappedBy = "employee", orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Usuario usuario;
    /*

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    //    private Rol rol;
    @Enumerated(value = EnumType.STRING)
//    @ElementCollection(targetClass = Rol.class, fetch = FetchType.LAZY)
    @ElementCollection(targetClass = Rol.class, fetch = FetchType.EAGER)
    @Column(name="rol")
//    private Rol rol;
    private List<Rol> roles;

    @JsonIgnore
    @OneToOne
//    @JoinColumn(name = "usuario_id")


    public Empleado() {
    }

     */
}
