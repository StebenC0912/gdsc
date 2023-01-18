package org.project.gdsc.infrastructure.controller;

import org.project.gdsc.domain.model.Inventory;
import org.project.gdsc.domain.model.InventoryItem;
import org.project.gdsc.domain.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
    private InventoryService inventoryService;
    @PostMapping
    public ResponseEntity<Integer> createInventory(@RequestBody Inventory inventory) throws Exception{
        inventoryService.createInventory(inventory);
        return new ResponseEntity<>(inventory.getId(), HttpStatus.resolve(200));
    }
    @PostMapping
    public ResponseEntity<List<Inventory>> getAllInventory() {
        List<Inventory> inventories = inventoryService.getAllInventory();
        return new ResponseEntity<>(inventories, HttpStatus.resolve(200));
    }
    @PostMapping("{id}/check-in")
    public ResponseEntity<Inventory> checkIn(@PathVariable int id, List<InventoryItem> inventoryItems) {
        Inventory inventory = inventoryService.checkIn(id, inventoryItems);
        return new ResponseEntity<>(inventory, HttpStatus.resolve(200));
    }
}
