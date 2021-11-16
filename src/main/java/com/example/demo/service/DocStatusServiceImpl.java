package com.example.demo.service;


import com.example.demo.entity.DocStatus;
import com.example.demo.repository.DocStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DocStatusServiceImpl implements DocStatusService {

    @Autowired
    private DocStatusRepository docStatusRepository;

    @Override
    public Iterable<DocStatus> getAllDocStatus() {
        return docStatusRepository.findAll();
    }
}