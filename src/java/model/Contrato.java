package model;


public class Contrato {
    
    private int idcontrato;
    private String datacontrato;
    private double preco;
    private int parcela;
    private int status;
    private String serie;
    private String escola;
    private Aluno aluno;

    public Contrato(int idcontrato, String datacontrato, double preco, 
            int parcela, int status, String serie, String escola, Aluno aluno) {
        this.idcontrato = idcontrato;
        this.datacontrato = datacontrato;
        this.preco = preco;
        this.parcela = parcela;
        this.status = status;
        this.serie = serie;
        this.escola = escola;
        this.aluno = aluno;
    }

    public Contrato() {
    }

    public int getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(int idcontrato) {
        this.idcontrato = idcontrato;
    }

    public String getDatacontrato() {
        return datacontrato;
    }

    public void setDatacontrato(String datacontrato) {
        this.datacontrato = datacontrato;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "N "+getIdcontrato();
    } 
    
}
