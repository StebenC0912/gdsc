package org.project.gdsc.infrastructure.repository;

import jakarta.persistence.Entity;
import org.project.gdsc.domain.model.Inventory;
import org.project.gdsc.domain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {

    private InventoryJpaRepo inventoryJpaRepo;
    @Autowired
    public int InventoryRepositoryImpl(Inventory inventory) {
        if (inventory.getHeight() <= 0) {
            throw new RuntimeException("Height must be greater than 0");
        } else if (inventory.getWeight() <= 0) {
            throw new RuntimeException("Length must be greater than 0");
        } else if (inventory.getWidth() <= 0) {
            throw new RuntimeException("Width must be greater than 0");
        }

        return inventoryJpaRepo.save(new InventoryEntity(inventory)).getId();

    }

    @Override
    public Inventory save(Inventory inventory) {
        final InventoryEntity entity = InventoryEntity.fromDomainModel(inventory);
        final InventoryEntity savedEntity = inventoryJpaRepo.save(entity);
        return savedEntity.toDomainModel();
    }

    @Override
    public Inventory getById(int id) {
        return inventoryJpaRepo.findById(id).get().toDomainModel();
    }

    @Override
    public List<Inventory> findAll() {
        return inventoryJpaRepo.findAll().stream().map(InventoryEntity::toDomainModel).toList();
    }
}
