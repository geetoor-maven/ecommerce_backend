package com.indivara.ecommerce.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
public class Keranjang implements Serializable {

    @Id
    private String id;

    @JoinColumn
    @ManyToOne
    private Produk produk;

    @JoinColumn
    @ManyToOne
    private Pengguna pengguna;

    private Double kuantitas;

    private BigDecimal harga;

    private BigDecimal jumlah;
}
