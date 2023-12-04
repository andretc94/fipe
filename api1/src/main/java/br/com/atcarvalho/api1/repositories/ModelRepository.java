package br.com.atcarvalho.api1.repositories;

import br.com.atcarvalho.api1.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
