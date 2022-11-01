package com.indivara.ecommerce.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Pengguna implements Serializable {

    @Id
    private String id;

    private String password;

    private String nama;

    private String alamat;

    private String email;

    private String hp;

    private String roles;

    private Boolean isAktif;

}
