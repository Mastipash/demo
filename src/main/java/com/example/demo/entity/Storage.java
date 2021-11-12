package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

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
    private Integer name;

    @Column
    private Integer address;

    @Column (name = "is_pvz")
    private Integer isPvz;

}
