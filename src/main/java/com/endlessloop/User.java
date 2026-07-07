package com.endlessloop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isim;
    private String ePosta;

    public User() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIsim() { return isim; }
    public void setIsim(String isim) { this.isim = isim; }
    public String getEPosta() { return ePosta; }
    public void setEPosta(String ePosta) { this.ePosta = ePosta; }
}