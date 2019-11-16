package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.Aluno;
import model.Contrato;
import model.Responsavel;


public class ContratoDAO extends DataBaseDAO{

    public ContratoDAO() throws Exception { }
    
    public ArrayList<Contrato> getLista() throws Exception{
        
        ArrayList<Contrato> lista = new ArrayList<Contrato>();
        
        String sql = "SELECT con.*, a.nome, res.nome FROM contrato con" +
                    " INNER JOIN aluno a ON con.idaluno = a.idaluno" +
                    " INNER JOIN responsavel res ON a.idresponsavel = res.idresponsavel";
        
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
          Contrato con = new Contrato();
          Responsavel res = new Responsavel();
          Aluno a = new Aluno();
          
          con.setIdcontrato(rs.getInt("con.idcontrato"));
          
          a.setIdaluno(rs.getInt("con.idaluno"));
          a.setNome(rs.getString("a.nome"));
          res.setNome(rs.getString("res.nome"));
          a.setResponsavel(res);
          con.setAluno(a);
          
          String data = rs.getString("con.datacontrato");

          SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy/MM/dd");
          SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
          String dataConvertida = ddMMyyyy.format(yyyyMMdd.parse(verificarData(data)));
            
          con.setDatacontrato(dataConvertida);
          
          con.setPreco(rs.getDouble("con.preco"));
          con.setParcela(rs.getInt("con.parcela"));
          con.setStatus(rs.getInt("con.status"));
          con.setEscola(rs.getString("con.escola"));
          con.setSerie(rs.getString("con.serie"));
            
            
            lista.add(con);
        }
        this.desconectar();
        return lista;
    }
    
    
    public boolean gravar(Contrato con){
        
        try{
            String sql;
            this.conectar();
            
            if(con.getIdcontrato() == 0){
                sql = "INSERT INTO contrato (datacontrato, preco, parcela, status, serie, escola, idaluno) VALUES (?, ?, ?, ?, ?, ?, ?)";
            }else{
                sql = "UPDATE contrato SET datacontrato=?, preco=?, parcela=?, "
                    + "status=?, serie=?, escola=?, idaluno=? WHERE idcontrato=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, con.getDatacontrato());
            pstm.setDouble(2, con.getPreco());
            pstm.setInt(3, con.getParcela());
            pstm.setInt(4, con.getStatus());
            pstm.setString(5, con.getSerie());
            pstm.setString(6, con.getEscola());
            pstm.setInt(7, con.getAluno().getIdaluno());
            
            if(con.getIdcontrato() > 0){
                pstm.setInt(8, con.getIdcontrato());
            }
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
        
    }
    
    public Contrato getCarregaPorId(int idcontrato) throws Exception{
    
        Contrato con = new Contrato();
        
        String sql = "SELECT con.*, a.nome FROM contrato con "
                + " INNER JOIN aluno a ON con.idaluno = a.idaluno "
                + " WHERE idcontrato = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1 , idcontrato);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            
          Aluno a = new Aluno();
          
          con.setIdcontrato(rs.getInt("con.idcontrato"));
          
          a.setIdaluno(rs.getInt("con.idaluno"));
          a.setNome(rs.getString("a.nome"));
          con.setAluno(a);
          
          con.setDatacontrato(rs.getString("con.datacontrato"));
          con.setPreco(rs.getDouble("con.preco"));
          con.setParcela(rs.getInt("con.parcela"));
          con.setStatus(rs.getInt("con.status"));
          con.setEscola(rs.getString("con.escola"));
          con.setSerie(rs.getString("con.serie"));
            
        }
        this.desconectar();
        return con;
    }
    
    public boolean desativar(Contrato con){
        try{
            this.conectar();
            String sql = "UPDATE contrato SET status=2 WHERE idcontrato = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1 , con.getIdcontrato());
            pstm.execute();
            this.desconectar();
            return true;
        
        }catch(Exception e){
            
            System.out.println(e);
            return false;
        }
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
