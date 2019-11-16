package model;


public class InformacoesHome {
    
    private int num_usuario;
    private int num_aluno;
    private int num_responsavel;
    private int num_professor;
    private int num_turma;
    private int num_mensalidade;
    private int num_atividade;
    private int num_disciplina;

    public InformacoesHome(int num_usuario, int num_aluno, int num_responsavel, 
            int num_professor, int num_turma, int num_mensalidade, 
            int num_atividade, int num_disciplina) {
        this.num_usuario = num_usuario;
        this.num_aluno = num_aluno;
        this.num_responsavel = num_responsavel;
        this.num_professor = num_professor;
        this.num_turma = num_turma;
        this.num_mensalidade = num_mensalidade;
        this.num_atividade = num_atividade;
        this.num_disciplina = num_disciplina;
    }

    public InformacoesHome() { }

    public int getNum_usuario() {
        return num_usuario;
    }

    public void setNum_usuario(int num_usuario) {
        this.num_usuario = num_usuario;
    }

    public int getNum_aluno() {
        return num_aluno;
    }

    public void setNum_aluno(int num_aluno) {
        this.num_aluno = num_aluno;
    }

    public int getNum_responsavel() {
        return num_responsavel;
    }

    public void setNum_responsavel(int num_responsavel) {
        this.num_responsavel = num_responsavel;
    }

    public int getNum_professor() {
        return num_professor;
    }

    public void setNum_professor(int num_professor) {
        this.num_professor = num_professor;
    }

    public int getNum_turma() {
        return num_turma;
    }

    public void setNum_turma(int num_turma) {
        this.num_turma = num_turma;
    }

    public int getNum_mensalidade() {
        return num_mensalidade;
    }

    public void setNum_mensalidade(int num_mensalidade) {
        this.num_mensalidade = num_mensalidade;
    }

    public int getNum_atividade() {
        return num_atividade;
    }

    public void setNum_atividade(int num_atividade) {
        this.num_atividade = num_atividade;
    }

    public int getNum_disciplina() {
        return num_disciplina;
    }

    public void setNum_disciplina(int num_disciplina) {
        this.num_disciplina = num_disciplina;
    }
    
    
}
