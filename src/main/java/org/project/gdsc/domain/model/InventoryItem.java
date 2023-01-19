package org.project.gdsc.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryItem {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "height")
    private int height;

    @Column(name = "weight")
    private int weight;

    @Column(name = "width")
    private int width;

    public double volumn() {
        return height * weight * width;
    }
}
