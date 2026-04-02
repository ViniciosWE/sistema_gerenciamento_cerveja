import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class TelaCadastraUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblLogo, lblTitulo;
	private JLabel lblNome, lblEmail, lblSenha;
	private JTextField txtNome, txtEmail;
	private JPasswordField txtSenha;
	private JButton btnCadastrar;
	private JLabel lblNewLabel;

	public TelaCadastraUser() {
		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(252, 197, 82));
		setBounds(100, 100, 1000, 700);
		setLayout(new MigLayout("", "[grow][][grow][grow]", "[grow][][][][][][][][][grow]"));

		ImageIcon icon = new ImageIcon(getClass().getResource("/img/logo.png"));
		Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon iconGrande = new ImageIcon(img);
		lblLogo = new JLabel(iconGrande);
		add(lblLogo, "cell 1 1 2 1,alignx center");

		lblTitulo = new JLabel("Cadastro");
		lblTitulo.setForeground(new Color(72, 79, 38));
		lblTitulo.setFont(new Font("Stencil", Font.BOLD, 30));
		add(lblTitulo, "cell 1 2 2 1,alignx center");

		lblNome = new JLabel("Nome:");
		lblNome.setForeground(new Color(72, 79, 38));
		lblNome.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblNome, "cell 1 3,alignx trailing");

		txtNome = new JTextField();
		txtNome.setForeground(new Color(72, 79, 38));
		txtNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(txtNome, "cell 2 3,growx");
		txtNome.setColumns(15);

		lblEmail = new JLabel("Email:");
		lblEmail.setForeground(new Color(72, 79, 38));
		lblEmail.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblEmail, "cell 1 4,alignx trailing");

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(72, 79, 38));
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(txtEmail, "cell 2 4,growx");
		txtEmail.setColumns(15);

		lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(72, 79, 38));
		lblSenha.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblSenha, "cell 1 5,alignx trailing");

		txtSenha = new JPasswordField();
		txtSenha.setForeground(new Color(72, 79, 38));
		txtSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(txtSenha, "cell 2 5,growx");
		txtSenha.setColumns(15);

		btnCadastrar = new JButton("   Cadastrar   ");
		this.btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtNome.getText().trim();
				String email = txtEmail.getText().trim();
				String senha = new String(txtSenha.getPassword()).trim();

				if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
					return;
				}
				
				if (!email.contains("@")) {
		            JOptionPane.showMessageDialog(null, "Email inválido! Deve conter '@'.");
		            return;
		        }

				Usuario user = new Usuario();
				user.setNome(nome);
				user.setEmail(email);
				user.setSenha(senha);

				UsuarioDAO dao = new UsuarioDAO();

				if (dao.usuarioExiste(user)) {
					JOptionPane.showMessageDialog(null, "Esse email já está cadastrado!");
					return;
				}

				dao.adicionar(user);

				txtNome.setText("");
				txtEmail.setText("");
				txtSenha.setText("");

			}
		});
		btnCadastrar.setForeground(new Color(72, 79, 38));
		btnCadastrar.setBorder(new LineBorder(new Color(72, 79, 38)));
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(btnCadastrar, "cell 1 7 2 1,alignx center");

		this.lblNewLabel = new JLabel("Já possui uma conta? Faça o login");

		this.lblNewLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(new Color(72, 79, 38));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(new Color(0, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Janela.frame.setContentPane(new TelaLogin());
				Janela.frame.setVisible(true);
			}
		});

		this.lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 12));
		add(this.lblNewLabel, "cell 1 8 2 1,alignx center");

	}
}
