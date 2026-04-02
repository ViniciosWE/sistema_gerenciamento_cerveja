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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel email;
	private JLabel senha;
	private JTextField txtEmail;
	private JButton btLogar;
	private JPasswordField txtSenha;
	private JLabel lblNewLabel_2;

	/**
	 * Create the panel.
	 */
	public TelaLogin() {
		
		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(252, 197, 82));
		setBounds(100, 100, 1000, 700);
		setLayout(new MigLayout("", "[grow][][grow][grow]", "[grow][][][][][][][][grow]"));
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/img/logo.png"));
	    Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	    ImageIcon iconGrande = new ImageIcon(img);
	    lblNewLabel = new JLabel(iconGrande);
	    add(lblNewLabel, "cell 1 1 2 1,alignx center");
		
	    this.lblNewLabel_1 = new JLabel("Login");
		this.lblNewLabel_1.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 30));
		add(this.lblNewLabel_1, "cell 1 2 2 1,alignx center");
		
		this.email = new JLabel("Email:");
		this.email.setForeground(new Color(72, 79, 38));
		this.email.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.email, "cell 1 3,alignx trailing");
		
		this.txtEmail = new JTextField();
		this.txtEmail.setForeground(new Color(72, 79, 38));
		this.txtEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.txtEmail, "cell 2 3,growx");
		this.txtEmail.setColumns(10);
		
		this.senha = new JLabel("Senha:");
		this.senha.setForeground(new Color(72, 79, 38));
		this.senha.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.senha, "cell 1 4,alignx trailing");
		
		this.txtSenha = new JPasswordField();
		this.txtSenha.setForeground(new Color(72, 79, 38));
		this.txtSenha.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.txtSenha, "cell 2 4,growx");
		
		this.btLogar = new JButton("   Logar   ");
		this.btLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String email = txtEmail.getText().trim();
				String senha = new String(txtSenha.getPassword()).trim();

			    if (email.isEmpty() || senha.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
			        return;
			    }

			    UsuarioDAO dao = new UsuarioDAO();


			    boolean loginValido = dao.validarLogin(email, senha);

			    if (loginValido) {
			    	Usuario usuario = dao.buscarPorEmail(email);
			    	Janela.usuarioAtual = usuario;
			        JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
			        Janela.frame.setContentPane(new PaginaInicial());
                    Janela.frame.setVisible(true);

			    } else {
			        JOptionPane.showMessageDialog(null, "Email ou senha incorretos!");
			    }
			}
		});
		this.btLogar.setForeground(new Color(72, 79, 38));
		this.btLogar.setBorder(new LineBorder(new Color(72, 79, 38)));
		this.btLogar.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(this.btLogar, "cell 1 6 2 1,alignx center");
		
		this.lblNewLabel_2 = new JLabel("Ainda não possui uma conta? Cadastre-se");
		this.lblNewLabel_2.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setForeground(new Color(72, 79, 38));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(new Color(0, 0, 0));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				Janela.frame.setContentPane(new TelaCadastraUser());
				Janela.frame.setVisible(true);
			}
		});
		this.lblNewLabel_2.setFont(new Font("Stencil", Font.PLAIN, 12));
		add(this.lblNewLabel_2, "cell 1 7 2 1,alignx center");
	}

}
