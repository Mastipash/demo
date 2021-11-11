package com.example.demo.service;

import com.example.demo.entity.Document;

public interface DocumentService {
    Iterable<Document> getAllDocuments();
    void saveDocuments(Document document);
    Document getDocumentById(int id);


}
