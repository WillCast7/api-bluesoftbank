package com.bluesoftbank.demo.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "transacciones")
public class TransaccionEntity implements Serializable {
    @Id
    @Column(name = "transaccion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transaccion_id;

    @Column(name = "transaccion_tipo")
    private String transaccion_tipo;

    @Column(name = "transaccion_descripcion")
    private String transaccion_descripcion;

    @Column(name = "transaccion_monto")
    private Integer transaccion_monto;

    @Column(name = "cuenta_id")
    private Integer cuenta_id;

    @Column(name = "creadopor")
    private Integer creadopor;

    @Column(name = "fcreacion")
    private Date fcreacion;

    @Column(name = "transaccion_ipequipo")
    private String transaccion_ipequipo;

    @Column(name = "transaccion_coordenadas")
    private String transaccion_coordenadas;
}
