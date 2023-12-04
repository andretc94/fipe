package br.com.atcarvalho.api2.services.fipe;

import br.com.atcarvalho.api2.services.fipe.dtos.Brand;
import br.com.atcarvalho.api2.services.fipe.dtos.Root;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "fipe", url = "https://parallelum.com.br/fipe/api/v1")
public interface FipeFeignClient {

    @GetMapping("/carros/marcas")
    List<Brand> getBrands();

    @GetMapping("/carros/marcas/{codigo}/modelos")
    Root getModels(@PathVariable("codigo") String codigo);

}
