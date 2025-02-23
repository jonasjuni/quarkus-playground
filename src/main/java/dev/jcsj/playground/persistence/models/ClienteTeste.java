package dev.jcsj.playground.persistence.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLI_TST", schema = "quarkus")
public class ClienteTeste extends PanacheEntityBase {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "ID_CLI")
    public UUID idCliente;

    @Column(name = "NM_CLI")
    public String nomeCliente;

    @Column(name = "NR_FIL")
    public Integer qtdFilhos;

    @Column(name = "DT_NASC")
    public LocalDate aniversario;

    @Column(name = "DT_CAS")
    public LocalDate dataCasamento;

    @CreationTimestamp
    @Column(name = "TS_INS", columnDefinition = "TIMESTAMP")
    public LocalDateTime dataInsercao;

}
