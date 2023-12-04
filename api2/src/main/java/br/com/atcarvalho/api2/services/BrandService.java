package br.com.atcarvalho.api2.services;

import br.com.atcarvalho.api2.models.Brand;
import br.com.atcarvalho.api2.repositories.BrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public Brand save(br.com.atcarvalho.api2.services.fipe.dtos.Brand brand){
        Brand brandEntity = new Brand();
        brandEntity.setId(Long.valueOf(brand.codigo()));
        brandEntity.setName(brand.nome());
        Brand save = this.brandRepository.save(brandEntity);
        log.info("save brand: {}", brand);
        return save;
    }
}
