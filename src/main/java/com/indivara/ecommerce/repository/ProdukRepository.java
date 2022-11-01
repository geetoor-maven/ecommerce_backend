package com.indivara.ecommerce.repository;

import com.indivara.ecommerce.entity.Produk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdukRepository extends JpaRepository<Produk, String > {
}
