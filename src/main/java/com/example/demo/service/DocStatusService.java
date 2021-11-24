package com.example.demo.service;

import com.example.demo.entity.DocStatus;
import com.example.demo.entity.Nomenclature;

public interface DocStatusService {

    Iterable<DocStatus> getAllDocStatus();

    DocStatus getDocStatusById(int id);


}
