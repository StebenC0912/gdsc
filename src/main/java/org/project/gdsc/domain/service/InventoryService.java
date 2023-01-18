package org.project.gdsc.domain.service;

import org.project.gdsc.domain.model.Inventory;
import org.project.gdsc.domain.model.InventoryItem;
import org.project.gdsc.domain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public void createInventory(Inventory inventory) throws Exception {
        if (inventory.getHeight() < 0) {
            throw new Exception("height phải lớn hơn 0");
        } else if (inventory.getWeight() < 0) {
            throw new Exception("weight phải lớn hơn 0");
        } else if (inventory.getWidth() < 0) {
            throw new Exception("width phải lớn hơn 0");
        } else {
            inventoryRepository.save(inventory);
        }

    }
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }
    public Inventory checkIn(int inventoryId, List<InventoryItem> inventoryItems) {
        final Inventory inventory = inventoryRepository.getById(inventoryId);
        for (InventoryItem inventoryItem : inventoryItems) {
            inventory.checkIn(inventoryItem);
        }
        inventoryRepository.save(inventory);
        return inventoryRepository.getById(inventoryId);
    }
}
