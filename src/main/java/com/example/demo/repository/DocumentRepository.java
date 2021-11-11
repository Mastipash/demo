package com.example.demo.repository;

import com.example.demo.entity.Document;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DocumentRepository extends PagingAndSortingRepository<Document, Integer> {
    //   Document findById(String id);

    @Query(

            value = "SELECT d.*,n.* as DSC FROM document d left join nomenclature n on d.nomenclature_id = n.id WHERE d.status_id = ?1",
            nativeQuery = true)
    Document findDocByStatusNative(Integer statusId);

}
