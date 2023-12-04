package br.com.atcarvalho.api2.controllers;

import br.com.atcarvalho.api2.services.fipe.FipeFeignClient;
import br.com.atcarvalho.api2.services.messaging.Messaging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrandsController {

    @Autowired
    private FipeFeignClient fipeFeignClient;
    @Autowired
    private Messaging messaging;

//    @GetMapping("/brands")
//    public ResponseEntity getMarcas(){
//        fipeFeignClient.getBrands().forEach(it-> messaging.send(Utils.toJson(it)));
//        return ResponseEntity.ok(HttpStatus.OK);
//    }

}
