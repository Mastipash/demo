package com.example.demo.repository;

import com.example.demo.entity.Document;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DocumentRepository extends PagingAndSortingRepository<Document, Integer> {
        Document findById(String id);
}
