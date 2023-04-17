package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.assignment.CsvData;
import com.example.repository.CsvDataRepository;

@Service
public class CsvDataService {
	
    private CsvDataRepository repository;
    
    @Autowired
    public CsvDataService(CsvDataRepository repository) {
        this.repository = repository;
    }
    
    public void saveCsvData(List<CsvData> csvDataList) {
        repository.saveAll(csvDataList);
    }
    
    public List<CsvData> getAllCsvData() {
        return (List<CsvData>) repository.findAll();
    }
    
    public CsvData getCsvDataByCode(String code) {
        return repository.findById(code).orElse(null);
    }
    
    public void deleteAllCsvData() {
        repository.deleteAll();
    }
}



