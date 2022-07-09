package net.javaguides.springboot.controller;

import java.util.List;
 
import javax.transaction.Transactional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.User;
import net.javaguides.springboot.repository.UserRepository;
 
@Service
@Transactional
public class UserServices {
     
    @Autowired
    private UserRepository repo;
     
    public List<User> listAll() {
        return repo.findAll(Sort.by("email").ascending());
    }
}