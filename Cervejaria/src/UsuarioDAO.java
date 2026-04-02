
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UsuarioDAO {
	private Connection conexao;

	public UsuarioDAO() {
		this.conexao = Conexao.getConexao();
	}

	public void adicionar(Usuario user) {
		String sql = "insert into usuario (nome, email, senha) values (?,?,?)";
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, user.getNome());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getSenha());

			boolean resultado = stmt.execute();
			if (!resultado) {
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
			}

			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean validarLogin(String email, String senha) {
        String sql = "SELECT senha FROM usuario WHERE email = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String senhaBD = rs.getString("senha");
                return senhaBD.equals(senha);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar login: " + e.getMessage());
        }
        return false;
    }
	
	public boolean usuarioExiste(Usuario user) {
	    String sql = "select email from usuario where email = ?";
	    try {
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setString(1, user.getEmail());
	        ResultSet rs = stmt.executeQuery();
	        boolean existe = rs.next();
	        rs.close();
	        stmt.close();
	        return existe;
	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao verificar usuário: " + e.getMessage());
	        return false;
	    }
	}
	
	public Usuario buscarPorEmail(String email) {
	    String sql = "SELECT * FROM usuario WHERE email = ?";
	    
	    try {
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setString(1, email);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            Usuario u = new Usuario();
	            u.setId(rs.getInt("id"));
	            u.setNome(rs.getString("nome"));
	            u.setEmail(rs.getString("email"));
	            u.setSenha(rs.getString("senha"));
	            
	            rs.close();
	            stmt.close();
	            return u;
	        }

	        rs.close();
	        stmt.close();
	        return null;

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao buscar usuário: " + e.getMessage());
	        return null;
	    }
	}
	
	public boolean atualizar(Usuario user) {
	    String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ? WHERE id = ?";
	    try {
	        PreparedStatement stmt = conexao.prepareStatement(sql);
	        stmt.setString(1, user.getNome());
	        stmt.setString(2, user.getEmail());
	        stmt.setString(3, user.getSenha());
	        stmt.setInt(4, user.getId());

	        int linhas = stmt.executeUpdate();
	        stmt.close();

	        return linhas > 0;

	    } catch (SQLException e) {
	        JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário: " + e.getMessage());
	        return false;
	    }
	}


	
	

}