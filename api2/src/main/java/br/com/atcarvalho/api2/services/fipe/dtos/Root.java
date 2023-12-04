package br.com.atcarvalho.api2.services.fipe.dtos;

import lombok.ToString;

import java.util.List;

@ToString
public class Root {
    public List<Ano> anos;
    public List<Modelo> modelos;
}
