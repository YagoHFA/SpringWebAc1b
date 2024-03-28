package com.facens.ac1.Repository;

import com.facens.ac1.Model.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
    @Query(value = "SELECT * FROM categorias WHERE cat_nome like ?1%", nativeQuery = true)
    List<Categorias> findByInitNome(String nome);

    @Query(value = "SELECT cc FROM categorias cc left join fetch cc.produtos WHERE cc.id_categorias = :id")
    Categorias findByIdAndProduct(@Param("id") Long id);
}
