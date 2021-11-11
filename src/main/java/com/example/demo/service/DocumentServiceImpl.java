package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Iterable<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public void saveDocuments(Document document) {
        this.documentRepository.save(document);
    }

    @Override
    public Document getDocumentById(int id) {
        Optional < Document > optional = documentRepository.findById(id);
        Document document;
        if (optional.isPresent()) {
            document = optional.get();
        } else {
            throw new RuntimeException("Не найден заказ с id: " + id);
        }
        return document;
    }

}
