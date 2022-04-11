package com.fooder.fooder.model;

import javax.persistence.*;

@Entity
@Table
public class Prato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    public Prato() {}

    public Prato(Integer id, String nome, String descricao, Restaurante restaurante) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.restaurante = restaurante;
    }

    public Prato(String nome, String descricao, Restaurante restaurante) {
        this.nome = nome;
        this.descricao = descricao;
        this.restaurante = restaurante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
