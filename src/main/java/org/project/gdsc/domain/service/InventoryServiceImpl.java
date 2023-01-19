package org.project.gdsc.domain.service;

import org.project.gdsc.domain.model.Inventory;
import org.project.gdsc.domain.model.InventoryItem;
import org.project.gdsc.domain.repository.InventoryRepository;
import org.project.gdsc.infrastructure.controller.InvalidInventoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    public Inventory createInventory(Inventory inventory) throws InvalidInventoryException {
        if (inventory.getHeight() <= 0) {
            throw new InvalidInventoryException("Height must be greater than 0");
        } else if (inventory.getWeight() <= 0) {
            throw new InvalidInventoryException("Length must be greater than 0");
        } else if (inventory.getWidth() <= 0) {
            throw new InvalidInventoryException("Width must be greater than 0");
        }

        return inventoryRepository.save(inventory);

    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory checkIn(int id, List<InventoryItem> inventoryItems) {
        Inventory inventory = inventoryRepository.getById(id);
        for ( InventoryItem inventoryItem : inventoryItems) {
             inventory.checkIn(inventoryItem);
        }
        return inventoryRepository.save(inventory);
    }
}
