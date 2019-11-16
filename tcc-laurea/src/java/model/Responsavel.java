package model;

public class Responsavel {
    
    private int idresponsavel;
    private String nome;
    private String cpf;
    private String rg;
    private int status;
    private Usuario usuario;

    public Responsavel(int idresponsavel, String nome, String cpf, 
            String rg, int status, Usuario usuario) {
        this.idresponsavel = idresponsavel;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.status = status;
        this.usuario = usuario;
    }

    public Responsavel() { }

    public int getIdresponsavel() {
        return idresponsavel;
    }

    public void setIdresponsavel(int idresponsavel) {
        this.idresponsavel = idresponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
