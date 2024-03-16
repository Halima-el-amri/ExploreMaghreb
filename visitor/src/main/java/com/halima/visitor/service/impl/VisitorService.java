package com.halima.visitor.service.impl;

import com.halima.visitor.dto.VisitorDTO;
import com.halima.visitor.model.Visitor;
import com.halima.visitor.repository.VisitorRepository;
import com.halima.visitor.service.interfaces.IVisitorService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VisitorService implements IVisitorService {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VisitorRepository visitorRepository;

    public VisitorDTO convertToDTO(Visitor visitor) {
        return modelMapper.map(visitor, VisitorDTO.class);
    }

    public Visitor convertToEntity(VisitorDTO visitorDTO) {
        return modelMapper.map(visitorDTO, Visitor.class);
    }
    @Override
    @Transactional
    public VisitorDTO getVisitorById(Long visitorId) {
        Visitor visitor = visitorRepository.findById(visitorId).orElse(null);
        return convertToDTO(visitor);
    }
    @Override
    @Transactional
    public List<VisitorDTO> getAllVisitors() {
        List<Visitor> visitors = visitorRepository.findAll();
        return visitors.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @Override
    @Transactional
    public void saveVisitor(VisitorDTO visitorDTO) {
        Visitor visitor = convertToEntity(visitorDTO);
        visitorRepository.save(visitor);
    }

    @Override
    @Transactional
    public VisitorDTO updateVisitor(VisitorDTO visitorDTO) {
        try {
            Optional<Visitor> visitor = visitorRepository.findById(visitorDTO.getId());
            if (visitor.isPresent()) {
                modelMapper.map(visitorDTO, visitor.get());
                visitorRepository.save(visitor.get());
                return convertToDTO(visitor.get());
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error updating visitor", e);
        }
    }

    @Override
    @Transactional
    public void deleteVisitor(Long visitorId) {
        try {
            visitorRepository.deleteById(visitorId);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting visitor", e);
        }
    }
}