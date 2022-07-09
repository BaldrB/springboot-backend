package net.javaguides.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import net.javaguides.springboot.model.Role; 
 
public interface RoleRepository extends CrudRepository<Role, Integer> {
     
}
