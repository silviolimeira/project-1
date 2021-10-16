package br.com.sl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sl.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
