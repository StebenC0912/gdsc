package org.project.gdsc.domain.service;

import org.project.gdsc.domain.model.Inventory;
import org.project.gdsc.domain.model.InventoryItem;
import org.project.gdsc.infrastructure.controller.InvalidInventoryException;

import java.util.List;

public interface InventoryService {
    Inventory createInventory(Inventory inventory) throws InvalidInventoryException;
    List<Inventory> getAllInventory();
    Inventory checkIn(int id, List<InventoryItem> inventoryItems);
}
