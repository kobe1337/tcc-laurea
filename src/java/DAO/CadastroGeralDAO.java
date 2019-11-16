package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Usuario;
import model.Aluno;
import model.Responsavel;
import model.CadastroGeral;
import model.Contrato;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CadastroGeralDAO extends DataBaseDAO {

    public CadastroGeralDAO() throws Exception {
    }

    public boolean gravarUsuarioResponsavel(Responsavel res) {

        try {
            String sql;
            this.conectar();

            sql = "INSERT INTO usuario(nome, login, senha, status, idperfil) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, res.getUsuario().getNome());
            pstm.setString(2, res.getUsuario().getLogin());
            pstm.setString(3, res.getUsuario().getSenha());
            pstm.setInt(4, res.getUsuario().getStatus());
            pstm.setInt(5, res.getUsuario().getPerfil().getIdperfil());

            pstm.execute();

            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }

    public boolean gravarUsuarioAluno(Aluno a) {

        try {
            String sql;
            this.conectar();

            sql = "INSERT INTO usuario(nome, login, senha, status, idperfil) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, a.getUsuario().getNome());
            pstm.setString(2, a.getUsuario().getLogin());
            pstm.setString(3, a.getUsuario().getSenha());
            pstm.setInt(4, a.getUsuario().getStatus());
            pstm.setInt(5, a.getUsuario().getPerfil().getIdperfil());

            pstm.execute();

            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }

    public CadastroGeral getCarregaPorIdUsuarioResp(String nome_u_res) throws Exception {

        CadastroGeral cg = new CadastroGeral();

        String sql = "SELECT idusuario FROM usuario WHERE nome = ?";

        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, nome_u_res);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {

            Usuario u = new Usuario();
            Responsavel res = new Responsavel();

            u.setIdusuario(rs.getInt("idusuario"));
            res.setUsuario(u);
            cg.setResponsavel(res);

        }
        this.desconectar();
        return cg;
    }

    public CadastroGeral getCarregaPorIdUsuarioAlun(String nome_u_al) throws Exception {

        CadastroGeral cg = new CadastroGeral();

        String sql = "SELECT idusuario FROM usuario WHERE nome = ?";

        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, nome_u_al);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {

            Usuario u = new Usuario();
            Aluno a = new Aluno();

            u.setIdusuario(rs.getInt("idusuario"));
            a.setUsuario(u);
            cg.setAluno(a);

        }
        this.desconectar();
        return cg;
    }

    public boolean gravarResponsavel(Responsavel res, int idusuario) {

        try {
            String sql;
            this.conectar();

            sql = "INSERT INTO responsavel(nome, cpf, rg, status, idusuario) "
                    + "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, res.getNome());
            pstm.setString(2, res.getCpf());
            pstm.setString(3, res.getRg());
            pstm.setInt(4, res.getStatus());
            pstm.setInt(5, idusuario);

            pstm.execute();

            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }

    public CadastroGeral getCarregaPorIdResponsavel(String nome_res) throws Exception {

        CadastroGeral cg = new CadastroGeral();

        String sql = "SELECT idresponsavel FROM responsavel WHERE nome = ?";

        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, nome_res);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {

            Responsavel res = new Responsavel();

            res.setIdresponsavel(rs.getInt("idresponsavel"));
            cg.setResponsavel(res);

        }
        this.desconectar();
        return cg;
    }

    public boolean gravarAluno(Aluno a, int idresponsavel, int idusuario) {

        try {
            String sql;
            this.conectar();

            sql = "INSERT INTO aluno(nome, datanasc, cpf, rg, status, idresponsavel, idusuario) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getDatanasc());
            pstm.setString(3, a.getCpf());
            pstm.setString(4, a.getRg());
            pstm.setInt(5, a.getStatus());
            pstm.setInt(6, idresponsavel);
            pstm.setInt(7, idusuario);

            pstm.execute();

            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }

    public CadastroGeral getCarregaPorIdAlunoCon(String nome_al, String nome_res, int idresponsavel) throws Exception {

        CadastroGeral cg = new CadastroGeral();

        String sql = "SELECT a.idaluno FROM aluno a"
                + " INNER JOIN responsavel res ON a.idresponsavel = res.idresponsavel"
                + " WHERE a.nome = ? AND res.nome = ? AND res.idresponsavel = ?";

        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, nome_al);
        pstm.setString(2, nome_res);
        pstm.setInt(3, idresponsavel);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {

            Aluno a = new Aluno();

            a.setIdaluno(rs.getInt("idaluno"));
            cg.setAluno(a);

        }
        this.desconectar();
        return cg;
    }

    public double calcularPrecoCon(double valor_men, int qtd_parcelas,
            double desconto_men) throws Exception {

        double preco;

        preco = (valor_men - desconto_men) * qtd_parcelas;
        return preco;
    }

    public boolean gravarContrato(Contrato con, double preco, int idaluno) {

        try {
            String sql;
            this.conectar();

            sql = "INSERT INTO contrato(datacontrato, preco, parcela, status,"
                    + " serie, escola, idaluno) VALUES "
                    + "(?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, con.getDatacontrato());
            pstm.setDouble(2, preco);
            pstm.setInt(3, con.getParcela());
            pstm.setInt(4, con.getStatus());
            pstm.setString(5, con.getSerie());
            pstm.setString(6, con.getEscola());
            pstm.setInt(7, idaluno);

            pstm.execute();

            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }

    public CadastroGeral getCarregaPorIdContrato(int idaluno, int idresponsavel) throws Exception {

        CadastroGeral cg = new CadastroGeral();

        String sql = "SELECT con.idcontrato FROM aluno a"
                + " INNER JOIN responsavel res ON a.idresponsavel = res.idresponsavel"
                + " INNER JOIN contrato con ON a.idaluno = con.idaluno"
                + " WHERE a.idaluno = ? AND res.idresponsavel = ?";

        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setInt(1, idaluno);
        pstm.setInt(2, idresponsavel);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {

            Contrato con = new Contrato();

            con.setIdcontrato(rs.getInt("idcontrato"));
            cg.setContrato(con);

        }
        this.desconectar();
        return cg;
    }

    public boolean gerarMensalidades(int mes_i, String datav, int qtd_parcelas,
            double valor_men, double desconto_men, int idcontrato) {

        try {
            String sql;
            this.conectar();

            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

            for (int i = mes_i; i < (mes_i + qtd_parcelas); i++) {

                sql = "INSERT INTO mensalidade(idmensalidade, idcontrato, mes, valor,"
                        + " datav, datap, multa, desconto, status) VALUES "
                        + "(?, ?, ?, ?, ?, '2000-01-01', 0.0, ?, 2);";

                PreparedStatement pstm = conn.prepareStatement(sql);
                
                CadastroGeral data = converterData(datav);
                
                int ano;
                int dia = data.getDia();
                
                if(i > 12){
                    ano = data.getAno() + 1;
                }else{
                    ano = data.getAno();
                }

                int n = reduzirValor(i);

                pstm.setInt(1, n);
                pstm.setInt(2, idcontrato);

                switch (n) {
                    case 1:
                        pstm.setString(3, "janeiro");
                        Calendar c1 = new GregorianCalendar(ano, 0, dia);
                        String novadata1 = sd.format(c1.getTime());
                        pstm.setString(5, novadata1);
                        break;
                    case 2:
                        pstm.setString(3, "fevereiro");
                        Calendar c2 = new GregorianCalendar(ano, 1, dia);
                        String novadata2 = sd.format(c2.getTime());
                        pstm.setString(5, novadata2);
                        break;
                    case 3:
                        pstm.setString(3, "março");
                        Calendar c3 = new GregorianCalendar(ano, 2, dia);
                        String novadata3 = sd.format(c3.getTime());
                        pstm.setString(5, novadata3);
                        break;
                    case 4:
                        pstm.setString(3, "abril");
                        Calendar c4 = new GregorianCalendar(ano, 3, dia);
                        String novadata4 = sd.format(c4.getTime());
                        pstm.setString(5, novadata4);
                        break;
                    case 5:
                        pstm.setString(3, "maio");
                        Calendar c5 = new GregorianCalendar(ano, 4, dia);
                        String novadata5 = sd.format(c5.getTime());
                        pstm.setString(5, novadata5);
                        break;
                    case 6:
                        pstm.setString(3, "junho");
                        Calendar c6 = new GregorianCalendar(ano, 5, dia);
                        String novadata6 = sd.format(c6.getTime());
                        pstm.setString(5, novadata6);
                        break;
                    case 7:
                        pstm.setString(3, "julho");
                        Calendar c7 = new GregorianCalendar(ano, 6, dia);
                        String novadata7 = sd.format(c7.getTime());
                        pstm.setString(5, novadata7);
                        break;
                    case 8:
                        pstm.setString(3, "agosto");
                        Calendar c8 = new GregorianCalendar(ano, 7, dia);
                        String novadata8 = sd.format(c8.getTime());
                        pstm.setString(5, novadata8);
                        break;
                    case 9:
                        pstm.setString(3, "setembro");
                        Calendar c9 = new GregorianCalendar(ano, 8, dia);
                        String novadata9 = sd.format(c9.getTime());
                        pstm.setString(5, novadata9);
                        break;
                    case 10:
                        pstm.setString(3, "outubro");
                        Calendar c10 = new GregorianCalendar(ano, 9, dia);
                        String novadata10 = sd.format(c10.getTime());
                        pstm.setString(5, novadata10);
                        break;
                    case 11:
                        pstm.setString(3, "novembro");
                        Calendar c11 = new GregorianCalendar(ano, 10, dia);
                        String novadata11 = sd.format(c11.getTime());
                        pstm.setString(5, novadata11);
                        break;
                    case 12:
                        pstm.setString(3, "dezembro");
                        Calendar c12 = new GregorianCalendar(ano, 11, dia);
                        String novadata12 = sd.format(c12.getTime());
                        pstm.setString(5, novadata12);
                        break;
                }

                pstm.setDouble(4, valor_men);
                pstm.setDouble(6, desconto_men);

                pstm.execute();

            }

            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }

    public int reduzirValor(int i) {

        if (i > 12) {
            int n = i - 12;

            return n;

        } else {
            int n = i;
            return n;
        }

    }

    public CadastroGeral converterData(String data) {

        CadastroGeral cg = new CadastroGeral();

        char[] x = new char[10];

        for (int i = 0; i < 10; i++) {
            char d = data.charAt(i);

            x[i] = d;

        }

        String anoS = Character.toString(x[0]) + Character.toString(x[1])
                + Character.toString(x[2]) + Character.toString(x[3]);

        int ano = Integer.parseInt(anoS);
        cg.setAno(ano);

        String diaS = Character.toString(x[8]) + Character.toString(x[9]);

        int dia = Integer.parseInt(diaS);
        cg.setDia(dia);

        return cg;

    }

}
