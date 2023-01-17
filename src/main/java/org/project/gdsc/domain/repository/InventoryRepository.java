package org.project.gdsc.domain.repository;

import org.project.gdsc.domain.model.Inventory;

import java.util.List;

public interface InventoryRepository {
    public Inventory save(Inventory inventory);
    public Inventory getById(int id);
    public List<Inventory> findAll();
}
