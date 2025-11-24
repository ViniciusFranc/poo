package Main;

import Accounts.ContaFinanceira;
import java.time.LocalDate;

public class Lancamento {
    protected String Categoria;
    protected String Subcategoria;
    protected String Remetente;
    protected String Destinatario;
    protected ContaFinanceira Conta;
    protected LocalDate data;
    protected double valor;

    public Lancamento(String Categoria, ContaFinanceira Conta, String Destinatario, String Remetente, String Subcategoria, LocalDate data, double valor) {
        this.Categoria = Categoria;
        this.Conta = Conta;
        this.Destinatario = Destinatario;
        this.Remetente = Remetente;
        this.Subcategoria = Subcategoria;
        this.data = data;
        this.valor = valor;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getSubcategoria() {
        return Subcategoria;
    }

    public String getRemetente() {
        return Remetente;
    }

    public String getDestinatario() {
        return Destinatario;
    }

    public ContaFinanceira getConta() {
        return Conta;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setSubcategoria(String Subcategoria) {
        this.Subcategoria = Subcategoria;
    }

    public void setRemetente(String Remetente) {
        this.Remetente = Remetente;
    }

    public void setDestinatario(String Destinatario) {
        this.Destinatario = Destinatario;
    }

    public void setConta(ContaFinanceira Conta) {
        this.Conta = Conta;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}