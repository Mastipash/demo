package com.example.demo.repository;

import com.example.demo.entity.DocStatus;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DocStatusRepository  extends PagingAndSortingRepository<DocStatus, Integer> {
}
