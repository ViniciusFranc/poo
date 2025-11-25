package Main;

import Accounts.ContaFinanceira;
import Users.Usuario;
import java.time.LocalDate;

public class Lancamento {

    protected String Tipo;
    protected String TipoUser;
    protected String Categoria;
    protected String Subcategoria;
    protected Usuario Remetente;
    protected String Destinatario;
    protected ContaFinanceira Conta;
    protected LocalDate data;
    protected double valor;

    public Lancamento(String Categoria, ContaFinanceira Conta, String Destinatario, Usuario Remetente, String Subcategoria, LocalDate data, double valor, String Tipo,String TipoUser) {
        this.Categoria = Categoria;
        this.Conta = Conta;
        this.Destinatario = Destinatario;
        this.Remetente = Remetente;
        this.Subcategoria = Subcategoria;
        this.data = data;
        this.valor = valor;
        this.Tipo = Tipo;
        this.TipoUser = TipoUser;
    }

    public String getCategoria() {
        return Categoria;
    }

    public String getSubcategoria() {
        return Subcategoria;
    }

    public Usuario getRemetente() {
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
    
    public String getTipo() {
        return Tipo;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public void setSubcategoria(String Subcategoria) {
        this.Subcategoria = Subcategoria;
    }

    public void setRemetente(Usuario Remetente) {
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

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getTipoUser() {
        return TipoUser;
    }

    public void setTipoUser(String TipoUser) {
        this.TipoUser = TipoUser;
    }
}