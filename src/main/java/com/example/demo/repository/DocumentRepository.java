package com.example.demo.repository;

import com.example.demo.entity.Document;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface DocumentRepository extends PagingAndSortingRepository<Document, Integer> {
    //   Document findById(String id);


    @Modifying
    @Transactional
    @Query(
            value = "update document set status_id = 2 where id = ?1 and status_id = 1",
            nativeQuery = true)
    Integer updateStatusByIdNative(Integer Id);


    @Query(
            value = "select cnt from  document where id = ?1",
            nativeQuery = true)
    Integer selectCntByIdNative(Integer Id);

    @Query(
            value = "select nomenclature_id from  document where id = ?1",
            nativeQuery = true)
    Integer selectNomIdByIdNative(Integer Id);

    @Query(
            value = "select storage_id from  document where id = ?1",
            nativeQuery = true)
    Integer selectStorageIdByIdNative(Integer Id);

    @Query(
            value = "select status_id from  document where id = ?1",
            nativeQuery = true)
    Integer selectStatusIdByIdNative(Integer Id);

}
