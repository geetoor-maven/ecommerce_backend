package com.indivara.ecommerce.service;

import com.indivara.ecommerce.entity.Produk;
import com.indivara.ecommerce.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdukService {

    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> findAll(){
        return produkRepository.findAll();
    }

}
