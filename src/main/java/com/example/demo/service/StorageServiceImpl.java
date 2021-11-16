package com.example.demo.service;

import com.example.demo.entity.Storage;
import com.example.demo.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageRepository storageRepository;

    @Override
    public Iterable<Storage> getAllStorages() {

        return storageRepository.findAll();
    }

    @Override
    public Storage getStorageById(int id) {
        Optional< Storage > optional = storageRepository.findById(id);
        Storage storage;
        if (optional.isPresent()) {
            storage = optional.get();
        } else {
            throw new RuntimeException("Не найден склад с id: " + id);
        }
        return storage;
    }

}
