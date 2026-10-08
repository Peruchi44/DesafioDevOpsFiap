package com.java.projetofiap.desafiodevops.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "registros_esg")
public class RegistroEsg {

    @Id
    private String id;
    private String departamento;
    private Double consumoKwh;
    private Double emissoesCo2Kg;
    private LocalDateTime dataRegistro;

    public RegistroEsg() {
        this.dataRegistro = LocalDateTime.now();
    }

    public RegistroEsg(String departamento, Double consumoKwh, Double emissoesCo2Kg) {
        this.departamento = departamento;
        this.consumoKwh = consumoKwh;
        this.emissoesCo2Kg = emissoesCo2Kg;
        this.dataRegistro = LocalDateTime.now();
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public Double getConsumoKwh() { return consumoKwh; }
    public void setConsumoKwh(Double consumoKwh) { this.consumoKwh = consumoKwh; }

    public Double getEmissoesCo2Kg() { return emissoesCo2Kg; }
    public void setEmissoesCo2Kg(Double emissoesCo2Kg) { this.emissoesCo2Kg = emissoesCo2Kg; }

    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }
}