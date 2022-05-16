package com.example.testspringboot.controller;

import com.example.testspringboot.entity.District;
import com.example.testspringboot.entity.Street;
import com.example.testspringboot.repository.StreetRepository;
import com.example.testspringboot.service.DistrictService;
import com.example.testspringboot.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/streets")
public class StreetApi {

    @Autowired
    private StreetService streetService;

    @Autowired
    private DistrictService districtService;

    @RequestMapping(method = RequestMethod.GET, path = "/get-all")
    public List<Street> getList(@RequestParam(defaultValue = "") String name){
        if(name.length() > 0){
            return streetService.findAll(name);
        }else {
            return streetService.findAllStreet();
        }
    }

    @RequestMapping(method = RequestMethod.GET,path = "/get-all-by-district")
    public List<Street> getListByDistrict(@RequestParam(defaultValue = "1") Integer id){
        if(id != null){
            return streetService.findAllByDistrict(id);
        }else {
            return streetService.findAllStreet();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Street save(@RequestBody Street street){
        return streetService.save(street);
    }
}
