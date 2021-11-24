package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "nomenclature")
@Getter
@Setter
@RequiredArgsConstructor//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы

public class Nomenclature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String code;

    @Column
    private String description;

    @Column(nullable = false)
    private int price;

    @OneToMany(mappedBy = "storage")
    private Set<Document> document;

    @OneToMany(mappedBy = "storage")
    private Set<Product> product;

    public Integer getId() {
        return id;
    }
}
