package com.example.demo.service;


import com.example.demo.entity.DocStatus;
import com.example.demo.entity.Nomenclature;
import com.example.demo.repository.DocStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DocStatusServiceImpl implements DocStatusService {

    @Autowired
    private DocStatusRepository docStatusRepository;

    @Override
    public Iterable<DocStatus> getAllDocStatus() {
        return docStatusRepository.findAll();
    }

    @Override
    public DocStatus getDocStatusById(int id) {
        Optional< DocStatus > optional = docStatusRepository.findById(id);
        DocStatus docStatus;
        if (optional.isPresent()) {
            docStatus = optional.get();
        } else {
            throw new RuntimeException("Не найден статус с id: " + id);
        }
        return docStatus;
    }
}