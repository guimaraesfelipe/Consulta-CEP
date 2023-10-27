package br.com.provacea.consultacep.service;

import br.com.provacea.consultacep.model.AddressModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {

    public AddressModel findByCep(String cep) {
        RestTemplate template = new RestTemplate();

        try {
            ResponseEntity<AddressModel> response =  template.getForEntity("https://viacep.com.br/ws/" + cep + "/json/", AddressModel.class);
            return response.getBody();
        } catch (HttpClientErrorException ex) {
            throw new RuntimeException("Formato do CEP invalido.");
        }

    }
}
