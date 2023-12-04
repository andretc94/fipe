package br.com.atcarvalho.api2.services.messaging;

import br.com.atcarvalho.api2.services.fipe.dtos.Brand;

public interface Messaging {

    void send(String message);
    void load(String message);
}
