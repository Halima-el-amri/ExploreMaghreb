package com.halima.guidtourservice.service.interfaces;

import com.halima.guidtourservice.dto.GuidTourDTO;
import jakarta.transaction.Transactional;

import java.util.List;

public interface IGuidTour {
    List<GuidTourDTO> getAllGuidTours();

    GuidTourDTO getGuidTourById(int id);

    @Transactional
    GuidTourDTO createGuidTour(GuidTourDTO guidTourDTO);

    @Transactional
    GuidTourDTO updateGuidTour(GuidTourDTO guidTourDTO);

    @Transactional
    void deleteGuidTour(int id);
}
