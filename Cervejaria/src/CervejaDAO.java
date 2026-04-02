import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CervejaDAO {

    private Connection conexao;

    public CervejaDAO() {
        this.conexao = Conexao.getConexao();
    }

    public void adicionar(Cerveja c) {
        String sql = "INSERT INTO cerveja (nome, estilo, teor_alcoolico, ibu, pais, fabricante, data_degustacao, local_degustacao, nota, comentarios, sugestao, foto, usuario_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, c.getNome());
            stmt.setString(2, c.getEstilo());
            stmt.setDouble(3, c.getTeorAlcoolico());
            stmt.setInt(4, c.getIbu());
            stmt.setString(5, c.getPais());
            stmt.setString(6, c.getFabricante());
            stmt.setDate(7, c.getDataDegustacao());
            stmt.setString(8, c.getLocalDegustacao());
            stmt.setInt(9, c.getNota());
            stmt.setString(10, c.getComentarios());
            stmt.setString(11, c.getSugestao());
            stmt.setBytes(12, c.getFoto());
            stmt.setInt(13, c.getUsuarioId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar cerveja: " + e.getMessage());
        }
    }

    public List<String> listarEstilosDoUsuario(int usuarioId) {
        String sql = "SELECT DISTINCT estilo FROM cerveja WHERE usuario_id = ? AND estilo IS NOT NULL ORDER BY estilo";
        List<String> estilos = new ArrayList<>();

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                estilos.add(rs.getString("estilo"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar estilos: " + e.getMessage());
        }

        return estilos;
    }

    public Cerveja buscarPorId(int id) {
        String sql = "SELECT * FROM cerveja WHERE id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cerveja c = new Cerveja();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEstilo(rs.getString("estilo"));
                c.setTeorAlcoolico(rs.getDouble("teor_alcoolico"));
                c.setIbu(rs.getInt("ibu"));
                c.setPais(rs.getString("pais"));
                c.setFabricante(rs.getString("fabricante"));
                c.setDataDegustacao(rs.getDate("data_degustacao"));
                c.setLocalDegustacao(rs.getString("local_degustacao"));
                c.setNota(rs.getInt("nota"));
                c.setComentarios(rs.getString("comentarios"));
                c.setSugestao(rs.getString("sugestao"));
                c.setFoto(rs.getBytes("foto"));
                c.setUsuarioId(rs.getInt("usuario_id"));

                rs.close();
                stmt.close();
                return c;
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cerveja: " + e.getMessage());
        }
        return null;
    }

    public List<Cerveja> listar(int usuarioId) {
        List<Cerveja> lista = new ArrayList<>();
        String sql = "SELECT * FROM cerveja WHERE usuario_id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cerveja c = new Cerveja();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEstilo(rs.getString("estilo"));
                c.setTeorAlcoolico(rs.getDouble("teor_alcoolico"));
                c.setIbu(rs.getInt("ibu"));
                c.setPais(rs.getString("pais"));
                c.setFabricante(rs.getString("fabricante"));
                c.setDataDegustacao(rs.getDate("data_degustacao"));
                c.setLocalDegustacao(rs.getString("local_degustacao"));
                c.setNota(rs.getInt("nota"));
                c.setComentarios(rs.getString("comentarios"));
                c.setSugestao(rs.getString("sugestao"));
                c.setFoto(rs.getBytes("foto"));
                c.setUsuarioId(rs.getInt("usuario_id"));

                lista.add(c);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar cervejas: " + e.getMessage());
        }
        return lista;
    }

    public List<Cerveja> listarPorEstilo(String estilo, int usuarioId) {
        List<Cerveja> lista = new ArrayList<>();
        String sql = "SELECT * FROM cerveja WHERE estilo LIKE ? AND usuario_id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + estilo + "%");
            stmt.setInt(2, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cerveja c = new Cerveja();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEstilo(rs.getString("estilo"));
                c.setTeorAlcoolico(rs.getDouble("teor_alcoolico"));
                c.setIbu(rs.getInt("ibu"));
                c.setPais(rs.getString("pais"));
                c.setFabricante(rs.getString("fabricante"));
                c.setDataDegustacao(rs.getDate("data_degustacao"));
                c.setLocalDegustacao(rs.getString("local_degustacao"));
                c.setNota(rs.getInt("nota"));
                c.setComentarios(rs.getString("comentarios"));
                c.setSugestao(rs.getString("sugestao"));
                c.setFoto(rs.getBytes("foto"));
                c.setUsuarioId(rs.getInt("usuario_id"));

                lista.add(c);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao filtrar cervejas por estilo: " + e.getMessage());
        }
        return lista;
    }

    public List<Cerveja> listarPorNota(int notaMin, int usuarioId) {
        List<Cerveja> lista = new ArrayList<>();
        String sql = "SELECT * FROM cerveja WHERE nota = ? AND usuario_id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, notaMin);
            stmt.setInt(2, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cerveja c = new Cerveja();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEstilo(rs.getString("estilo"));
                c.setTeorAlcoolico(rs.getDouble("teor_alcoolico"));
                c.setIbu(rs.getInt("ibu"));
                c.setPais(rs.getString("pais"));
                c.setFabricante(rs.getString("fabricante"));
                c.setDataDegustacao(rs.getDate("data_degustacao"));
                c.setLocalDegustacao(rs.getString("local_degustacao"));
                c.setNota(rs.getInt("nota"));
                c.setComentarios(rs.getString("comentarios"));
                c.setSugestao(rs.getString("sugestao"));
                c.setFoto(rs.getBytes("foto"));
                c.setUsuarioId(rs.getInt("usuario_id"));

                lista.add(c);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao filtrar cervejas por nota: " + e.getMessage());
        }
        return lista;
    }

    public List<Cerveja> listarPorData(String data, int usuarioId) {
        List<Cerveja> lista = new ArrayList<>();
        String sql = "SELECT * FROM cerveja WHERE data_degustacao=? AND usuario_id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, data);
            stmt.setInt(2, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cerveja c = new Cerveja();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEstilo(rs.getString("estilo"));
                c.setTeorAlcoolico(rs.getDouble("teor_alcoolico"));
                c.setIbu(rs.getInt("ibu"));
                c.setPais(rs.getString("pais"));
                c.setFabricante(rs.getString("fabricante"));
                c.setDataDegustacao(rs.getDate("data_degustacao"));
                c.setLocalDegustacao(rs.getString("local_degustacao"));
                c.setNota(rs.getInt("nota"));
                c.setComentarios(rs.getString("comentarios"));
                c.setSugestao(rs.getString("sugestao"));
                c.setFoto(rs.getBytes("foto"));
                c.setUsuarioId(rs.getInt("usuario_id"));

                lista.add(c);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao filtrar cervejas por data: " + e.getMessage());
        }
        return lista;
    }

    public List<Cerveja> listarOrdenado(String campo, int usuarioId) {
        List<Cerveja> lista = new ArrayList<>();
        String sql = "SELECT * FROM cerveja WHERE usuario_id=? ORDER BY " + campo;
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cerveja c = new Cerveja();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setEstilo(rs.getString("estilo"));
                c.setTeorAlcoolico(rs.getDouble("teor_alcoolico"));
                c.setIbu(rs.getInt("ibu"));
                c.setPais(rs.getString("pais"));
                c.setFabricante(rs.getString("fabricante"));
                c.setDataDegustacao(rs.getDate("data_degustacao"));
                c.setLocalDegustacao(rs.getString("local_degustacao"));
                c.setNota(rs.getInt("nota"));
                c.setComentarios(rs.getString("comentarios"));
                c.setSugestao(rs.getString("sugestao"));
                c.setFoto(rs.getBytes("foto"));
                c.setUsuarioId(rs.getInt("usuario_id"));

                lista.add(c);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao ordenar cervejas: " + e.getMessage());
        }
        return lista;
    }

    public double mediaPorEstilo(String estilo, int usuarioId) {
        String sql = "SELECT AVG(nota) AS media FROM cerveja WHERE estilo=? AND usuario_id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, estilo);
            stmt.setInt(2, usuarioId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double media = rs.getDouble("media");
                rs.close();
                stmt.close();
                return media;
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular média por estilo: " + e.getMessage());
        }
        return 0;
    }

    public int totalPorMes(int mes, int ano, int usuarioId) {
        String sql = "SELECT COUNT(*) AS total FROM cerveja WHERE MONTH(data_degustacao)=? AND YEAR(data_degustacao)=? AND usuario_id=?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, mes);
            stmt.setInt(2, ano);
            stmt.setInt(3, usuarioId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int total = rs.getInt("total");
                rs.close();
                stmt.close();
                return total;
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular total por mês: " + e.getMessage());
        }
        return 0;
    }
    
    public List<EstatisticaTipo> mediaPorTipo(int usuarioId) {
        List<EstatisticaTipo> lista = new ArrayList<>();
        String sql = "SELECT estilo, AVG(nota) AS media FROM cerveja WHERE usuario_id=? GROUP BY estilo ORDER BY estilo";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EstatisticaTipo e = new EstatisticaTipo();
                e.setTipo(rs.getString("estilo"));
                e.setMedia(rs.getDouble("media"));
                lista.add(e);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular média por tipo: " + e.getMessage());
        }

        return lista;
    }
    
    public List<Cerveja> rankingFavoritas(int usuarioId) {
        List<Cerveja> lista = new ArrayList<>();
        String sql = "SELECT * FROM cerveja WHERE usuario_id=? ORDER BY nota DESC LIMIT 10"; // top 10

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cerveja c = new Cerveja();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setNota(rs.getInt("nota"));
                lista.add(c);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar ranking: " + e.getMessage());
        }

        return lista;
    }
    
    public List<EstatisticaMes> qtdPorMes(int usuarioId) {
        List<EstatisticaMes> lista = new ArrayList<>();
        String sql = "SELECT MONTH(data_degustacao) AS mes, COUNT(*) AS quantidade " +
                     "FROM cerveja WHERE usuario_id=? GROUP BY MONTH(data_degustacao) ORDER BY mes";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                EstatisticaMes m = new EstatisticaMes();
                m.setMes(rs.getInt("mes"));
                m.setQuantidade(rs.getInt("quantidade"));
                lista.add(m);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao calcular degustações por mês: " + e.getMessage());
        }

        return lista;
    }



}
