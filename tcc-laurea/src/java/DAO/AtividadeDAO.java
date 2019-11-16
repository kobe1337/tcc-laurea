package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Atividade;
import model.Disciplina;


public class AtividadeDAO extends DataBaseDAO{

    public AtividadeDAO() throws Exception { }
    
    public ArrayList<Atividade> getLista() throws Exception{
        
        ArrayList<Atividade> lista = new ArrayList<Atividade>();
        String sql = "SELECT ati.* , di.materia FROM atividade ati" +
                        " INNER JOIN disciplina di ON ati.iddisciplina = di.iddisciplina";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            
        Atividade ati = new Atividade();
            
        ati.setIdatividade(rs.getInt("ati.idatividade"));
        ati.setNome(rs.getString("ati.nome"));
        ati.setArquivo(rs.getString("ati.arquivo"));
        
        Disciplina di = new Disciplina();
        di.setIddisciplina(rs.getInt("ati.iddisciplina"));
        di.setMateria(rs.getString("di.materia"));
        ati.setDisciplina(di);
            
            lista.add(ati);
        }
        this.desconectar();
        return lista;
    }
    
    
    public boolean gravar(Atividade ati){
        
        try{
            String sql;
            this.conectar();
            
            if(ati.getIdatividade() == 0){
                sql = "INSERT INTO atividade (nome, arquivo, iddisciplina) VALUES (?, ?, ?)";
            }else{
                sql = "UPDATE atividade SET nome=?, arquivo=?, iddisciplina=? WHERE idatividade=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, ati.getNome());
            pstm.setString(2, ati.getArquivo());
            pstm.setInt(3, ati.getDisciplina().getIddisciplina());
            
            if(ati.getIdatividade() > 0){
                pstm.setInt(4, ati.getIdatividade());
            }
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
        
    }
    
    public Atividade getCarregaPorId(int idatividade) throws Exception{
    
        Atividade ati = new Atividade();
        
        String sql = "SELECT ati.* , di.materia FROM atividade ati" +
                     " INNER JOIN disciplina di ON ati.iddisciplina = di.iddisciplina"+
                     " WHERE idatividade = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1 , idatividade);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            
        ati.setIdatividade(rs.getInt("ati.idatividade"));
        ati.setNome(rs.getString("ati.nome"));
        ati.setArquivo(rs.getString("ati.arquivo"));
        
        Disciplina di = new Disciplina();
        di.setIddisciplina(rs.getInt("ati.iddisciplina"));
        di.setMateria(rs.getString("di.materia"));
        ati.setDisciplina(di);
            
        }
        this.desconectar();
        return ati;
    }
    
    public boolean excluir(Atividade ati){
        
        try{
            this.conectar();
            
            String sql = "DELETE FROM atividade WHERE idatividade=?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1 , ati.getIdatividade());
            pstm.execute();
            this.desconectar();
            return true;
        
        }catch(Exception e){
            
            System.out.println(e);
            return false;
        }
    }
    
}
