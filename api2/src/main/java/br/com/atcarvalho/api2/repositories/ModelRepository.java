package br.com.atcarvalho.api2.repositories;

import br.com.atcarvalho.api2.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
