package com.facens.ac1.Controller;

import com.facens.ac1.Model.Produtos;
import com.facens.ac1.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProdutosController {
    @Autowired
    private ProdutosRepository produtosRepository;

    public List<Produtos> findAll(){
        return produtosRepository.findAll();
    }

    public void save(Produtos produtos){
        produtosRepository.save(produtos);
    }

    public void delete(Long id){
        produtosRepository.deleteById(id);
    }

    public Produtos findById(Long id){
        return produtosRepository.getReferenceById(id);
    }

    public void update(Produtos produtos){
        produtosRepository.save(produtos);
    }

    public List<Produtos> findInitName(String name){
        return produtosRepository.findByProd_nome(name);
    }

    public List<Produtos> findLessPrice(Double price){
        return produtosRepository.findLessPrice(price);
    }

    public List<Produtos> findMorePrice(Double price){
        return produtosRepository.findByMorePrice(price);
    }
}
