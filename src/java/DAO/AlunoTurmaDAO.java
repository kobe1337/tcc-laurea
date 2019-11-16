package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Aluno;
import model.AlunoTurma;
import model.Professor;
import model.Turma;
import java.text.SimpleDateFormat;

public class AlunoTurmaDAO extends DataBaseDAO {

    public AlunoTurmaDAO() throws Exception {
    }

    public ArrayList<AlunoTurma> getLista() throws Exception {

        ArrayList<AlunoTurma> lista = new ArrayList<AlunoTurma>();

        String sql = "SELECT atu.*, tu.nome, a.nome, pr.nome FROM aluno_turma atu"
                + " INNER JOIN turma tu ON atu.idturma = tu.idturma"
                + " INNER JOIN professor pr ON tu.idprofessor = pr.idprofessor"
                + " INNER JOIN aluno a ON atu.idaluno = a.idaluno";

        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            AlunoTurma atu = new AlunoTurma();
            Turma tu = new Turma();

            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("atu.idaluno"));
            a.setNome(rs.getString("a.nome"));
            atu.setAluno(a);

            Professor pr = new Professor();
            pr.setNome(rs.getString("pr.nome"));
            tu.setProfessor(pr);
            atu.setTurma(tu);

            tu.setIdturma(rs.getInt("atu.idturma"));
            tu.setNome(rs.getString("tu.nome"));
            atu.setTurma(tu);

            atu.setFrequencia(rs.getString("atu.frequencia"));
            
            String data = rs.getString("atu.data");

            SimpleDateFormat yyyyMMdd = new SimpleDateFormat("yyyy/MM/dd");
            SimpleDateFormat ddMMyyyy = new SimpleDateFormat("dd/MM/yyyy");
            String dataConvertida = ddMMyyyy.format(yyyyMMdd.parse(verificarData(data)));
            
            atu.setData(dataConvertida);

            lista.add(atu);
        }
        this.desconectar();
        return lista;
    }

    public boolean fazerChamada(String data, String frequencia, int idaluno, int idturma) {

        try {
            String sql = "UPDATE aluno_turma SET data=?, frequencia=? WHERE idaluno = ? AND idturma = ?";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, data);
            pstm.setString(2, frequencia);
            pstm.setInt(3, idaluno);
            pstm.setInt(4, idturma);

            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e);

            return false;

        }

    }

    public AlunoTurma getCarregaPorId(int idaluno, int idturma) throws Exception {

        AlunoTurma atu = new AlunoTurma();

        String sql = "SELECT atu.*, tu.nome, a.nome, pr.nome FROM aluno_turma atu"
                + " INNER JOIN turma tu ON atu.idturma = tu.idturma"
                + " INNER JOIN professor pr ON tu.idprofessor = pr.idprofessor"
                + " INNER JOIN aluno a ON atu.idaluno = a.idaluno WHERE atu.idaluno = ?"
                + " AND atu.idturma = ?";

        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setInt(1, idaluno);
        pstm.setInt(2, idturma);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {

            Turma tu = new Turma();

            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("atu.idaluno"));
            a.setNome(rs.getString("a.nome"));
            atu.setAluno(a);

            tu.setIdturma(rs.getInt("atu.idturma"));
            tu.setNome(rs.getString("tu.nome"));
            atu.setTurma(tu);

            atu.setFrequencia(rs.getString("atu.frequencia"));
            atu.setData(rs.getString("atu.data"));
        }
        this.desconectar();
        return atu;
    }

    public boolean vincular(int idaluno, int idturma, String data, String frequencia) {

        try {
            String sql = "INSERT INTO aluno_turma (idaluno, idturma, data, frequencia) "
                    + "VALUES (?, ?, ?, ?)";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idaluno);
            pstm.setInt(2, idturma);
            pstm.setString(3, data);
            pstm.setString(4, frequencia);
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }

    public boolean desvincular(int idaluno, int idturma) {

        try {
            String sql = "DELETE FROM aluno_turma WHERE idaluno = ? AND idturma = ?";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, idaluno);
            pstm.setInt(2, idturma);
            pstm.execute();

            this.desconectar();
            return true;

        } catch (Exception e) {

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
