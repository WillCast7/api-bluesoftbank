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
@Table(name = "personas")
public class PersonaEntity implements Serializable {
    @Id
    @Column(name = "persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer persona_id;

    @Column(name = "persona_tipodni")
    private String persona_tipodni;

    @Column(name = "persona_dni")
    private String persona_dni;

    @Column(name = "persona_primernombre")
    private String persona_primernombre;

    @Column(name = "persona_segundonombre")
    private String persona_segundonombre;

    @Column(name = "persona_primerapellido")
    private String persona_primerapellido;

    @Column(name = "persona_segundoapellido")
    private String persona_segundoapellido;

    @Column(name = "persona_email")
    private String persona_email;

    @Column(name = "persona_telefono")
    private String persona_telefono;

    @Column(name = "persona_direccion")
    private String persona_direccion;

    @Column(name = "persona_telefono2")
    private String persona_telefono2;

    @Column(name = "persona_fechanacimiento")
    private Date persona_fechanacimiento;

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
}
