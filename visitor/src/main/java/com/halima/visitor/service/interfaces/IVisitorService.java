package com.halima.visitor.service.interfaces;

import com.halima.visitor.dto.VisitorDTO;

import java.util.List;

public interface IVisitorService {

    VisitorDTO getVisitorById(Long visitorId);

    List<VisitorDTO> getAllVisitors();

    void saveVisitor(VisitorDTO visitorDTO);

    VisitorDTO updateVisitor(VisitorDTO visitorDTO);


    void deleteVisitor(Long visitorId);
}