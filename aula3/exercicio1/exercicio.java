public class exercicio {
       public static void main (String [] args){
            Caneta caneta = fabricaCaneta.criarAzul("azul",0.55 );
            Caneta caneta1 = new Caneta ("vermelho",1.0 );
            Caneta caneta2=fabricaCaneta.criarPreta("preto",0.25);
           // objeto e uma coisa a qual se podem ser atribuidos atributos, e caracteristicas"
            caneta.escrever("abacaxi");
            caneta1.escrever("laranja");
            caneta2.escrever("manga");

            Lampada lampada = new Lampada();
            lampada.ligar();
            System.out.println(lampada.ligada);
            lampada.desligar();
            System.out.println(lampada.ligada);
            lampada.isLigada();
            System.out.println(lampada.ligada);

            Mesa mesa = new Mesa(caneta);

            mesa.getCanetaFavorita().escrever("  pupupupu, temo domando, temo aprendendo temo ensinando");

    }
}
