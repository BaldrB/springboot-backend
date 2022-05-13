package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Sklad;

public interface SkladRepository extends JpaRepository<Sklad, Long> {
    
}
