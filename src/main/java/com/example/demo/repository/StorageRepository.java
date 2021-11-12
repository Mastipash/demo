package com.example.demo.repository;

import com.example.demo.entity.Storage;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface StorageRepository extends PagingAndSortingRepository<Storage, Integer> {
}