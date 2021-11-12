package com.example.demo.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@RequiredArgsConstructor//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dt_start")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dtStart;

    @Column(name = "nomenclature_id")
    private Integer nomenclatureId;

    @Column
    private Integer cnt;

    @Column(name = "storage_id")
     private Integer storageId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product that = (Product) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
