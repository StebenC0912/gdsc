package org.project.gdsc.domain.model;

import java.util.Collections;
import java.util.List;
import org.springframework.data.annotation.Id;
import lombok.Getter;

@Getter
public class Inventory {
    @Id
    private int id;
    private int height;
    private int weight;
    private int width;
    private List<InventoryItem> inventoryItem;

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<InventoryItem> getInventInventoryItems() {
        return Collections.unmodifiableList(inventoryItem);
    }
}
