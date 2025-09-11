public class funcionario {
    int codigo;
    float quantidadeHoras;
    float valorHora;
    float valorSalarios;
    float quantidadeHorasExtras;    

    public funcionario( int c, float qH, float vH, float qhe) {
        this.codigo = c;
        this.quantidadeHoras = qH;
        this.valorHora = vH;
        this.quantidadeHorasExtras=qhe;
        this.valorSalarios = 0f;
    }

    public float calcularHoraExtra(){
        float valorHoraExtra = (valorHora * 1.5f)*quantidadeHorasExtras;  
        return valorHoraExtra;
    }

    public void calcularSalario(){
        valorSalarios = (valorHora * quantidadeHoras) + calcularHoraExtra();
    }

    public void exibir(){
        System.out.println(
        "codigo: " + codigo +
        "quantidade horas: " + quantidadeHoras +
        "valor hora: " + valorHora +
        "valor salario: " + valorSalarios +
        "quantidade horas extras: " + quantidadeHorasExtras +
        "valor hora extra: " + calcularHoraExtra());
   }


}

