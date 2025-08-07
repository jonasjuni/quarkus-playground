package dev.jcsj.playground.rest;

import java.util.ArrayList;

import org.jboss.logging.Logger;

import dev.jcsj.playground.persistence.models.ConvenioClientesIntegracao;
import dev.jcsj.playground.persistence.repository.ConvenioClientesIntegracaoRepository;
import dev.jcsj.playground.rest.utils.ConvenioResponse;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("convenios")
public class ConvenioResource {

    private static final Logger LOG = Logger.getLogger(ConvenioResource.class);

    @Inject
    ConvenioClientesIntegracaoRepository convenioClientesIntegracaoRepository;

    @GET
    public Uni<ConvenioResponse> listaConvenio() {

        LOG.info("ConvenioResource");

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
    public Uni<ConvenioClientesIntegracao> numeroConvenio(long numeroConvenio) {

        return convenioClientesIntegracaoRepository.find("codigoMCI = ?1 AND numeroConvenio = ?2", 1, numeroConvenio)
                .firstResult();
    }

    @POST
    @Path("valida")
    public Boolean validaMCIConvenio(ConvenioClientesIntegracao request) {

        return true;
    }

}
