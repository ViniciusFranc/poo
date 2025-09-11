public class folhaPagamento {
    funcionario[] funcionarios = new funcionario[50];
    public folhaPagamento(){
        for (int i = 0 ; i < funcionarios.length; i+=5) {
            funcionarios[i] = new funcionario(10, 2f, 1.5f, 19f);
            funcionarios[i+1] = new funcionario(18, 6f, 16f, 3f);
            funcionarios[i+2] = new funcionario(1, 0.3f, 1.5f, 98f);
            funcionarios[i+3] = new funcionario(57, 200f, 10.5f, 219f);
            funcionarios[i+4] = new funcionario(100, 92f,1.592f, 1f);
        }
    }
    public void ordenar (){
        for (int i=0; i < funcionarios.length-1; i++) {
            for (int j=0; j < funcionarios.length-1; j++) {
                if (funcionarios[i].valorSalarios < funcionarios[j+1].valorSalarios ){
                float temp = funcionarios[i].valorSalarios;
                funcionarios[i].valorSalarios = funcionarios[j+1].valorSalarios;
                funcionarios[j+1].valorSalarios = temp;
             }
            }
        }
    }

    public void exibir(){
        for (int i = 0 ; i < funcionarios.length; i++) {
            funcionarios[i].exibir();
        }
    }
    public static void main (String[] args){
        folhaPagamento fp = new folhaPagamento();
        fp.ordenar();
        fp.exibir();
        }
    }