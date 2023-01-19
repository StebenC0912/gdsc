package org.project.gdsc.infrastructure.controller;

import org.project.gdsc.domain.model.Inventory;
import org.project.gdsc.domain.model.InventoryItem;
import org.project.gdsc.domain.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @PostMapping
    public ResponseEntity<Integer> createInventory(@RequestBody Inventory inventory) throws Exception {
        try {
            Inventory createdInventory = inventoryService.createInventory(inventory);
            return new ResponseEntity<>(createdInventory.getId(), HttpStatus.OK);
        } catch (InvalidInventoryException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> inventories = inventoryService.getAllInventory();
        return new ResponseEntity<>(inventories, HttpStatus.OK);
    }
    @PostMapping("{id}/check-in")
    public ResponseEntity<Inventory> checkIn(@PathVariable int id, List<InventoryItem> inventoryItems) {
        Inventory inventory = inventoryService.checkIn(id, inventoryItems);
        return new ResponseEntity<>(inventory, HttpStatus.OK);
    }
}
