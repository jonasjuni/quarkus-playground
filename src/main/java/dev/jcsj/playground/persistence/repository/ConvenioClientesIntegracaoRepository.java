package dev.jcsj.playground.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import dev.jcsj.playground.persistence.dto.ConvenioClienteDTO;
import dev.jcsj.playground.persistence.model.ConvenioClientesIntegracao;
import dev.jcsj.playground.rest.utils.ListaConvenios;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConvenioClientesIntegracaoRepository implements PanacheRepository<ConvenioClientesIntegracao> {

    public Uni<ConvenioClientesIntegracao> buscaConvenio(long numeroConvenio) {
        return find("codigoMCI = ?1 AND numeroConvenio = ?2", 1, numeroConvenio).firstResult();
    }

    public Uni<List<ConvenioClientesIntegracao>> listaConvenio() {
        return listAll();
    }

    public Uni<List<ConvenioClienteDTO>> listaConvenioProject() {
        return findAll().project(ConvenioClienteDTO.class).list();
    }

    public Boolean validaConvenio() {
        return true;
    }

}
