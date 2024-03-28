package com.facens.ac1.Model;

import jakarta.persistence.*;

@Entity
public class Produtos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_produtos;


    @Column(columnDefinition = "TINYTEXT")
    private String prod_nome;

    private Double price;

    @ManyToOne
    private Categorias categorias;

    public Integer getId_produtos() {
        return id_produtos;
    }

    public void setId_produtos(Integer id_produtos) {
        this.id_produtos = id_produtos;
    }

    public String getProd_nome() {
        return prod_nome;
    }

    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Produtos(String  prod_nome, Double price, Categorias categorias){
        this.prod_nome = prod_nome;
        this.price = price;
        this.categorias = categorias;
    }

    public Produtos() {
    }
}
