package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Aluno;
import model.Responsavel;
import model.Usuario;


public class AlunoDAO extends DataBaseDAO{

    public AlunoDAO() throws Exception { }
    
    public ArrayList<Aluno> getLista() throws Exception{
        
        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        
        String sql = "SELECT a.*, res.nome, u.nome FROM aluno a" +
                    " INNER JOIN responsavel res ON a.idresponsavel = res.idresponsavel" +
                    " INNER JOIN usuario u ON a.idusuario = u.idusuario";
        
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while(rs.next()){
            Aluno a = new Aluno();
            
            a.setIdaluno(rs.getInt("a.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getString("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            a.setRg(rs.getString("a.rg"));
            a.setStatus(rs.getInt("a.status"));
            
            Responsavel re = new Responsavel();
            re.setIdresponsavel(rs.getInt("a.idresponsavel"));
            re.setNome(rs.getString("res.nome"));
            a.setResponsavel(re);
            
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("a.idusuario"));
            u.setNome(rs.getString("u.nome"));
            a.setUsuario(u);
            
            lista.add(a);
        }
        this.desconectar();
        return lista;
    }
    
    
    public boolean gravar(Aluno a){
        
        try{
            String sql;
            this.conectar();
            
            if(a.getIdaluno() == 0){
                sql = "INSERT INTO aluno(nome, datanasc, cpf, rg, status, idresponsavel, idusuario) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            }else{
                sql = "UPDATE aluno SET nome=?, datanasc=?, cpf=?, rg=?, status=?, idresponsavel=?, "
                        + "idusuario=? WHERE idaluno = ?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getDatanasc());
            pstm.setString(3, a.getCpf());
            pstm.setString(4, a.getRg());
            pstm.setInt(5, a.getStatus());
            pstm.setInt(6, a.getResponsavel().getIdresponsavel());
            pstm.setInt(7, a.getUsuario().getIdusuario());
            
            if(a.getIdaluno() > 0){
                pstm.setInt(8, a.getIdaluno());
            }
            pstm.execute();
            this.desconectar();
            return true;
            
        }catch(Exception e){
            
            System.out.println(e);
            return false;
            
        }
        
    }
    
    public Aluno getCarregaPorId(int idaluno) throws Exception{
    
        Aluno a = new Aluno();
        
        String sql = "SELECT a.*, res.nome, u.nome FROM aluno a" +
                    " INNER JOIN responsavel res ON a.idresponsavel = res.idresponsavel" +
                    " INNER JOIN usuario u ON a.idusuario = u.idusuario WHERE idaluno = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1 , idaluno);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            
            a.setIdaluno(rs.getInt("a.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getString("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            a.setRg(rs.getString("a.rg"));
            a.setStatus(rs.getInt("a.status"));
            
            Responsavel re = new Responsavel();
            re.setIdresponsavel(rs.getInt("a.idresponsavel"));
            re.setNome(rs.getString("res.nome"));
            a.setResponsavel(re);
            
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("a.idusuario"));
            u.setNome(rs.getString("u.nome"));
            a.setUsuario(u);
            
        }
        this.desconectar();
        return a;
    }
    
    
   public boolean desativar(Aluno a){
        try{
            this.conectar();
            String sql = "UPDATE aluno SET status=2 WHERE idaluno = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1 , a.getIdaluno());
            pstm.execute();
            this.desconectar();
            return true;
        
        }catch(Exception e){
            
            System.out.println(e);
            return false;
        }
    }
    
}
