package com.example.testspringboot.service;

import com.example.testspringboot.entity.District;
import com.example.testspringboot.entity.Street;
import com.example.testspringboot.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    public List<District> findAll(){
        return districtRepository.findAll();
    }

    public Optional<District> findById(Integer id) {
        return districtRepository.findById(id);
    }
}
