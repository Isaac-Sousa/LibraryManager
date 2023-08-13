package com.apirest.LibraryManager.models;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="TB_PUBLISH")
    public class PublishModel implements Serializable{
        @Serial
         private static final long serialVersionUID =1L;

       @Id
       @GeneratedValue(strategy= GenerationType.AUTO)
        private UUID idPublish;
        private String publishName;
        private String publishCity;

    public UUID getIdPublish() {
        return idPublish;
    }

    public void setIdPublish(UUID idPublish) {
        this.idPublish = idPublish;
    }

    public String getPublishName() {
        return publishName;
    }

    public void setPublishName(String publishName) {
        this.publishName = publishName;
    }

    public String getPublishCity() {
        return publishCity;
    }

    public void setPublishCity(String publishCity) {
        this.publishCity = publishCity;
    }
}
