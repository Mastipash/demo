package com.example.demo.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Nomenclature;
import com.example.demo.repository.NomenclatureRepository;

@Service
public class NomenclatureServiceImpl implements NomenclatureService{

    @Autowired
    private NomenclatureRepository nomenclatureRepository;

    @Override
    public Iterable<Nomenclature> getAllNomenclatures() {
        return nomenclatureRepository.findAll();
    }

    @Override
    public void saveNomenclature(Nomenclature nomenclature) {
        nomenclatureRepository.save(nomenclature);
    }

    @Override
    public Nomenclature getNomenclatureById(int id) {
        Optional < Nomenclature > optional = nomenclatureRepository.findById(id);
        Nomenclature nomenclature;
        if (optional.isPresent()) {
            nomenclature = optional.get();
        } else {
            throw new RuntimeException("Не найден товар с id: " + id);
        }
        return nomenclature;
    }

}
