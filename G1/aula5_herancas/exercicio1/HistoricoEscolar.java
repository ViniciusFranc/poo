public class HistoricoEscolar{

    DisciplinaAnual jefersonAnual = new DisciplinaAnual(7f,7.5f,6f,9f,3f,10f);
    DisciplinaSemestral jefersonSemestral = new DisciplinaSemestral(7.0f,7.5f,6.0f);
    DisciplinaTrimestral jefersonTrimestral = new DisciplinaTrimestral(7.0f,7.5f);

    public static void main(String[] args) {
        HistoricoEscolar historicoEscolar = new HistoricoEscolar();

        historicoEscolar.jefersonAnual.exibir();
        historicoEscolar.jefersonSemestral.exibir();
        historicoEscolar.jefersonTrimestral.exibir();

    }

}