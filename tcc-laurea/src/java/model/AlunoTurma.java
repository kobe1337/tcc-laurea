package model;

public class AlunoTurma {
    
    private Aluno aluno;
    private Turma turma;
    private String frequencia;
    private String data;

    public AlunoTurma(Aluno aluno, Turma turma, String frequencia, String data) {
        this.aluno = aluno;
        this.turma = turma;
        this.frequencia = frequencia;
        this.data = data;
    }

    public AlunoTurma() { }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return ""+getAluno()+" / "+getTurma();
    }
    
}
