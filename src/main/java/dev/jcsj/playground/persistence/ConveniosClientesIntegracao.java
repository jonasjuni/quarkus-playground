package dev.jcsj.playground.persistence;

import java.util.List;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field
 * extends <code>PanacheEntityBase</code> instead.
 *
 * This uses the active record pattern, you can also use the repository pattern
 * instead:
 * .
 *
 * Usage (more example on the documentation)
 *
 * {@code
 *     public void doSomething() {
 *         MyEntity entity1 = new MyEntity();
 *         entity1.field = "field-1";
 *         entity1.persist();
 *
 *         List<MyEntity> entities = MyEntity.listAll();
 * }
 * }
 */
@Entity
@Table(name = "CNV_CLI_JDCL", schema = "quarkus")
public class ConveniosClientesIntegracao extends PanacheEntityBase {

    @Id
    @Column(name = "CD_CLI_MCI")
    public long codigoMCI;

    @Id
    @Column(name = "NR_CVN")
    public long numeroConvenio;

    @Column(name = "NM_CLI")
    public String name;

    public static Uni<ConveniosClientesIntegracao> buscaConvenio(long numeroConvenio) {
        return find("codigoMCI = ?1 AND numeroConvenio = ?2", 1, numeroConvenio).firstResult();
    }

    public static Uni<List<ConveniosClientesIntegracao>> listaConvenio() {
        return listAll();
    }

    public String getName() {
        return this.name.toLowerCase();
    }

    public Uni<Boolean> getValidadeConvenio() {
        return find("codigoMCI = ?1 AND numeroConvenio = ?2", this.codigoMCI, this.numeroConvenio)
                .firstResult()
                .map(item -> item != null);
    }
}
