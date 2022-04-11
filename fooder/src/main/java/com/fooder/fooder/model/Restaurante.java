package com.fooder.fooder.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    @OneToMany
    private Set<Endereco> enderecos = new HashSet<>();
    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY)
    private Set<Prato> pratos = new HashSet<>();


    public Restaurante() {
    }

    public Restaurante(Integer id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Restaurante(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
    public Set<Endereco> getEnderecos() {return enderecos;}
    public void setEnderecos(Set<Endereco> enderecos) {this.enderecos = enderecos;}
    public Set<Prato> getPratos() {return pratos;}
    public void setPratos(Set<Prato> pratos) {this.pratos = pratos;}
}
