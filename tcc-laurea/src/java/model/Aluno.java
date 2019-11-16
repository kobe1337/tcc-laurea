package model;

public class Aluno {
    
    private int idaluno;
    private String nome;
    private String datanasc;
    private String cpf;
    private String rg;
    private int status;
    private Responsavel responsavel;
    private Usuario usuario;

    public Aluno(int idaluno, String nome, String datanasc, String cpf, String rg, 
            int status, Responsavel responsavel, Usuario usuario) {
        this.idaluno = idaluno;
        this.nome = nome;
        this.datanasc = datanasc;
        this.cpf = cpf;
        this.rg = rg;
        this.status = status;
        this.responsavel = responsavel;
        this.usuario = usuario;
    }

    public Aluno() { }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
        this.datanasc = datanasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return getNome();
    }
    
}
