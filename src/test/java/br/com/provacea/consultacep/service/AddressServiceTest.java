package br.com.provacea.consultacep.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import br.com.provacea.consultacep.model.AddressModel;
import org.junit.Before;
import org.junit.Test;

public class AddressServiceTest {

    private AddressService addressService;

    @Before
    public void setUp() {
        addressService = new AddressService();
    }

    @Test
    public void testFindByCepValid() {
        String cep = "01001000";
        AddressModel addressModel = addressService.findByCep(cep);

        assertNotNull(cep);
        assertEquals(cep, addressModel.getCep().replace("-", ""));
    }
}
