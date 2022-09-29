package com.Rest.Rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


    @Getter
    @Setter
    @Entity
    @Table(name = "usuario")
    public class Usuario {
        @Id
        private String nameUser;
        @Column
        private String password;
        @Column
        private String namePeople;
        @JsonIgnore  //-> Ignora el set y get del atributo
        @OneToOne(mappedBy = "usuario")
        private Employee employee;

        @ManyToOne
        private Profile profile;

        public Usuario(String nameUser, String password, String namePeople, Employee employe, Profile profile) {
            this.nameUser = nameUser;
            this.password = password;
            this.namePeople = namePeople;
            this.employee=employe;
            this.profile=profile;
        }

        public Usuario() {
        }
    }


