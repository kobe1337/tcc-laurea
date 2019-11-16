package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Responsavel;
import model.Usuario;


public class ResponsavelDAO extends DataBaseDAO{

    public ResponsavelDAO() throws Exception { }
    
    public ArrayList<Responsavel> getLista() throws Exception{
        
        ArrayList<Responsavel> lista = new ArrayList<Responsavel>();
        
        String sql = "SELECT res.*, u.nome FROM responsavel res" +
                     " INNER JOIN usuario u ON res.idusuario = u.idusuario";
        
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            Responsavel res = new Responsavel();
            
         res.setIdresponsavel(rs.getInt("res.idresponsavel"));
         res.setNome(rs.getString("res.nome"));
         res.setCpf(rs.getString("res.cpf"));
         res.setRg(rs.getString("res.rg"));
         res.setStatus(rs.getInt("res.status"));
         
         Usuario u = new Usuario();
         u.setIdusuario(rs.getInt("res.idusuario"));
         u.setNome(rs.getString("u.nome"));
         res.setUsuario(u);
           
            
            lista.add(res);
        }
        this.desconectar();
        return lista;
    }
    
    
    public boolean gravar(Responsavel res){
        
        try{
            String sql;
            this.conectar();
            
            if(res.getIdresponsavel() == 0){
                sql = "INSERT INTO responsavel(nome, cpf, rg, status, idusuario) VALUES (?, ?, ?, ?, ?)";
            }else{
                sql = "UPDATE responsavel SET nome=?, cpf=?, rg=?, status=?, idusuario=? WHERE idresponsavel=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, res.getNome());
            pstm.setString(2, res.getCpf());
            pstm.setString(3, res.getRg());
            pstm.setInt(4, res.getStatus());
            pstm.setInt(5, res.getUsuario().getIdusuario());
            
            if(res.getIdresponsavel() > 0){
                pstm.setInt(6, res.getIdresponsavel());
            }
            
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
        
    }
    
    public Responsavel getCarregaPorId(int idresponsavel) throws Exception{
    
        Responsavel res = new Responsavel();
        
        String sql = "SELECT res.*, u.nome FROM responsavel res" +
                     " INNER JOIN usuario u ON res.idusuario = u.idusuario WHERE idresponsavel = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1 , idresponsavel);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            
         res.setIdresponsavel(rs.getInt("res.idresponsavel"));
         res.setNome(rs.getString("res.nome"));
         res.setCpf(rs.getString("res.cpf"));
         res.setRg(rs.getString("res.rg"));
         res.setStatus(rs.getInt("res.status"));
         
         Usuario u = new Usuario();
         u.setIdusuario(rs.getInt("res.idusuario"));
         u.setNome(rs.getString("u.nome"));
         res.setUsuario(u);
            
        }
        this.desconectar();
        return res;
    }
    
    public boolean desativar(Responsavel res){
        try{
            this.conectar();
            String sql = "UPDATE responsavel SET status=2 WHERE idresponsavel = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1 , res.getIdresponsavel());
            pstm.execute();
            this.desconectar();
            return true;
        
        }catch(Exception e){
            
            System.out.println(e);
            return false;
        }
    }
    
}
