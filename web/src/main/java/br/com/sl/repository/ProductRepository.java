package br.com.sl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sl.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	Product findByName(String name);

}
