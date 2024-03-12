package com.bluesoftbank.demo.dto.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientePersonaDTO {
    private String persona_tipodni;
    private String persona_dni;
    private String persona_primernombre;
    private String persona_segundonombre;
    private String persona_primerapellido;
    private String persona_segundoapellido;
    private String persona_telefono;
    private String persona_direccion;
    private String cliente_correo;
    private Date fcreacion;
    private Boolean estado;
}
