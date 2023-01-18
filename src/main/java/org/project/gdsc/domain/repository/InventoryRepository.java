package org.project.gdsc.domain.repository;

import org.project.gdsc.domain.model.Inventory;

import java.util.List;

public interface InventoryRepository {
    Inventory save(Inventory inventory);
    Inventory getById(int id);
    List<Inventory> findAll();
}
