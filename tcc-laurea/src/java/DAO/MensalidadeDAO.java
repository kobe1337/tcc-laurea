package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import model.Aluno;
import model.CadastroGeral;
import model.Contrato;
import model.Mensalidade;
import model.Responsavel;


public class MensalidadeDAO extends DataBaseDAO{

    public MensalidadeDAO() throws Exception { }
    
    public ArrayList<Mensalidade> getLista() throws Exception{
        
        ArrayList<Mensalidade> lista = new ArrayList<Mensalidade>();
        
        String sql = "SELECT men.*, a.nome, res.nome FROM mensalidade men" +
                    " INNER JOIN contrato con ON men.idcontrato = con.idcontrato" +
                    " INNER JOIN aluno a ON con.idaluno = a.idaluno" +
                    " INNER JOIN responsavel res ON a.idresponsavel = res.idresponsavel";
        
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            
           Mensalidade men = new Mensalidade();
           Contrato con = new Contrato();
           Aluno a = new Aluno();
           Responsavel res = new Responsavel();
           
           
          men.setIdmensalidade(rs.getInt("men.idmensalidade"));
          res.setNome(rs.getString("res.nome"));
          a.setResponsavel(res);
          a.setNome(rs.getString("a.nome"));
          con.setAluno(a);
          con.setIdcontrato(rs.getInt("men.idcontrato"));
          men.setContrato(con);
          men.setMes(rs.getString("men.mes"));
          men.setValor(rs.getDouble("men.valor"));
           
          SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy/MM/dd");
          SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
          
          
          String data1 = rs.getString("men.datav");          
          String dataConvertida1 = ddMMyyyy.format(yyyyMMdd.parse(verificarData(data1)));            
          men.setDatav(dataConvertida1);
          
          
          String data2 = rs.getString("men.datap");
          String dataConvertida2 = ddMMyyyy.format(yyyyMMdd.parse(verificarData(data2)));            
          men.setDatap(dataConvertida2);
           
          
          men.setMulta(rs.getDouble("men.multa"));
          men.setDesconto(rs.getDouble("men.desconto"));
          men.setStatus(rs.getInt("men.status"));
            
            lista.add(men);
        }
        this.desconectar();
        return lista;
    }
    
    public Mensalidade contarRegistro(int idcontrato, int idmensalidade) throws Exception{
    
        Mensalidade men = new Mensalidade();
        
        String sql = "SELECT COUNT(mes) AS num FROM mensalidade WHERE idcontrato = ? AND idmensalidade = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1 , idcontrato);
        pstm.setInt(2 , idmensalidade);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            
           men.setNum(rs.getInt("num"));
            
        }
        this.desconectar();
        return men;
    }
    
    
    public boolean gravar(Mensalidade men){
        try{
            String sql;
            this.conectar();
            
                sql = "INSERT INTO mensalidade (idmensalidade, idcontrato, mes, valor, datav, "
                    + "datap, multa, desconto, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
            PreparedStatement pstm = conn.prepareStatement(sql); 
                
            pstm.setInt(1, men.getIdmensalidade());
            pstm.setInt(2, men.getContrato().getIdcontrato());
            pstm.setString(3, men.getMes());
            pstm.setDouble(4, men.getValor());
            pstm.setString(5, men.getDatav());
            pstm.setString(6, men.getDatap());
            pstm.setDouble(7, men.getMulta());
            pstm.setDouble(8, men.getDesconto());
            pstm.setInt(9, men.getStatus());
            
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
        
    }
    
    
    public boolean atualizar(Mensalidade men){
        try{
            
            String sql;
            this.conectar();
            
                sql = "UPDATE mensalidade SET mes=?, valor=?, datav=?, datap=?,"
                     + "multa=?, desconto=?, status=? WHERE idcontrato=? AND idmensalidade=?";
                
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, men.getMes());
            pstm.setDouble(2, men.getValor());
            pstm.setString(3, men.getDatav());
            pstm.setString(4, men.getDatap());
            pstm.setDouble(5, men.getMulta());
            pstm.setDouble(6, men.getDesconto());
            pstm.setInt(7, men.getStatus());
            pstm.setInt(8, men.getContrato().getIdcontrato());
            pstm.setInt(9, men.getIdmensalidade());
            
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
    }
    
    public Mensalidade getCarregaPorId(int idcontrato, int idmensalidade) throws Exception{
    
        Mensalidade men = new Mensalidade();
        
        String sql = "SELECT men.*, a.nome FROM mensalidade men" +
                    " INNER JOIN contrato con ON men.idcontrato = con.idcontrato" +
                    " INNER JOIN aluno a ON con.idaluno = a.idaluno" +
                    " WHERE men.idcontrato = ? AND men.idmensalidade = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1 , idcontrato);
        pstm.setInt(2 , idmensalidade);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            
           Contrato con = new Contrato();
           Aluno a = new Aluno();
           
           
           men.setIdmensalidade(rs.getInt("men.idmensalidade"));
           a.setNome(rs.getString("a.nome"));
           con.setAluno(a);
           con.setIdcontrato(rs.getInt("men.idcontrato"));
           men.setContrato(con);
           men.setMes(rs.getString("men.mes"));
           men.setValor(rs.getDouble("men.valor"));
           men.setDatav(rs.getString("men.datav"));
           men.setDatap(rs.getString("men.datap"));
           men.setMulta(rs.getDouble("men.multa"));
           men.setDesconto(rs.getDouble("men.desconto"));
           men.setStatus(rs.getInt("men.status"));
            
        }
        this.desconectar();
        return men;
    }
    
    public String verificarData(String data)
    {
        for (int i = 0; i < data.length(); i++)
        {
            char d = data.charAt(i);
            if (d == '-')
                data = data.replace ('-', '/');
        }           
        return data;        
    }
}
    
