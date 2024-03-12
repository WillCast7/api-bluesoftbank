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
@Table(name = "clientes")
public class ClienteEntity implements Serializable {
    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cliente_id;

    @Column(name = "cliente_correo")
    private String cliente_correo;

    @Column(name = "cliente_pin")
    private String cliente_pin;

    @Column(name = "persona_id")
    private Integer persona_id;

    @Column(name = "creadopor")
    private Integer creadopor;

    @Column(name = "fcreacion")
    private Date fcreacion;

    @Column(name = "actualizadopor")
    private Integer actualizadopor;

    @Column(name = "factualizacion")
    private Date factualizacion;

    @Column(name = "estado")
    private Boolean estado;

    @Column(name = "cliente_estado")
    private String cliente_estado;

}
