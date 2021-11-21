package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    @Modifying
    @Transactional
    @Query(
            value = "update product set cnt = cnt + cnt_change, cnt_change = 0 where id = ?1",
            nativeQuery = true)
    void confirmProductById(Integer id);

    @Query(
            value = "SELECT count(1) from  product where nomenclature_id = ?1 and storage_id = 1 and cnt >= ?2 and cnt_change >= ?3",
            nativeQuery = true)
    Integer selectCntProdByNomId(Integer nomId, Integer cnt, Integer cntChange);


    @Modifying
    @Transactional
    @Query(
            value = "update product set cnt = cnt - ?2 where nomenclature_id = ?1 and storage_id = ?3",
            nativeQuery = true)
    void reduceProductByNomId(Integer nomId, Integer cnt, Integer storId);

    @Modifying
    @Transactional
    @Query(
            value = "insert into product (dt_start, dt_end, nomenclature_id, cnt, storage_id)\n" +
                    "values (current_timestamp, current_timestamp,?1,?2,?3)",
            nativeQuery = true)
    void insertIntoPVZByNomId(Integer nomId, Integer cnt, Integer storId);

    @Modifying
    @Transactional
    @Query(
            value = "delete from product where nomenclature_id = ?1 and storage_id = ?3 and cnt = ?2",
            nativeQuery = true)
    void getOutProductById(Integer nomId, Integer cnt, Integer storId);

    @Query(
            value = "SELECT id from product where nomenclature_id = ?1 and storage_id = 1",
            nativeQuery = true)
    Integer selectIdProdByNomId(Integer nomId);

    @Query(
            value = "select cnt from  product where id = ?1 and storage_id = 1 ",
            nativeQuery = true)
    Integer selectCntProductByIdNative(Integer Id);

}
