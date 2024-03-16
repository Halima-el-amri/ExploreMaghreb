package com.halima.guidtourservice.service.impl;

import com.halima.guidtourservice.dto.GuidTourDTO;
import com.halima.guidtourservice.model.GuidTour;
import com.halima.guidtourservice.repository.GuidTourRepository;
import com.halima.guidtourservice.service.interfaces.IGuidTour;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GuidTourService implements IGuidTour {

    @Autowired
    private GuidTourRepository guidTourRepository;
    @Autowired
    private ModelMapper modelMapper;

    public GuidTourDTO convertToDTO(GuidTour guidTour) {
        return modelMapper.map(guidTour, GuidTourDTO.class);
    }

    public GuidTour convertToEntity(GuidTourDTO guidTourDTO) {
        return modelMapper.map(guidTourDTO, GuidTour.class);
    }

    @Override
    public List<GuidTourDTO> getAllGuidTours(){
        List<GuidTour> guidTours= guidTourRepository.findAll();
        return guidTours.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    @Override

    public GuidTourDTO getGuidTourById(int id) {
        GuidTour guidTour = guidTourRepository.findById(id).orElseThrow(() -> new RuntimeException("GuidTour not found"));
        return convertToDTO(guidTour);
    }
    @Override
    @Transactional
    public GuidTourDTO createGuidTour(GuidTourDTO guidTourDTO){
        GuidTour guidTour = convertToEntity(guidTourDTO);
        guidTourRepository.save(guidTour);
        return convertToDTO(guidTour);
    }
    @Override

    @Transactional
    public GuidTourDTO updateGuidTour(GuidTourDTO guidTourDTO) {
        try {
            Optional<GuidTour> guidTour = guidTourRepository.findById(guidTourDTO.getId());
            if (guidTour.isPresent()) {
                modelMapper.map(guidTourDTO, guidTour.get());
                guidTourRepository.save(guidTour.get());
                return convertToDTO(guidTour.get());
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Error updating guid tour", e);
        }
    }
    @Override
    @Transactional
    public void deleteGuidTour(int id) {
        try {
            guidTourRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting guid tour", e);
        }
    }
}