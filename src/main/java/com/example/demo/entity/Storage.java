package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "storage")
@Getter
@Setter
@ToString
@RequiredArgsConstructor//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

   @Column
      private String name;

    @OneToMany(mappedBy="storage")
    private Set<Product> product;

    @OneToMany(mappedBy="storage")
    private Set<Document> document;

    @Column
    private String address;

    @Column(name = "is_pvz")
    private Boolean isPvz;

}
