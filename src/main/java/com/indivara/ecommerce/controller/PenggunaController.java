package com.indivara.ecommerce.controller;

import com.indivara.ecommerce.entity.Pengguna;
import com.indivara.ecommerce.service.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PenggunaController {

    @Autowired
    private PenggunaService penggunaService;

    @GetMapping("/pengguna")
    public List<Pengguna> findAll(){
        return penggunaService.findAll();
    }

    @GetMapping("/pengguna")
    public Pengguna findById(String id){
        return penggunaService.findById(id);
    }

    
}
