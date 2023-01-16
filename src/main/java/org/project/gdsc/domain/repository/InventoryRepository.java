package org.project.gdsc.domain.repository;

import org.project.gdsc.domain.model.Inventory;

public interface InventoryRepository {
    public void save(Inventory inventory);
    public Inventory getById(int id);
}
