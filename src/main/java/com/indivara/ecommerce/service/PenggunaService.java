package com.indivara.ecommerce.service;

import com.indivara.ecommerce.entity.Pengguna;
import com.indivara.ecommerce.exception.BadRequestExcep;
import com.indivara.ecommerce.exception.RecourceNotFoundExcep;
import com.indivara.ecommerce.repository.PenggunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class PenggunaService {

    @Autowired
    private PenggunaRepository penggunaRepository;

    public Pengguna findById(String id){
        return penggunaRepository.findById(id).orElseThrow(()->new RecourceNotFoundExcep("Pengguna dengan id" + id + " tidak di temukan"));
    }

    public List<Pengguna> findAll(){
        return penggunaRepository.findAll();
    }

    public Pengguna create(Pengguna pengguna){
        // cek attribut id(username) harus di isi
        if (!StringUtils.hasText(pengguna.getId())){
            throw new BadRequestExcep("Username Harus di Isi");
        }

        // cek apakah pengguna sudah terdaftar
        if (penggunaRepository.existsById(pengguna.getId())){
            throw new BadRequestExcep("Username : " + pengguna.getId() + " sudah terdaftar");
        }

        // cek email kalau kosong
        if (!StringUtils.hasText(pengguna.getEmail())){
            throw new BadRequestExcep("Email Harus di Isi");
        }

        // cek apakah pengguna sudah terdaftar
        if (penggunaRepository.existsByEmail(pengguna.getEmail())){
            throw new BadRequestExcep("Email : " + pengguna.getEmail() + " sudah terdaftar");
        }

        // cek Nomor telepon kalau kosong
        if (!StringUtils.hasText(pengguna.getHp())){
            throw new BadRequestExcep("Nomor telepon harus di isi");
        }

        // cek Nomor kalau sudah terdaftar
        if (penggunaRepository.existsByNumber(pengguna.getHp())){
            throw new BadRequestExcep("Nomor telepon : " + pengguna.getHp() + " sudah terdaftar");
        }

        return penggunaRepository.save(pengguna);
    }

    public Pengguna edit(Pengguna pengguna){
        return penggunaRepository.save(pengguna);
    }

    public void deleteById(String id){
        penggunaRepository.deleteById(id);
    }

}
