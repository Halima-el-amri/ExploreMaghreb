package com.halima.guidtourservice.controller;


import com.halima.guidtourservice.dto.GuidTourDTO;
import com.halima.guidtourservice.service.impl.GuidTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guidtours")
public class GuidTourController {

    @Autowired
    private GuidTourService guidTourService;

    @GetMapping
    public ResponseEntity<List<GuidTourDTO>> getAllGuidTours() {
        return ResponseEntity.ok(guidTourService.getAllGuidTours());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuidTourDTO> getGuidTourById(@PathVariable int id) {
        return ResponseEntity.ok(guidTourService.getGuidTourById(id));
    }

    @PostMapping
    public ResponseEntity<GuidTourDTO> createGuidTour(@RequestBody GuidTourDTO guidTourDTO) {
        return ResponseEntity.ok(guidTourService.createGuidTour(guidTourDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GuidTourDTO> updateGuidTour(@PathVariable int id, @RequestBody GuidTourDTO guidTourDTO) {
        guidTourDTO.setId(id);
        return ResponseEntity.ok(guidTourService.updateGuidTour(guidTourDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuidTour(@PathVariable int id) {
        guidTourService.deleteGuidTour(id);
        return ResponseEntity.noContent().build();
    }
}