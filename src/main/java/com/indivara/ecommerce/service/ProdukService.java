package com.indivara.ecommerce.service;

import com.indivara.ecommerce.entity.Produk;
import com.indivara.ecommerce.exception.RecourceNotFoundExcep;
import com.indivara.ecommerce.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdukService {

    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> findAll(){
        return produkRepository.findAll();
    }

    public Produk findById(String id){
        return produkRepository.findById(id).orElseThrow(() -> new RecourceNotFoundExcep("Produk dengan id : " + id + " tidak dapat di temukan"));
    }

    public Produk create(Produk produk){
        produk.setId(UUID.randomUUID().toString());
        return produkRepository.save(produk);
    }

    public Produk edit(Produk produk){
        return produkRepository.save(produk);
    }

    public Produk ubahGambar(String id, String gambar){
        Produk produk = findById(id);
        produk.setGambar(gambar);
        return produkRepository.save(produk);
    }

    public void deleteById(String id){
        produkRepository.deleteById(id);
    }
}
