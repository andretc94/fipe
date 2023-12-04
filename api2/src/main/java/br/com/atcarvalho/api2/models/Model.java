package br.com.atcarvalho.api2.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MODELS")
@Data
public class Model {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "comments", columnDefinition = "TEXT")
    private String comments;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
