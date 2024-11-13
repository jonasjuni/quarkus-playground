package dev.jcsj.playground.rest;

import java.util.List;

import dev.jcsj.playground.persistence.ConveniosClientesIntegracao;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("convenios")
public class ConvenioResource {

    @GET
    public Uni<List<ConveniosClientesIntegracao>> listaConvenio() {

        return ConveniosClientesIntegracao.listaConvenio();
    }

    @GET
    @Path("{numeroConvenio}")
    public Uni<ConveniosClientesIntegracao> numeroConvenio(long numeroConvenio) {

        return ConveniosClientesIntegracao.find("codigoMCI = ?1 AND numeroConvenio = ?2", 1, numeroConvenio)
                .firstResult();
    }

    @POST
    @Path("valida")
    public Boolean validaMCIConvenio(ConveniosClientesIntegracao request) {

        return request.validaConvenio();
    }

}
