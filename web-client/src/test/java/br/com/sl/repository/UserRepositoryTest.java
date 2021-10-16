package br.com.sl.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import br.com.sl.entity.Role;
import br.com.sl.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUserAdmin() {
		
		Role roleAdmin = entityManager.find(Role.class, 3);
		User userAdmin = new User("admin@gmail.com", "admin", "Admin", "Admin");
		userAdmin.addRole(roleAdmin);
		User savedUser = userRepo.save(userAdmin);
		assertThat(savedUser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testCreateUserTwoRoles() {
		
		Role roleEditor = new Role(5);
		Role roleAssistant = new Role(7);
		
		User user = new User("editor@gmail.com", "editor", "Editor", "Editor");
		
		user.addRole(roleEditor);
		user.addRole(roleAssistant);
		
		User savedUser = userRepo.save(user);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testListAllUsers() {
		
		Iterable<User> listUsers = userRepo.findAll();
		listUsers.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void testGetUserById() {
		User user = userRepo.findById(1).get();
		System.out.println("User name: " + user.getFirstName());
		assertThat(user).isNotNull();
	}
	
	@Test
	public void testUpdateUserDetails() {
		
		User user = userRepo.findById(1).get();
		
		user.setEnabled(true);
		
		userRepo.save(user);
		
	}
	
	@Test
	public void testUpdateUserRoles() {
		
		User user = userRepo.findById(2).get();
		
		Role roleEditor = new Role(5);
		Role roleSalesperson = new Role(4);
		
		user.getRoles().remove(roleEditor);
		user.addRole(roleSalesperson);
		
		userRepo.save(user);
		
	}
	
	@Test
	public void testRemoveUserRole() {
		
		User user = userRepo.findById(2).get();
		
		Role roleEditor = new Role(5);
		
		user.getRoles().remove(roleEditor);
		
		userRepo.save(user);
		
	}
	
}
