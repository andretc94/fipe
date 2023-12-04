package br.com.atcarvalho.api2.services;

import br.com.atcarvalho.api2.models.Model;
import br.com.atcarvalho.api2.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public void save(List<Model> models){
        modelRepository.saveAll(models);
    }
}
