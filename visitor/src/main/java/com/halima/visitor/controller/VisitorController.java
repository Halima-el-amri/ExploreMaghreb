package com.halima.visitor.controller;

import com.halima.visitor.dto.VisitorDTO;
import com.halima.visitor.service.interfaces.IVisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visitors")
public class VisitorController {

    @Autowired
    private IVisitorService visitorService;

    @GetMapping("/{visitorId}")
    public ResponseEntity<VisitorDTO> getVisitorById(@PathVariable Long visitorId) {
        VisitorDTO visitorDTO = visitorService.getVisitorById(visitorId);
        if (visitorDTO != null) {
            return ResponseEntity.ok(visitorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<VisitorDTO>> getAllVisitors() {
        List<VisitorDTO> visitorDTOList = visitorService.getAllVisitors();
        return ResponseEntity.ok(visitorDTOList);
    }

    @PostMapping
    public ResponseEntity<Void> createVisitor(@RequestBody VisitorDTO visitorDTO) {
        visitorService.saveVisitor(visitorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{visitorId}")
    public ResponseEntity<VisitorDTO> updateVisitor(@PathVariable Long visitorId, @RequestBody VisitorDTO visitorDTO) {
        visitorDTO.setId(visitorId);
        VisitorDTO updatedVisitorDTO = visitorService.updateVisitor(visitorDTO);
        if (updatedVisitorDTO != null) {
            return ResponseEntity.ok(updatedVisitorDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{visitorId}")
    public ResponseEntity<Void> deleteVisitor(@PathVariable Long visitorId) {
        visitorService.deleteVisitor(visitorId);
        return ResponseEntity.noContent().build();
    }

}