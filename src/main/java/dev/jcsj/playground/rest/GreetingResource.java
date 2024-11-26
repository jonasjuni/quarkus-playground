package dev.jcsj.playground.rest;

import io.quarkus.security.identity.SecurityIdentity;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("/hello")
@ApplicationScoped
public class GreetingResource {

    @Inject
    SecurityIdentity securityIdentity;

    @GET
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {
        return Uni.createFrom().item("Hello from Quarkus REST");
    }

    @GET
    @Path("secured")
    @RolesAllowed({ "secured" })
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> secured(@Context SecurityContext ctx) {
        var caller = ctx.getUserPrincipal();
        var securityInjected = securityIdentity;
        var caller2 = securityInjected.getPrincipal();
        var name2 = caller2.getName();
        var name = caller != null ? caller.getName() : "Anonymous";

        String response = String.format("hello + %s, isSecure: %s, authScheme: %s, name2: %s", name, ctx.isSecure(),
                ctx.getAuthenticationScheme(), name2);

        return Uni.createFrom().item(response);
    }
}
