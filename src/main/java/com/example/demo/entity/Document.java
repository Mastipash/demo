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
@Table(name = "document")
@Getter
@Setter
@ToString
@RequiredArgsConstructor//ломбок аннотация: генерирует геттеры, сеттеры, иквалс, хеш код методы

public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "doc_num")
    private String docNum;

    @Column(name = "dt_start")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dtStart;

    @ManyToOne
    @JoinColumn(name="nomenclature_id", nullable=false)
    private Nomenclature nomenclature;

    @Column
    private Integer cnt;

    @ManyToOne
    @JoinColumn(name="status_id", nullable=false)
    private DocStatus docStatus;

    @ManyToOne
    @JoinColumn(name="storage_id", nullable=false)
    private Storage storage;

    public Document(String docNum, Date dtStart, Nomenclature nomenclature, Integer cnt, DocStatus docStatus, Storage storage) {
        this.docNum = docNum;
        this.dtStart = dtStart;
        this.nomenclature = nomenclature;
        this.cnt = cnt;
        this.docStatus = docStatus;
        this.storage = storage;
    }
}
