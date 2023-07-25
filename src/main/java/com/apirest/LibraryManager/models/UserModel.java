package com.apirest.LibraryManager.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class UserModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getAdressUser() {
        return adressUser;
    }

    public void setAdressUser(String adressUser) {
        this.adressUser = adressUser;
    }

    public String getCityUser() {
        return cityUser;
    }

    public void setCityUser(String cityUser) {
        this.cityUser = cityUser;
    }

    public Email getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(Email emailUser) {
        this.emailUser = emailUser;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID idUser;

    private String nameUser;

    private String adressUser;

    private String cityUser;

    private Email emailUser;
}
