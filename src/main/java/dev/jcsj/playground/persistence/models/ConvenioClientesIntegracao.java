package dev.jcsj.playground.persistence.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CNV_CLI_JDCL", schema = "QUARKUS")
public class ConvenioClientesIntegracao {

    @Id
    @Column(name = "CD_CLI_MCI")
    @JsonIgnore
    public long codigoMCI;

    @Id
    @Column(name = "NR_CVN")
    public long numeroConvenio;

    @Column(name = "NM_CLI")
    public String name;

    @Override
    public int hashCode() {
        return Objects.hash(codigoMCI, numeroConvenio, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ConvenioClientesIntegracao that))
            return false;

        if (codigoMCI != that.codigoMCI)
            return false;
        if (numeroConvenio != that.numeroConvenio)
            return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }
}
