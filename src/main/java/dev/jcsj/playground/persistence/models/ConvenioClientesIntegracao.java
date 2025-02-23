package dev.jcsj.playground.persistence.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CNV_CLI_JDCL", schema = "QUARKUS")
public class ConvenioClientesIntegracao {

    @Id
    @Column(name = "CD_CLI_MCI")
    public long codigoMCI;

    @Id
    @Column(name = "NR_CVN")
    public long numeroConvenio;

    @Column(name = "NM_CLI")
    public String name;

}
