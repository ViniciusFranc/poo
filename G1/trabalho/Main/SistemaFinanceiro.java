package Main;

import Extratos.Movimento;
import Users.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaFinanceiro {

    private static SistemaFinanceiro instancia;

    private ArrayList<Usuario> usuarios;
    private Movimento movimento;

    private SistemaFinanceiro() {
        usuarios = new ArrayList<>();
        movimento = new Movimento();
    }

    public static SistemaFinanceiro getInstancia() {
        if (instancia == null) {
            instancia = new SistemaFinanceiro();
        }
        return instancia;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Movimento getMovimento() {
        return movimento;
    }

    public void executar() {
        Principal.menuPrincipal(new Scanner(System.in), this);
    }
}
