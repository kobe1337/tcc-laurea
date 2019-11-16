
package model;

public class Mensalidade {
    
    private int idmensalidade;
    private Contrato contrato;
    private String mes;
    private double valor;
    private String datav;
    private String datap;
    private double multa;
    private double desconto;
    private int status;
    private int num;

    public Mensalidade(int idmensalidade, Contrato contrato, String mes, 
            double valor, String datav, String datap, double multa, 
            double desconto, int status, int num) {
        this.idmensalidade = idmensalidade;
        this.contrato = contrato;
        this.mes = mes;
        this.valor = valor;
        this.datav = datav;
        this.datap = datap;
        this.multa = multa;
        this.desconto = desconto;
        this.status = status;
        this.num = num;
    }

    public Mensalidade() {
    }

    public int getIdmensalidade() {
        return idmensalidade;
    }

    public void setIdmensalidade(int idmensalidade) {
        this.idmensalidade = idmensalidade;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDatav() {
        return datav;
    }

    public void setDatav(String datav) {
        this.datav = datav;
    }

    public String getDatap() {
        return datap;
    }

    public void setDatap(String datap) {
        this.datap = datap;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return ""+getValor()+"";
    }   
    
}
