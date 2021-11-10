package com.example.demo.service;

import com.example.demo.entity.Document;

public interface DocumentService {
    Iterable<Document> getAllDocuments();
    void saveDocument(Document nomenclature);
    Document getDocumentById(int id);

}
