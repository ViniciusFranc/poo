public class Main{


public static void main(String[] args) {
    Atividade[] diarioAtividades = {new Corrida(10.8d,30,5.3d,8.9d),new Ciclismo(20.9d,13,1.9f,12.9f), new  Natacao(29.8d,3,5)};

    for (int i = 0; i < diarioAtividades.length; i++) {
        diarioAtividades[i].Iniciar();
        diarioAtividades[i].Terminar();
        diarioAtividades[i].medirEsforco();
    }
}
}