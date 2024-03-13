package com.bluesoftbank.demo.util;

import com.bluesoftbank.demo.model.dto.APIResponseDTO;
import org.springframework.http.HttpStatus;

public class Util {
    public static HttpStatus findHttpStatusResponse(APIResponseDTO<?> response) {
        HttpStatus httpStaus;
        String message = response.getCode();

        switch (message) {

            case "500":
                httpStaus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;

            case "400":
                httpStaus = HttpStatus.BAD_REQUEST;
                break;

            case "404":
                httpStaus = HttpStatus.NOT_FOUND;
                break;

            case "200":
                httpStaus = HttpStatus.OK;
                break;

            case "409":
                httpStaus = HttpStatus.CONFLICT;
                break;

            case "401":
                httpStaus = HttpStatus.UNAUTHORIZED;
                break;

            default:
                httpStaus = HttpStatus.INTERNAL_SERVER_ERROR;
                break;
        }
        return httpStaus;
    }

}
