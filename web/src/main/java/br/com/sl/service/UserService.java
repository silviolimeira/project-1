package br.com.sl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sl.entity.User;
import br.com.sl.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	public List<User> listAll() {
		return (List<User>) userRepo.findAll();
	}
	
}
