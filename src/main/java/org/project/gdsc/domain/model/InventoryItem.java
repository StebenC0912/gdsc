package org.project.gdsc.domain.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class InventoryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private int height;
    private int weight;
    private int width;

    public void setId(Long id) {
        this.id = id;
    }

    public double volumn() {
        return height * weight * width;
    }


}
