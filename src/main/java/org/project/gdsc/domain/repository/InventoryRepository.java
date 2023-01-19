package org.project.gdsc.domain.repository;

import org.project.gdsc.domain.model.Inventory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InventoryRepository {
    Inventory save(Inventory inventory);
    Inventory getById(int id);
    List<Inventory> findAll();
}
