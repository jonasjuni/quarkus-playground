package dev.jcsj.playground.rest;

import java.util.ArrayList;

import dev.jcsj.playground.persistence.ConveniosClientesIntegracao2;

import dev.jcsj.playground.persistence.repository.ConvenioClientesIntegracaoRepository;
import dev.jcsj.playground.rest.utils.ConvenioResponse;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("convenios")
public class ConvenioResource {

    @Inject
    ConvenioClientesIntegracaoRepository convenioClientesIntegracaoRepository;

    @GET
    public Uni<ConvenioResponse> listaConvenio() {

        var listaConvenios = convenioClientesIntegracaoRepository.listaConvenioProject();

        return listaConvenios.map(event -> {

            ConvenioResponse resposta = new ConvenioResponse();
            resposta.setQuantidadeRegistros(event.size());
            resposta.setListaConvenios(new ArrayList<>(event));

            return resposta;
        });
    }

    @GET
    @Path("{numeroConvenio}")
    public Uni<ConveniosClientesIntegracao2> numeroConvenio(long numeroConvenio) {

        return ConveniosClientesIntegracao2.find("codigoMCI = ?1 AND numeroConvenio = ?2", 1, numeroConvenio)
                .firstResult();
    }

    @POST
    @Path("valida")
    public Boolean validaMCIConvenio(ConveniosClientesIntegracao2 request) {

        return request.validaConvenio();
    }

}
