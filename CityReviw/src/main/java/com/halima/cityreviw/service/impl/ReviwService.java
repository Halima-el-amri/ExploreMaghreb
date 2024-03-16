package com.halima.cityreviw.service.impl;

import com.halima.cityreviw.dto.ReviwDTO;
import com.halima.cityreviw.model.Reviw;
import com.halima.cityreviw.repository.ReviwRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviwService {

    @Autowired
    private ReviwRepository reviwRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<ReviwDTO> getAllReviws() {
        return reviwRepository.findAll()
                .stream()
                .map(reviw -> modelMapper.map(reviw, ReviwDTO.class))
                .collect(Collectors.toList());
    }

    public ReviwDTO getReviwById(Long id) {
        Reviw reviw = reviwRepository.findById(id).orElseThrow(() -> new RuntimeException("Reviw not found"));
        return modelMapper.map(reviw, ReviwDTO.class);
    }

    public ReviwDTO createReviw(ReviwDTO reviwDTO) {
        Reviw reviw = modelMapper.map(reviwDTO, Reviw.class);
        reviw = reviwRepository.save(reviw);
        return modelMapper.map(reviw, ReviwDTO.class);
    }

    public ReviwDTO updateReviw(Long id, ReviwDTO reviwDTO) {
        Reviw reviw = reviwRepository.findById(id).orElseThrow(() -> new RuntimeException("Reviw not found"));
        reviw = modelMapper.map(reviwDTO, Reviw.class);
        reviw.setId(id);
        reviw = reviwRepository.save(reviw);
        return modelMapper.map(reviw, ReviwDTO.class);
    }

    public void deleteReviw(Long id) {
        Reviw reviw = reviwRepository.findById(id).orElseThrow(() -> new RuntimeException("Reviw not found"));
        reviwRepository.delete(reviw);
    }
}