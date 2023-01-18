package org.project.gdsc.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.project.gdsc.domain.model.Inventory;

import java.util.List;

@Getter
public class InventoryEntity<InventoryItemEntity> {
    private int id;
    private int height;
    private int length;
    private int width;
    private String inventoryItems;

    public static InventoryEntity fromDomainModel(Inventory inventory) {
        final InventoryEntity entity = new InventoryEntity();
        entity.id = inventory.getId();
        entity.height = inventory.getHeight();
        entity.width = inventory.getWidth();
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            entity.inventoryItems = objectMapper.writeValueAsString(inventory.getInventoryItem());
        } catch (Exception e) {
            throw new Error(e);
        }
        return entity;
    }

    public Inventory toDomainModel() {
        final Inventory inventory = new Inventory();
        inventory.setId(id);
        inventory.setHeight(height);
        inventory.setWidth(width);
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            inventory.setInventoryItem(objectMapper.readValue(inventoryItems, List.class));
        } catch (Exception e) {
            throw new Error(e);
        }
        return inventory;
    }
}
