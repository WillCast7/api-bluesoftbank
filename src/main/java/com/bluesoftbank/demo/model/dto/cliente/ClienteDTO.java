package com.bluesoftbank.demo.model.dto.cliente;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ClienteDTO implements Serializable {

    private Integer cliente_id;
    private String cliente_correo;
    private String cliente_pin;
    private Integer persona_id;
    private Integer creadopor;
    private Date fcreacion;
    private Integer actualizadopor;
    private Date factualizacion;
    private Boolean estado;
    private String cliente_estado;

}
