package br.com.atcarvalho.api1.services.fipe;

import br.com.atcarvalho.api1.services.fipe.dtos.Brands;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "fipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeFeignClient {

    @GetMapping("/carros/marcas")
    List<Brands> getBrands();

}
