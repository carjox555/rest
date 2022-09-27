package com.Rest.Rest.models;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


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

        public Usuario(String nameUser, String password, String namePeople) {
            this.nameUser = nameUser;
            this.password = password;
            this.namePeople = namePeople;
        }

        public Usuario() {
        }
    }


