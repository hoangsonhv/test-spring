package com.example.testspringboot.controller;

import com.example.testspringboot.entity.District;
import com.example.testspringboot.service.DistrictService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/dístricts")
public class DistrictApi {

    final DistrictService districtService;


    public DistrictApi(DistrictService districtService) {
        this.districtService = districtService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<District>> findAll() {
        return ResponseEntity.ok(districtService.findAll());
    }
}
