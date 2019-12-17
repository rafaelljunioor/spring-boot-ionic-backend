package com.rafael.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.cursomc.domain.Categoria;
import com.rafael.cursomc.domain.Cidade;
import com.rafael.cursomc.domain.Cliente;
import com.rafael.cursomc.domain.Endereco;
import com.rafael.cursomc.domain.Estado;
import com.rafael.cursomc.domain.Produto;
import com.rafael.cursomc.domain.enums.TipoCliente;
import com.rafael.cursomc.repositories.CategoriaRepository;
import com.rafael.cursomc.repositories.CidadeRepository;
import com.rafael.cursomc.repositories.ClienteRepository;
import com.rafael.cursomc.repositories.EnderecoRepository;
import com.rafael.cursomc.repositories.EstadoRepository;
import com.rafael.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	@Autowired private CategoriaRepository catRepo;
	@Autowired private ProdutoRepository prodRepo;
	@Autowired private EstadoRepository estRepo;
	@Autowired private CidadeRepository cidRepo;
	@Autowired private ClienteRepository cliRepo;
	@Autowired private EnderecoRepository endRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
	
		
		catRepo.saveAll(Arrays.asList(cat1, cat2));
		prodRepo.saveAll(Arrays.asList(p1,p2,p3));
		
		/**INSTANCIA DE CIDADE E ESTADO**/
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "Campinas", est2);
		Cidade c3 = new Cidade(null, "São Paulo", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estRepo.saveAll(Arrays.asList(est1, est2));
		cidRepo.saveAll(Arrays.asList(c1,c2,c3));
		
		/**INSTANCIA DE CLIENTES**/
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300" , "Apto 303", "Jardim", "38220834", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105" , "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		cliRepo.saveAll(Arrays.asList(cli1));
		endRepo.saveAll(Arrays.asList(e1,e2));
	}

}
