package com.example.demo.service;

import com.example.demo.entity.Storage;

public interface StorageService {
    Iterable<Storage> getAllStorages();
    Storage getStorageById(int id);

}
