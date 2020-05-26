package com.iobeica.postgresapi.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iobeica.postgresapi.models.Produto;
import com.iobeica.postgresapi.repositories.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoRes {
	
	@Autowired
    ProdutoRepository repo;

	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body("Testando findAll");
		} catch (Exception e) {
			throw  e;
		}
	}

	@RequestMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id ){
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(repo.findById(id));
		} catch (Exception e) {
			throw e;
		}
		
	}
	
	@RequestMapping("/nameById/{id}") 
	public String findNameFromId (@PathVariable Long id){
		try {
			Produto p = new Produto();
			p = repo.findById(id).get();
			return p.getNome();
		} catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping("/findByName/{nome}")
	public Produto findByName(@PathVariable String nome) {
		try {
			
			Produto p = new Produto();
			List<Produto> lista = new ArrayList<>();
			lista = repo.findAll();
			
			for (Produto produto : lista) {
				if(produto.getNome().equals(nome)) {
					p=produto;
				}
			}
			return p;
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@PostMapping("/addProduto")
	public Produto saveProduto(@RequestBody Produto produto) {
		try {
			return repo.save(produto);
		} catch (Exception e) {
			throw e;
		}
	}

}
