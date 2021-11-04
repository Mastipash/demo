package com.example.demo.service;

import com.example.demo.entity.Nomenclature;

public interface NomenclatureService {
    Iterable<Nomenclature> getAllNomenclatures();
    void saveNomenclature(Nomenclature nomenclature);
    Nomenclature getNomenclatureById(int id);

}
