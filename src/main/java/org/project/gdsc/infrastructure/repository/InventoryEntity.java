package org.project.gdsc.infrastructure.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.project.gdsc.domain.model.Inventory;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "inventory")

public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private int id;
    @Column (name = "height")
    private int height;
    @Column (name = "weight")
    private int weight;
    @Column (name = "width")
    private int width;
    @Column (name = "inventoryItems")
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
        Inventory inventory = new Inventory();
        inventory.setId(id);
        inventory.setHeight(height);
        inventory.setWidth(width);
        inventory.setWeight(weight);
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            inventory.setInventoryItem(objectMapper.readValue(inventoryItems, List.class));
        } catch (Exception e) {
            throw new Error(e);
        }
        return inventory;
    }
}
