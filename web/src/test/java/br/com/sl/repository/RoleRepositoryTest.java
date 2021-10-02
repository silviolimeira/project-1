package br.com.sl.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import br.com.sl.entity.Role;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {

	@Autowired
	private RoleRepository roleRepo;
	
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin", "manage everything");
		Role savedRole = roleRepo.save(roleAdmin);
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateOtherRole() {
		
		Role roleSalesperson = new Role("Salesperson", "manage product price, customers, shipping, orders and sales report");
		Role roleEditor = new Role("Editor", "manage categories, brands, products, articles and menus");
		Role roleShipper = new Role("Shipper", "view products, view orders and update order status");
		Role roleAssistant = new Role("Assistant", "manage questions and reviews");
		
		roleRepo.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));
		
	}
	
	
	
}
