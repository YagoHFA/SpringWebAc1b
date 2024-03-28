package com.facens.ac1;

import com.facens.ac1.Controller.CategoriaController;
import com.facens.ac1.Controller.ProdutosController;
import com.facens.ac1.Model.Categorias;
import com.facens.ac1.Model.Produtos;
import com.facens.ac1.Repository.CategoriasRepository;
import com.facens.ac1.Repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutosController produtosController, @Autowired CategoriaController categoriaController) {
		return (args) -> {


			Categorias categorias= new Categorias();
			categorias.setCat_nome("Jogos");

			Categorias categorias2= new Categorias();
			categorias2.setCat_nome("Jogadas");

			Categorias categorias1= new Categorias();
			categorias1.setCat_nome("Filmes");

			Produtos produtos = new Produtos();
			produtos.setPrice(40d);
			produtos.setProd_nome("GTA V");
			produtos.setCategorias(categorias);

			Produtos produtos1 = new Produtos();
			produtos1.setPrice(20d);
			produtos1.setProd_nome("Mario");
			produtos1.setCategorias(categorias1);

			Produtos produtos2 = new Produtos();
			produtos2.setPrice(10d);
			produtos2.setProd_nome("Pokemon");
			produtos2.setCategorias(categorias);

			Produtos produtos3 = new Produtos();
			produtos3.setPrice(15d);
			produtos3.setProd_nome("Matrix");
			produtos3.setCategorias(categorias1);

			Produtos produtos4 = new Produtos();
			produtos4.setPrice(17d);
			produtos4.setProd_nome("Missao Impossivel");
			produtos4.setCategorias(categorias1);

			Produtos produtos5 = new Produtos();
			produtos5.setPrice(20d);
			produtos5.setProd_nome("Star Wars");
			produtos5.setCategorias(categorias1);

			categoriaController.save(categorias2);
			categoriaController.save(categorias1);
			categoriaController.save(categorias);

			produtosController.save(produtos);
			produtosController.save(produtos1);
			produtosController.save(produtos2);

			produtosController.save(produtos4);
			produtosController.save(produtos3);
			produtosController.save(produtos5);


			System.out.println("Preco maior que 20");
			produtosController.findMorePrice(19d).forEach(x -> System.out.println("\nName:" + x.getProd_nome() + " \n Price: " + x.getPrice()));

			System.out.println("\nComeca com 'Ma'");
			produtosController.findInitName("Ma").forEach(x -> System.out.println("\nName:" + x.getProd_nome() + "\nPrice: " + x.getPrice()));

			System.out.println("\nMenor que 20");
			produtosController.findLessPrice(20d).forEach(x -> System.out.println(("\nName: " + x.getProd_nome() + "\nPrice" + x.getPrice())));

			System.out.println("\nCategorias comecando por Jo");
			categoriaController.findInitName("Jo").forEach(x -> System.out.println("\nName: " + x.getCat_nome()));

			System.out.println("\nCategoria 2\n");
			categoriaController.findByIdandproduct(2L).printProd();

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}
}
