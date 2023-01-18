package org.project.gdsc.infrastructure.repository;

import org.project.gdsc.domain.model.Inventory;
import org.project.gdsc.domain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryRepositoryImpl implements InventoryRepository {
    @Autowired
    private InventoryJpaRepo inventoryJpaRepo;


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
