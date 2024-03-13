package com.bluesoftbank.demo.model.dto.usuario;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioPersonaDTO {
    private String persona_tipodni;
    private String persona_dni;
    private String persona_primernombre;
    private String persona_segundonombre;
    private String persona_primerapellido;
    private String persona_segundoapellido;
    private String persona_telefono;
    private String usuario;
    private Integer rol_id;
    private String persona_direccion;
    private String usuario_correo;
    private Date fcreacion;
    private Boolean estado;
}
