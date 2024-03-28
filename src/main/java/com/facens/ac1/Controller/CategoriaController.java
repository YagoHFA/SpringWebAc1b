package com.facens.ac1.Controller;

import com.facens.ac1.Model.Categorias;
import com.facens.ac1.Repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriasRepository categoriaRepository;

    @GetMapping("/all")
    public List<Categorias> findAll() {
        return categoriaRepository.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody Categorias categoria) {
        categoriaRepository.save(categoria);
    }

    public Categorias findById(Long id) {
        return categoriaRepository.getReferenceById(id);
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

    public void update(Categorias categoria) {
        categoriaRepository.save(categoria);
    }

    public List<Categorias> findInitName(String name) {
        return categoriaRepository.findByInitNome(name);
    }

    public Categorias findByIdandproduct(Long id){
        return categoriaRepository.findByIdAndProduct(id);
    }
}
