package dev.jcsj.playground.rest;

import java.util.List;

import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.RestResponse;

import dev.jcsj.playground.persistence.models.ClienteTeste;
import dev.jcsj.playground.persistence.repository.ClienteTesteRepository;
import dev.jcsj.playground.rest.utils.ClienteTesteRequest;

import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/cliente")
public class ClientesResource {

    private static final Logger LOG = Logger.getLogger(ClientesResource.class);

    @Inject
    ClienteTesteRepository clienteTesteRepository;

    @Inject
    Validator validator;

    @Path("/add")
    @POST
    @WithTransaction
    public Uni<RestResponse<ClienteTeste>> add(@Valid ClienteTesteRequest request) {
        LOG.info(request);

        var clienteTeste = new ClienteTeste();

        clienteTeste.nomeCliente = request.nomeCliente;
        clienteTeste.aniversario = request.aniversario;
        clienteTeste.dataCasamento = request.casamento;
        clienteTeste.qtdFilhos = request.qtdFilhos;

        return clienteTesteRepository.persist(clienteTeste)
                .map(item -> RestResponse.status(RestResponse.Status.CREATED, item));
    }

    @Path("/list")
    @GET
    public Uni<List<ClienteTeste>> list() {
        return clienteTesteRepository.listAll();
    }
}