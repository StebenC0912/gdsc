package org.project.gdsc.infrastructure.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryJpaRepo extends JpaRepository<InventoryEntity, Integer> {
}
