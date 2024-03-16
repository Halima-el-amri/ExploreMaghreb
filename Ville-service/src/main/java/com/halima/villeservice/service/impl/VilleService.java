package com.halima.villeservice.service.impl;


import com.halima.villeservice.dto.VilleDto;
import com.halima.villeservice.model.Ville;
import com.halima.villeservice.repository.VilleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VilleService {

    @Autowired
    private VilleRepository villeRepository;

    public VilleDto createVille(VilleDto villeDto) {
        Ville ville = new Ville();
        BeanUtils.copyProperties(villeDto, ville);
        Ville savedVille = villeRepository.save(ville);
        VilleDto savedVilleDto = new VilleDto();
        BeanUtils.copyProperties(savedVille, savedVilleDto);
        return savedVilleDto;
    }

    public VilleDto getVille(Long id) {
        Ville ville = villeRepository.findById(id).orElse(null);
        if (ville != null) {
            VilleDto villeDto = new VilleDto();
            BeanUtils.copyProperties(ville, villeDto);
            return villeDto;
        }
        return null;
    }

    public List<VilleDto> getAllVilles() {
        return villeRepository.findAll().stream().map(ville -> {
            VilleDto villeDto = new VilleDto();
            BeanUtils.copyProperties(ville, villeDto);
            return villeDto;
        }).collect(Collectors.toList());
    }

    public VilleDto updateVille(Long id, VilleDto villeDto) {
        Ville ville = villeRepository.findById(id).orElse(null);
        if (ville != null) {
            BeanUtils.copyProperties(villeDto, ville);
            Ville updatedVille = villeRepository.save(ville);
            VilleDto updatedVilleDto = new VilleDto();
            BeanUtils.copyProperties(updatedVille, updatedVilleDto);
            return updatedVilleDto;
        }
        return null;
    }

    public void deleteVille(Long id) {
        villeRepository.deleteById(id);
    }
}