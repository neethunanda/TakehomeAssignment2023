/**
 * 
 */
package com.example.controller;

import java.io.Reader;
import java.util.List;
import java.util.Optional;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.assignment.CsvData;
import com.example.repository.CsvDataRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * @author NEETHU NANDAKUMAR
 *
 */
@RestController
@RequestMapping("/csv")

public class CsvDataController {
	
    @Autowired
    private CsvDataRepository csvDataRepository;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCsvData(@RequestParam("file") MultipartFile file)
    {
        try 
        (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream())))
        {
            CsvToBean<CsvData> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<CsvData> csvDataList = csvToBean.parse();
            csvDataRepository.saveAll(csvDataList);
            return ResponseEntity.ok("CSV data uploaded successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while uploading CSV data");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<CsvData>> getAllCsvData() {
        List<CsvData> csvDataList = csvDataRepository.findAll();
        return ResponseEntity.ok(csvDataList);
    }

    @GetMapping("/by-code")
    public ResponseEntity<CsvData> getCsvDataByCode(@RequestParam String code) {
        Optional<CsvData> csvDataOptional = csvDataRepository.findById(code);
        if (csvDataOptional.isPresent()) {
            return ResponseEntity.ok(csvDataOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAllCsvData() {
        csvDataRepository.deleteAll();
        return ResponseEntity.ok("All CSV data deleted successfully");
    }


}
