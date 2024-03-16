package com.halima.villeservice.controller;



import com.halima.villeservice.dto.VilleDto;
import com.halima.villeservice.service.impl.VilleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/villes")
public class VilleController {

    @Autowired
    private VilleService villeService;

    @PostMapping
    public ResponseEntity<VilleDto> createVille(@Valid @RequestBody VilleDto villeDto) {
        return ResponseEntity.ok(villeService.createVille(villeDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VilleDto> getVille(@PathVariable Long id) {
        VilleDto villeDto = villeService.getVille(id);
        if (villeDto != null) {
            return ResponseEntity.ok(villeDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<VilleDto>> getAllVilles() {
        return ResponseEntity.ok(villeService.getAllVilles());
    }

    @PutMapping("/{id}")
    public ResponseEntity<VilleDto> updateVille(@PathVariable Long id, @Valid @RequestBody VilleDto villeDto) {
        VilleDto updatedVilleDto = villeService.updateVille(id, villeDto);
        if (updatedVilleDto != null) {
            return ResponseEntity.ok(updatedVilleDto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVille(@PathVariable Long id) {
        villeService.deleteVille(id);
        return ResponseEntity.noContent().build();
    }
}