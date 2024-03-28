package com.facens.ac1.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity(name = "categorias")
@Table(name = "categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorias")
    private Long id_categorias;

    @Column(columnDefinition = "TINYTEXT")
    private String cat_nome;

    @OneToMany(mappedBy = "categorias")
    private List<Produtos> produtos;

    public Long getId_categorias() {
        return id_categorias;
    }

    public void setId_categorias(Long id_categorias) {
        this.id_categorias = id_categorias;
    }

    public String getCat_nome() {
        return cat_nome;
    }

    public void setCat_nome(String cat_nome) {
        this.cat_nome = cat_nome;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    public void printProd(){
        System.out.println("Category: " + this.cat_nome);
        this.produtos.forEach(x -> System.out.println("\nProduct Name: " + x.getProd_nome() + "\nProduct Price: " + x.getPrice()));
    }
}
