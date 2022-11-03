package com.indivara.ecommerce.service;

import com.indivara.ecommerce.entity.Produk;
import com.indivara.ecommerce.exception.BadRequestExcep;
import com.indivara.ecommerce.exception.RecourceNotFoundExcep;
import com.indivara.ecommerce.repository.KategoriRepository;
import com.indivara.ecommerce.repository.ProdukRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class ProdukService {

    @Autowired
    private KategoriRepository kategoriRepository;
    @Autowired
    private ProdukRepository produkRepository;

    public List<Produk> findAll(){
        return produkRepository.findAll();
    }

    public Produk findById(String id){
        return produkRepository.findById(id).orElseThrow(() -> new RecourceNotFoundExcep("Produk dengan id : " + id + " tidak dapat di temukan"));
    }

    public Produk create(Produk produk){
        if (!StringUtils.hasText(produk.getNama())){
            throw new BadRequestExcep("Nama Produk Tidak Boleh Kosong");
        }

        if (produk.getKategori() == null){
            throw new BadRequestExcep("Kategori tidak boleh kosong");
        }

        if (!StringUtils.hasText(produk.getKategori().getId())){
            throw new BadRequestExcep("Kategori Id Tidak Boleh Kosong");
        }

        kategoriRepository.findById(produk.getKategori().getId()).orElseThrow(() -> new BadRequestExcep("Kategori id : " + produk.getKategori().getId() + " tidak di temukan"));

        produk.setId(UUID.randomUUID().toString());
        return produkRepository.save(produk);
    }

    public Produk edit(Produk produk){

        if (!StringUtils.hasText(produk.getId())){
            throw new BadRequestExcep("Produk Id Harus di isi");
        }

        if (!StringUtils.hasText(produk.getNama())){
            throw new BadRequestExcep("Nama Produk Tidak Boleh Kosong");
        }

        if (produk.getKategori() == null){
            throw new BadRequestExcep("Kategori tidak boleh kosong");
        }

        if (!StringUtils.hasText(produk.getKategori().getId())){
            throw new BadRequestExcep("Kategori Id Tidak Boleh Kosong");
        }

        kategoriRepository.findById(produk.getKategori().getId()).orElseThrow(() -> new BadRequestExcep("Kategori id : " + produk.getKategori().getId() + " tidak di temukan"));


        return produkRepository.save(produk);
    }

    public Produk ubahGambar(String id, String gambar){
        Produk produk = findById(id);
        produk.setGambar(gambar);
        return produkRepository.save(produk);
    }

    public void deleteById(String id){

        if (id == null){
            throw new BadRequestExcep("Id tidak boleh kosong");
        }

        produkRepository.deleteById(id);
    }
}
