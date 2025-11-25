package Main;

import java.time.LocalDate;

public class MetaOrcamento {
    private String categoria;
    private double valorMeta;
    private LocalDate dataLimite;

    public MetaOrcamento(String categoria, double valorMeta, LocalDate dataLimite) {
        this.categoria = categoria;
        this.valorMeta = valorMeta;
        this.dataLimite = dataLimite;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getValorMeta() {
        return valorMeta;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }
}
