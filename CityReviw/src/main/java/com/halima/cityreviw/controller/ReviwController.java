package com.halima.cityreviw.controller;


import com.halima.cityreviw.dto.ReviwDTO;
import com.halima.cityreviw.service.impl.ReviwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviws")
public class ReviwController {

    @Autowired
    private ReviwService reviwService;

    @GetMapping
    public ResponseEntity<List<ReviwDTO>> getAllReviws() {
        return ResponseEntity.ok(reviwService.getAllReviws());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviwDTO> getReviwById(@PathVariable Long id) {
        return ResponseEntity.ok(reviwService.getReviwById(id));
    }

    @PostMapping
    public ResponseEntity<ReviwDTO> createReviw(@RequestBody ReviwDTO reviwDTO) {
        return ResponseEntity.ok(reviwService.createReviw(reviwDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviwDTO> updateReviw(@PathVariable Long id, @RequestBody ReviwDTO reviwDTO) {
        return ResponseEntity.ok(reviwService.updateReviw(id, reviwDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviw(@PathVariable Long id) {
        reviwService.deleteReviw(id);
        return ResponseEntity.noContent().build();
    }
}