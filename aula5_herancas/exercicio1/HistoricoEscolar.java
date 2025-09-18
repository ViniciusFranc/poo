public class HistoricoEscolar{

    DisciplinaAnual jefersonAnual = new DisciplinaAnual();
    DisciplinaSemestral jefersonSemestral = new DisciplinaSemestral();
    DisciplinaTrimestral jefersonTrimestral = new DisciplinaTrimestral();

    public static void main(String[] args) {
        HistoricoEscolar historicoEscolar = new HistoricoEscolar();
        historicoEscolar.jefersonAnual.setNota1(7.0);
        historicoEscolar.jefersonAnual.setNota2(7.6);
        historicoEscolar.jefersonAnual.setNota3(6.0);
        historicoEscolar.jefersonAnual.setNota4(9.0);
        historicoEscolar.jefersonAnual.setNota5(3.0);
        historicoEscolar.jefersonAnual.setNota6(10.0);

        historicoEscolar.jefersonSemestral.setNota1(7.0);
        historicoEscolar.jefersonSemestral.setNota2(7.6);
        historicoEscolar.jefersonSemestral.setNota3(6.0);

        historicoEscolar.jefersonTrimestral.setNota1(7.0);
        historicoEscolar.jefersonTrimestral.setNota2(7.6);

        historicoEscolar.jefersonAnual.avaliacao();
        historicoEscolar.jefersonSemestral.avaliacao();
        historicoEscolar.jefersonTrimestral.avaliacao();

        public boolean verificarNota (Disciplina d){}
    }

}