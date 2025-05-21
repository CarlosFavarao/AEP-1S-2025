package br.com.GiraBem.model;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "tipo_doacao")
public class TipoDoacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(nullable = false)
    private String nome;

    public TipoDoacaoModel() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
