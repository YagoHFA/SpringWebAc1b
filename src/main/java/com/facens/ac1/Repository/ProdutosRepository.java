package com.facens.ac1.Repository;

import com.facens.ac1.Model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

    @Query(value = "SELECT * FROM produtos WHERE price > ?1", nativeQuery = true)
    List<Produtos> findByMorePrice(Double price);

    @Query(value = "SELECT * FROM produtos WHERE price <= ?1", nativeQuery = true)
    List<Produtos> findLessPrice(Double price);

    @Query(value = "SELECT * FROM produtos WHERE prod_nome like ?1%", nativeQuery = true)
    List<Produtos> findByProd_nome(String prod_nome);

}
