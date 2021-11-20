package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.DocumentRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProducts(Product document) {

        System.out.println("saveProducts " + document);

        this.productRepository.save(document);
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Не найден заказ с id: " + id);
        }
        return product;
    }

    @Override
    public void confirmProductById(int id) {
        productRepository.confirmProductById(id);
        System.out.println("confirmProductById " + id);
    }

    @Override
    public void getOutProductById(int id) {
        int res = 0;
        int cntNeed = 0;
        int cntExist = 0;
        int nomId = 0;
        int storId = 0;
        int statusId = 0;

        statusId = documentRepository.selectStatusIdByIdNative(id);
        System.out.println("statusId = " + statusId);
        if (statusId == 2) {
            cntNeed = documentRepository.selectCntByIdNative(id);  // сколько нужно в заказ
            nomId = documentRepository.selectNomIdByIdNative(id);  // что нужно в заказ
            storId = documentRepository.selectStorageIdByIdNative(id); // склад
            productRepository.reduceProductByNomId(nomId, cntNeed, storId); // списать со склада
            res = documentRepository.updateStatusByIdNative(id, 2, 3); // обновить статус заказа

            if (res != 0) {
                System.out.println("статус изменен, cnt =" + cntNeed + " cnt2= " + cntExist);
            } else {
                System.out.println("статус не изменен");
            }
        }
        System.out.println("getOutProductById " + id + " res = " + res);
    }

}
