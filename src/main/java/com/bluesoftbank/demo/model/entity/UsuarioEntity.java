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
@Table(name = "usuarios")
public class UsuarioEntity implements Serializable {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuario_id;

    @Column(name = "usuario_correo")
    private String usuario_correo;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "persona_id")
    private Integer persona_id;

    @Column(name = "rol_id")
    private Integer rol_id;

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
