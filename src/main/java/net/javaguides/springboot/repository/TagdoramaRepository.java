package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Tagdorama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagdoramaRepository extends JpaRepository<Tagdorama, Long> {
    // all crud database methods
}