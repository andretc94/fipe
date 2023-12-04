package br.com.atcarvalho.api1.controllers;

import br.com.atcarvalho.api1.api.InitApi;
import br.com.atcarvalho.api1.services.fipe.FipeFeignClient;
import br.com.atcarvalho.api1.services.Sender;
import br.com.atcarvalho.api1.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


@Controller
public class InitController implements InitApi {

    @Autowired
    private FipeFeignClient fipeFeignClient;

    @Autowired
    private Sender sender;
    @Override
    public ResponseEntity<String> initChargeData() {
        fipeFeignClient.getBrands().forEach(it-> sender.send(Utils.toJson(it)));
        return ResponseEntity.ok("OK");
    }
}
