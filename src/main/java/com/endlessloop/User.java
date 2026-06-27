package com.endlessloop;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isim;
    private String ePosta;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // Veritabanında foreign key sütunu oluşturur
    @JsonIgnoreProperties("kullanici") // Karşı taraftaki sonsuz döngüyü engeller
    private List<Todo> herkes;

    public User() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getIsim() { return isim; }
    public void setIsim(String isim) { this.isim = isim; }
    public String getEPosta() { return ePosta; }
    public void setEPosta(String ePosta) { this.ePosta = ePosta; }
    public List<Todo> getHerkes() { return herkes; }
    public void setHerkes(List<Todo> herkes) { this.herkes = herkes; }
}