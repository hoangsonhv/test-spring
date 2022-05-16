package com.example.testspringboot.controller;

import com.example.testspringboot.entity.Street;
import com.example.testspringboot.repository.StreetRepository;
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
    private StreetRepository streetRepository;

    @RequestMapping(method = RequestMethod.GET,path = "/get-all")
    public List<Street> getList(@RequestParam(defaultValue = "") String name){
        if(name.length() > 0){
            return streetService.findAll(name);
        }else {
            return streetService.findAllStreet();
        }
    }

    @RequestMapping(method = RequestMethod.GET,path = "/get")
    public List<Street> getListAll(){
        return streetService.findAllStreet();
    }

    @RequestMapping(method = RequestMethod.GET,path = "/get-all-by-district")
    public List<Street> getList(@RequestParam(defaultValue = "1") Integer id,
                                @RequestParam(defaultValue = "1") int page,
                                @RequestParam(defaultValue = "10") int limit){
        if(id != null){
            return streetRepository.searchByDistrict(id);
        }else {
            return streetService.findAllStreet();
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public Street save(@RequestBody Street street){
        streetService.save(street);
        return street;
    }
}
