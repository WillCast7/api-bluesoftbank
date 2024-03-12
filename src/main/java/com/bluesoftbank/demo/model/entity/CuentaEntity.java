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
@Table(name = "cuentas")
public class CuentaEntity implements Serializable {
    @Id
    @Column(name = "cuenta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cuenta_id;

    @Column(name = "cuenta_saldo")
    private String cuenta_saldo;

    @Column(name = "cuenta_tipo")
    private String cuenta_tipo;

    @Column(name = "cuenta_estado")
    private String cuenta_estado;

    @Column(name = "cliente_id")
    private Integer cliente_id;

    @Column(name = "creadopor")
    private Integer creadopor;

    @Column(name = "fcreacion")
    private Date fcreacion;

    @Column(name = "editadopor")
    private Integer editadopor;

    @Column(name = "fedicion")
    private Date fedicion;

    @Column(name = "estado")
    private Boolean estado;

}
