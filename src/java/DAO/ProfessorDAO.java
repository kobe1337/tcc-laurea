package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Professor;
import model.Usuario;


public class ProfessorDAO extends DataBaseDAO{

    public ProfessorDAO() throws Exception { }
    
    public ArrayList<Professor> getLista() throws Exception{
        
        ArrayList<Professor> lista = new ArrayList<Professor>();
        String sql = "SELECT pr.*, u.nome FROM professor pr" +
                    " INNER JOIN usuario u ON pr.idusuario = u.idusuario";
        
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            Professor pr = new Professor();
            pr.setIdprofessor(rs.getInt("pr.idprofessor"));
            pr.setNome(rs.getString("pr.nome"));
            pr.setStatus(rs.getInt("pr.status"));
            
            
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("pr.idusuario"));
            u.setNome(rs.getString("u.nome"));
            pr.setUsuario(u);
            
            
            lista.add(pr);
        }
        this.desconectar();
        return lista;
    }
    
    public boolean gravar(Professor pr){
        
        try{
            String sql;
            this.conectar();
            
            if(pr.getIdprofessor() == 0){
                sql = "INSERT INTO professor (nome, status, idusuario) VALUES (?, ?, ?)";
            }else{
                sql = "UPDATE professor SET nome=?, status=?, idusuario=? WHERE idprofessor=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, pr.getNome());
            pstm.setInt(2, pr.getStatus());
            pstm.setInt(3, pr.getUsuario().getIdusuario());
            
            if(pr.getIdprofessor() > 0){
                pstm.setInt(4, pr.getIdprofessor());
            }
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
        
    }
    
    public Professor getCarregaPorId(int idprofessor) throws Exception{
    
        Professor pr = new Professor();
        String sql = "SELECT pr.*, u.nome FROM professor pr" +
                    " INNER JOIN usuario u ON pr.idusuario = u.idusuario WHERE pr.idprofessor = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1 , idprofessor);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            
            pr.setIdprofessor(rs.getInt("pr.idprofessor"));
            pr.setNome(rs.getString("pr.nome"));
            pr.setStatus(rs.getInt("pr.status"));
            
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("pr.idusuario"));
            u.setNome(rs.getString("u.nome"));
            pr.setUsuario(u);
        }
        this.desconectar();
        return pr;
    }
    
    public boolean desativar(Professor pr){
        try{
            this.conectar();
            String sql = "UPDATE professor SET status=2 WHERE idprofessor = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1 , pr.getIdprofessor());
            pstm.execute();
            this.desconectar();
            return true;
        
        }catch(Exception e){
            
            System.out.println(e);
            return false;
        }
    }
    
    
    
}
