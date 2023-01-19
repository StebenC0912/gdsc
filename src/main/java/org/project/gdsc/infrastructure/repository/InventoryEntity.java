package org.project.gdsc.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.project.gdsc.domain.model.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class InventoryEntity {
    @Id
    private int id;
    private int height;
    private int weight;
    private int width;
    private String inventoryItems;
    public <InventoryItemEntity> InventoryEntity(Inventory inventory) {
        this.id = inventory.getId();
        this.weight = inventory.getWeight();
        this.width = inventory.getWidth();
        this.height = inventory.getHeight();
        if (inventory.getInventoryItem() != null) {
            this.inventoryItems = inventory.getInventoryItem().stream().map(inventoryItem -> {
                InventoryItemEntities item = new InventoryItemEntities(inventoryItem);
                item.setInventory(this);
                return item;
            }).collect(Collectors.toList()).toString();
        } else {
            this.inventoryItems = new ArrayList<>().toString();
        }
    }
    public static InventoryEntity fromDomainModel(Inventory inventory) {
        final InventoryEntity entity = new InventoryEntity(inventory);
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
