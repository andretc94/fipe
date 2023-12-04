package br.com.atcarvalho.api1.repositories;

import br.com.atcarvalho.api1.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {

}
