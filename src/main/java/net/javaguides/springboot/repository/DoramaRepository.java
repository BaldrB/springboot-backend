package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Dorama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoramaRepository extends JpaRepository<Dorama, Long> {
    // all crud database methods
}