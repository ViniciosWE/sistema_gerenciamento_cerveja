import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEditarUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;

	public TelaEditarUser() {
		initComponents();
		carregarDadosUsuario();
	}

	private void initComponents() {
		setBackground(new Color(252, 197, 82));
		setBounds(100, 100, 1000, 700);
		setLayout(new MigLayout("", "[grow][][grow][grow]", "[grow][][][][][][][grow]"));

		ImageIcon icon = new ImageIcon(getClass().getResource("/img/logo.png"));
		Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon iconGrande = new ImageIcon(img);
		JLabel lblLogo = new JLabel(iconGrande);
		add(lblLogo, "cell 1 1 2 1,alignx center");

		JLabel titulo = new JLabel("Editar Usuário");
		titulo.setForeground(new Color(72, 79, 38));
		titulo.setFont(new Font("Stencil", Font.BOLD, 30));
		add(titulo, "cell 1 2 2 1,alignx center");

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(72, 79, 38));
		lblNome.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblNome, "cell 1 3,alignx trailing");

		txtNome = new JTextField();
		txtNome.setForeground(new Color(72, 79, 38));
		txtNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(txtNome, "cell 2 3,growx");

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(72, 79, 38));
		lblEmail.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblEmail, "cell 1 4,alignx trailing");

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(72, 79, 38));
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(txtEmail, "cell 2 4,growx");

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(72, 79, 38));
		lblSenha.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblSenha, "cell 1 5,alignx trailing");

		txtSenha = new JPasswordField();
		txtSenha.setForeground(new Color(72, 79, 38));
		txtSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(txtSenha, "cell 2 5,growx");

		JButton btSalvar = new JButton("   Salvar Alterações   ");
		btSalvar.setForeground(new Color(72, 79, 38));
		btSalvar.setBorder(new LineBorder(new Color(72, 79, 38)));
		btSalvar.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(btSalvar, "cell 1 6 2 1,alignx center");

		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText().trim();
				String email = txtEmail.getText().trim();
				String senha = new String(txtSenha.getPassword()).trim();

				if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
					return;
				}

				UsuarioDAO dao = new UsuarioDAO();
				Usuario u = Janela.usuarioAtual;

				u.setNome(nome);
				u.setEmail(email);
				u.setSenha(senha);

				boolean atualizado = dao.atualizar(u);

				if (atualizado) {
					JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário.");
				}
			}
		});
	}

	public void carregarDadosUsuario() {
		if (Janela.usuarioAtual != null) {
			txtNome.setText(Janela.usuarioAtual.getNome());
			txtEmail.setText(Janela.usuarioAtual.getEmail());
			txtSenha.setText(Janela.usuarioAtual.getSenha());
		}
	}
}
