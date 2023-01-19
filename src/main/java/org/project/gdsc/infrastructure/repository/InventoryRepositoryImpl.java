package org.project.gdsc.infrastructure.repository;

import jakarta.persistence.Entity;
import org.project.gdsc.domain.model.Inventory;
import org.project.gdsc.domain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {
    private InventoryJpaRepo inventoryJpaRepo;

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryJpaRepo.save(InventoryEntity.fromDomainModel(inventory)).toDomainModel();
    }

    @Override
    public Inventory getById(int id) {
        InventoryEntity inventoryEntity = inventoryJpaRepo.getById(id);
        return inventoryEntity.toDomainModel();
    }

    @Override
    public List<Inventory> findAll() {
        List<Inventory> all = new ArrayList<>();
        List<InventoryEntity> allEntities = inventoryJpaRepo.findAll();
        for (InventoryEntity inventoryEntity: allEntities) {
            all.add(inventoryEntity.toDomainModel());
        }
        return all;
    }
}
