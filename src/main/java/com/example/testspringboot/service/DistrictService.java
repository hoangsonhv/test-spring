package com.example.testspringboot.service;

import com.example.testspringboot.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;
}
