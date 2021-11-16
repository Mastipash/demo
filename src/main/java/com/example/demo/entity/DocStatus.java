package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "doc_status")
@Getter
@Setter
@ToString
@RequiredArgsConstructor//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы
public class DocStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

     @OneToMany(mappedBy="docStatus")
    private Set<Document> document;

}
