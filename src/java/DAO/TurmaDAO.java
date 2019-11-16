package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Professor;
import model.Turma;


public class TurmaDAO extends DataBaseDAO{

    public TurmaDAO() throws Exception { }
    
    public ArrayList<Turma> getLista() throws Exception{
        
        ArrayList<Turma> lista = new ArrayList<Turma>();
        String sql = "SELECT tu.*, pr.nome FROM turma tu" +
                    " INNER JOIN professor pr ON tu.idprofessor = pr.idprofessor";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            Turma tu = new Turma();
            tu.setIdturma(rs.getInt("tu.idturma"));
            tu.setNome(rs.getString("tu.nome"));
            
            Professor pr = new Professor();
            pr.setIdprofessor(rs.getInt("tu.idprofessor"));
            pr.setNome(rs.getString("pr.nome"));
            tu.setProfessor(pr);
            
            lista.add(tu);
        }
        this.desconectar();
        return lista;
    }
    
  
    
    public boolean gravar(Turma tu){
        
        try{
            String sql;
            this.conectar();
            
            if(tu.getIdturma() == 0){
                sql = "INSERT INTO turma(nome, idprofessor) VALUES (?, ?) ";
            }else{
                sql = "UPDATE turma SET nome=?, idprofessor=? WHERE idturma=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, tu.getNome());
            pstm.setInt(2, tu.getProfessor().getIdprofessor());
            
            if(tu.getIdturma() > 0){
                pstm.setInt(3, tu.getIdturma());
            }
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
        
    }
    
      
    
    public Turma getCarregaPorId(int idturma) throws Exception{
    
        Turma tu = new Turma();
        
        String sql = "SELECT tu.*, pr.nome FROM turma tu" +
                    " INNER JOIN professor pr ON tu.idprofessor = pr.idprofessor"+ 
                    " WHERE tu.idturma = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1 , idturma);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            
            tu.setIdturma(rs.getInt("tu.idturma"));
            tu.setNome(rs.getString("tu.nome"));
            
            Professor pr = new Professor();
            pr.setIdprofessor(rs.getInt("tu.idprofessor"));
            pr.setNome(rs.getString("pr.nome"));
            tu.setProfessor(pr);
            
        }
        this.desconectar();
        return tu;
    }
    
    
    
    
    public boolean excluir(Turma tu){
        try{
            this.conectar();
            String sql = "DELETE FROM turma WHERE idturma=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1 , tu.getIdturma());
            pstm.execute();
            this.desconectar();
            return true;
        
        }catch(Exception e){
            
            System.out.println(e);
            return false;
        }
    }
    
    
}
