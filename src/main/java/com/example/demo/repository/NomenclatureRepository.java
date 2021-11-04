package com.example.demo.repository;


import com.example.demo.entity.Nomenclature;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NomenclatureRepository extends PagingAndSortingRepository<Nomenclature, Integer> {
    Nomenclature findByCode(String code);
}
