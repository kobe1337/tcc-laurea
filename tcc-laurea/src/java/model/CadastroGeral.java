package model;



public class CadastroGeral {
    
    private Aluno aluno;
    private Responsavel responsavel;
    private Contrato contrato;
    private Mensalidade mensalidade;
    private int dia;
    private int mes;
    private int ano;

    public CadastroGeral(Aluno aluno, Responsavel responsavel, 
            Contrato contrato, Mensalidade mensalidade, int dia, int mes, int ano) {
        this.aluno = aluno;
        this.responsavel = responsavel;
        this.contrato = contrato;
        this.mensalidade = mensalidade;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    

    public CadastroGeral() { }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Mensalidade getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
}
