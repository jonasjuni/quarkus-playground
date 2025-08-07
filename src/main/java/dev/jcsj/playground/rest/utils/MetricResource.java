package dev.jcsj.playground.rest.utils;

import org.jboss.logging.Logger;

// import io.opentelemetry.api.metrics.LongCounter;
// import io.opentelemetry.api.metrics.Meter;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/metric")
public class MetricResource {

    private static final Logger LOG = Logger.getLogger(MetricResource.class);

    // private final LongCounter counter;

    // public MetricResource(Meter meter) {
    // counter = meter.counterBuilder("hello-metrics")
    // .setDescription("hello-metrics")
    // .setUnit("invocations")
    // .build();
    // }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Uni<String> hello() {

        // counter.add(1);
        LOG.info("hello-metrics");
        return Uni.createFrom().item(String.format("hello-metrics: %l", 1));
    }

}
