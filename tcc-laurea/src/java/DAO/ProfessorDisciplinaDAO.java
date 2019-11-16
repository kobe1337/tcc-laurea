package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Disciplina;
import model.Professor;
import model.ProfessorDisciplina;


public class ProfessorDisciplinaDAO extends DataBaseDAO{

    public ProfessorDisciplinaDAO() throws Exception { }
    
    public ArrayList<ProfessorDisciplina> getLista() throws Exception{
        
        ArrayList<ProfessorDisciplina> lista = new ArrayList<ProfessorDisciplina>();
        
        String sql = "SELECT pd.* , pr.nome, di.materia FROM professor_disciplina pd" +
                    " INNER JOIN professor pr ON pd.idprofessor = pr.idprofessor" +
                    " INNER JOIN disciplina di ON pd.iddisciplina = di.iddisciplina";
        
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            
            ProfessorDisciplina pd = new ProfessorDisciplina();
            Professor pr = new Professor();
            Disciplina di = new Disciplina();
        
            pr.setIdprofessor(rs.getInt("pd.idprofessor"));
            pr.setNome(rs.getString("pr.nome"));
            pd.setProfessor(pr);
            
            di.setIddisciplina(rs.getInt("pd.iddisciplina"));
            di.setMateria(rs.getString("di.materia"));
            pd.setDisciplina(di);
            
            lista.add(pd);
        }
        
        this.desconectar();
        return lista;
    }
    
    
    public boolean vincular(int idprofessor, int iddisciplina){
        
        try{
            String sql;
            this.conectar();
            
            sql = "INSERT INTO professor_disciplina (idprofessor, iddisciplina) VALUES (?, ?)";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, idprofessor);
            pstm.setInt(2, iddisciplina);
            
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            
            return false;
            
        }
        
    }
    
    public boolean desvincular(int idprofessor, int iddisciplina){
    
        try{
            String sql = "DELETE FROM professor_disciplina WHERE idprofessor = ? AND iddisciplina = ?";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setInt(1, idprofessor);
            pstm.setInt(2, iddisciplina);
            pstm.execute();
            
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            
            return false;
        
        }
    
    }
    
}
