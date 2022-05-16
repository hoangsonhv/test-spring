package com.example.testspringboot.service;

import com.example.testspringboot.entity.Street;
import com.example.testspringboot.repository.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public List<Street> findAll(String name){
        return streetRepository.search(name);
    }

    public List<Street> findAllStreet(){
        return streetRepository.findAll();
    }

    public List<Street> findAllByDistrict(Integer id, int page, int limit){
        return streetRepository.searchByDistrict(id);
    }

    public Street save(Street street) {
        return streetRepository.save(street);
    }
}
