package dev.jcsj.playground.persistence.repository;

import dev.jcsj.playground.persistence.models.ClienteTeste;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NamedQuery;

@NamedQuery(name = "ClienteTeste.insertMax", query = "INSERT INTO quarkus.CLI_TST (ID_CLI, NM_CLI) SELECT MAX(ID_CLI) + 1, :NM_CLI FROM quarkus.CLI_TST")

@ApplicationScoped
public class ClienteTesteRepository implements PanacheRepository<ClienteTeste> {

    public Uni<ClienteTeste> cadastrar(ClienteTeste cliente) {

        var query = "INSERT INTO quarkus.CLI_TST (ID_CLI, NM_CLI) SELECT (MAX(ID_CLI) + 1), 'A' FROM quarkus.CLI_TST";

        return Panache.getSession()
                .flatMap(session -> session.createNativeQuery(query, ClienteTeste.class).getSingleResult());
    }

}
