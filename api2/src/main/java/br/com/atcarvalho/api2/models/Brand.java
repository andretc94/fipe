package br.com.atcarvalho.api2.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "BRANDS")
@Data
public class Brand {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;
}
