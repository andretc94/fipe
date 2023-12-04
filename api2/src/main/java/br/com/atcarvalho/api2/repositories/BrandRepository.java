package br.com.atcarvalho.api2.repositories;

import br.com.atcarvalho.api2.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
