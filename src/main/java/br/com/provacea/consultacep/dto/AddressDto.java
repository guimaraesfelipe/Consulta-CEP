package br.com.provacea.consultacep.dto;

import jakarta.validation.constraints.NotBlank;

public record AddressDto(@NotBlank String cep) {
}
