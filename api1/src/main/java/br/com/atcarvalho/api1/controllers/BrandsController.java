package br.com.atcarvalho.api1.controllers;

import br.com.atcarvalho.api1.api.Brand;
import br.com.atcarvalho.api1.api.BrandWithModels;
import br.com.atcarvalho.api1.api.BrandsApi;
import br.com.atcarvalho.api1.api.Model;
import br.com.atcarvalho.api1.exceptions.NotFoundException;
import br.com.atcarvalho.api1.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BrandsController implements BrandsApi {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public ResponseEntity<BrandWithModels> getModelsOfBrand(String id) {
        Optional<br.com.atcarvalho.api1.models.Brand> brand = brandRepository.findById(Long.valueOf(id));
        if (brand.isEmpty()) throw new NotFoundException("brand not found");
        return ResponseEntity.ok(this.converter(brand.get()));
    }

    @Override
    public ResponseEntity<List<Brand>> getAllBrands() {
        return ResponseEntity.ok(this.converter(brandRepository.findAll()));
    }

    private List<Brand> converter(List<br.com.atcarvalho.api1.models.Brand> brands){
        return brands.stream().map(it->{
            Brand brand = new Brand();
            brand.id(String.valueOf(it.getId()));
            brand.name(it.getName());
            return brand;
        }).toList();
    }

    private BrandWithModels converter(br.com.atcarvalho.api1.models.Brand brand){
        BrandWithModels brandWithModels = new BrandWithModels();
        brandWithModels.id(String.valueOf(brand.getId()));
        brandWithModels.name(brand.getName());
        brandWithModels.setModels(brand.getModels().stream().map(it->{
            Model model = new Model();
            model.comment(it.getComments());
            model.id(String.valueOf(it.getId()));
            model.name(it.getName());
            return model;
        }).toList());
        return brandWithModels;
    }
}
