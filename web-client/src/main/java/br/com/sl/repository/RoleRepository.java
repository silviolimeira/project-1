package br.com.sl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sl.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
