package com.iobeica.postgresapi.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iobeica.postgresapi.models.Produto;

@Repository
@Transactional
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
	
}
