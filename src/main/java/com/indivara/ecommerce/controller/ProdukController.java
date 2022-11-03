package com.indivara.ecommerce.controller;

import com.indivara.ecommerce.entity.Produk;
import com.indivara.ecommerce.service.ProdukService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdukController {

    @Autowired
    private ProdukService produkService;

    @GetMapping("/produk")
    public List<Produk> findAll(){
        return produkService.findAll();
    }

    @GetMapping("/produk/{id}")
    public Produk findById(@PathVariable("id") String id){
        return produkService.findById(id);
    }

    @PostMapping("/produk")
    public Produk create(@RequestBody Produk produk){
        return produkService.create(produk);
    }

    @PutMapping("/produk")
    public Produk edit(@RequestBody Produk produk){
        return produkService.edit(produk);
    }

    @DeleteMapping("/produk/{id}")
    public void deleteById(@PathVariable("id") String id){
        produkService.deleteById(id);
    }

}
