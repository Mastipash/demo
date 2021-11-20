package com.example.demo.service;

import java.util.Optional;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Document;
import com.example.demo.repository.DocumentRepository;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public void saveDocuments(Document document) {
        this.documentRepository.save(document);
    }

    @Override
    public Document getDocumentById(int id) {
        Optional<Document> optional = documentRepository.findById(id);
        Document document;
        if (optional.isPresent()) {
            document = optional.get();
        } else {
            throw new RuntimeException("Не найден заказ с id: " + id);
        }
        return document;
    }

    @Override
    public void docMoove(int id) {
        int res = 0;
        int cntNeed = 0;
        int cntExist = 0;
        int nomId = 0;
        int storId = 0;
        int statusId = 0;

        statusId = documentRepository.selectStatusIdByIdNative(id);
        if (statusId == 1) {
            cntNeed = documentRepository.selectCntByIdNative(id);  // сколько нужно в заказ
            nomId = documentRepository.selectNomIdByIdNative(id);  // что нужно в заказ
            storId = documentRepository.selectStorageIdByIdNative(id); // куда перемещать
            cntExist = productRepository.selectCntProdByNomId(nomId, cntNeed); // есть ли нужное кол-во товара на складе (1 - есть, 0 - нет)
            System.out.println("nomId= " + nomId + " нужно  = " + cntNeed + " достаточно ли на сладе? - " + cntExist);

            if (cntExist != 0) {

                productRepository.reduceProductByNomId(nomId, cntNeed, 1); // списать с основного склада
                productRepository.insertIntoPVZByNomId(nomId, cntNeed, storId);  // переместить в ПВЗ
                res = documentRepository.updateStatusByIdNative(id,1,2); // обновить статус заказа
            }

            if (res != 0) {
                System.out.println("статус изменен, cnt =" + cntNeed + " cnt2= " + cntExist);
            } else {
                System.out.println("статус не изменен");
            }
        }
        System.out.println("docMoove " + id + " res = " + res);
    }

}
