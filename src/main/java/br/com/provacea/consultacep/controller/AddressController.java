package br.com.provacea.consultacep.controller;

import br.com.provacea.consultacep.dto.AddressDto;
import br.com.provacea.consultacep.model.AddressModel;
import br.com.provacea.consultacep.service.AddressService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Getter
@Setter
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AddressService enderecoService;

    @PostMapping("/searchCep")
    public ResponseEntity<AddressModel> findByCep(@RequestBody AddressDto endereco) {
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.findByCep(endereco.cep()));
    }

}
