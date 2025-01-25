package dev.jcsj.playground.persistence.dto;

import dev.jcsj.playground.rest.utils.ListaConvenios;
import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class ConvenioClienteDTO extends ListaConvenios {

    public ConvenioClienteDTO(long codigoMCI, long numeroConvenio, String name) {
        super.setCodigoMCI(codigoMCI);
        setNumeroConvenio(numeroConvenio);
        super.setName(name);
    }

}
