package org.example.pharmacy_web.infrastructure.repo;

import org.example.pharmacy_web.infrastructure.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRepository extends JpaRepository<Drug, Long> {
}
