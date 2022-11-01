package com.indivara.ecommerce.repository;

import com.indivara.ecommerce.entity.Pengguna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PenggunaRepository extends JpaRepository<Pengguna, String > {
}
