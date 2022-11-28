package com.indivara.ecommerce.controller;

import com.indivara.ecommerce.entity.Pengguna;
import com.indivara.ecommerce.service.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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
    
    @GetMapping("/pengguna/{id}")
    public Pengguna findById(@PathVariable("id") String id){
        return penggunaService.findById(id);
    }

    @PostMapping("/pengguna")
    public Pengguna create(Pengguna pengguna){
        return penggunaService.create(pengguna);
    }

    @PutMapping("/pengguna")
    public Pengguna edit(Pengguna pengguna){
        return penggunaService.edit(pengguna);
    }

    @DeleteMapping("/pengguna/{id}")
    public void deleteById(@PathVariable("id") String id){
        penggunaService.deleteById(id);
    }

}
