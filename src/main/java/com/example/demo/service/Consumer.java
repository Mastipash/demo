package com.example.demo.service;

import com.example.demo.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;

@Service
public class Consumer {

    @Autowired
    private DocumentServiceImpl docServiceImpl;

    @Autowired
    private NomenclatureServiceImpl nomenclatureServiceImpl;

    @Autowired
    private DocStatusServiceImpl docStatusServiceImpl;

    @Autowired
    private StorageServiceImpl storageServiceImpl;

    private Document document;
    private Nomenclature nomenclature;
    private DocStatus docStatus;
    private Storage storage;
    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    private Integer nomId, statusId, storId;
    private Date dtStart;


    @KafkaListener(topics = "orders", groupId = "group_id")
    public void consume(Order order) {
        logger.info(String.format("#### -> Consumed message -> %s", order));
        document = convertOrderToDocument(order);
        System.out.println(document);
        docServiceImpl.saveDocuments(document);
    }

    private Document convertOrderToDocument(Order order) {
        nomId = order.getNomId();
        dtStart = new Date();
        nomenclature = new Nomenclature(
                nomId,
                nomenclatureServiceImpl.getNomenclatureById(nomId).getCode(),
                nomenclatureServiceImpl.getNomenclatureById(nomId).getDescription(),
                nomenclatureServiceImpl.getNomenclatureById(nomId).getPrice()
        );
        statusId = order.getStatusId();
        docStatus = new DocStatus(
                statusId,
                docStatusServiceImpl.getDocStatusById(statusId).getName()
        );
        storId = order.getStorId();
        storage = new Storage(
                storId,
                storageServiceImpl.getStorageById(storId).getName(),
                storageServiceImpl.getStorageById(storId).getAddress(),
                storageServiceImpl.getStorageById(storId).getIsPvz()
        );

        document = new Document(
                order.getDocNum(),
                dtStart,
                nomenclature,
                order.getCnt(),
                docStatus,
                storage
        );
        return document;
    }


}
