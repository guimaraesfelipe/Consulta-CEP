package br.com.provacea.consultacep.dto;

import org.springframework.http.HttpStatus;

public record CustomExceptionDto(String message, HttpStatus statusCode) {
}