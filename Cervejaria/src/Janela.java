import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	static Janela frame;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem_3;
	public static Usuario usuarioAtual = null;
	private JMenu mnNewMenu_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
					frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Janela() {

		initComponents();
		setLocationRelativeTo(null);
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		this.menuBar = new JMenuBar();
		setJMenuBar(this.menuBar);
		
		ImageIcon iconLista = carregarIcone("/img/lista.png");
		ImageIcon iconEstatistica = carregarIcone("/img/estatistica.png");
		ImageIcon iconGaleria = carregarIcone("/img/galeria.png");
		ImageIcon iconTelaInicial = carregarIcone("/img/home.png");
		ImageIcon iconCerveja = carregarIcone("/img/copo.png");
		ImageIcon iconSair = carregarIcone("/img/sair.png");
		ImageIcon iconUser = carregarIcone("/img/user.png");
		ImageIcon iconLogin = carregarIcone("/img/chave.png");
		ImageIcon iconCadastrar = carregarIcone("/img/mais.png");
		ImageIcon iconEditar = carregarIcone("/img/lapis.png");
		
		this.mnNewMenu_3 = new JMenu("Tela Inicial");
		this.mnNewMenu_3.setIcon(iconTelaInicial);
		this.mnNewMenu_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Janela.frame.setContentPane(new PaginaInicial());
		        Janela.frame.setVisible(true);
			}
			
		});
		this.menuBar.add(this.mnNewMenu_3);
		
		
		this.mnNewMenu = new JMenu("Usuário");
		this.mnNewMenu.setIcon(iconUser);
		this.menuBar.add(this.mnNewMenu);
		
		this.mntmNewMenuItem = new JMenuItem("Logar", iconLogin);
		this.mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.frame.setContentPane(new TelaLogin());
		        Janela.frame.setVisible(true);
			}
		});
		this.mnNewMenu.add(this.mntmNewMenuItem);
		
		this.mntmNewMenuItem_1 = new JMenuItem("Cadastrar", iconCadastrar);
		this.mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Janela.frame.setContentPane(new TelaCadastraUser());
		        Janela.frame.setVisible(true);
			}
		});
		this.mnNewMenu.add(this.mntmNewMenuItem_1);
		
		this.mntmNewMenuItem_2 = new JMenuItem("Editar ", iconEditar);
		this.mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (Janela.usuarioAtual == null) {
			            JOptionPane.showMessageDialog(null, "Você precisa fazer login primeiro!");
			            return;
				   }
					Janela.frame.setContentPane(new TelaEditarUser());
					Janela.frame.setVisible(true);
			}
		});
		this.mnNewMenu.add(this.mntmNewMenuItem_2);
		
		this.mnNewMenu_1 = new JMenu("Cerveja");
		this.mnNewMenu_1.setIcon(iconCerveja);
		this.menuBar.add(this.mnNewMenu_1);
		
		this.mntmNewMenuItem_3 = new JMenuItem("Cadastrar", iconCadastrar);
		this.mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Janela.usuarioAtual == null) {
		            JOptionPane.showMessageDialog(null, "Você precisa fazer login primeiro!");
		            return;
			   }
				Janela.frame.setContentPane(new TelaCadastroCerveja());
				Janela.frame.setVisible(true);
			}
		});
		this.mnNewMenu_1.add(this.mntmNewMenuItem_3);
		
		this.mntmNewMenuItem_4 = new JMenuItem("Listar Cervejas", iconLista);
		this.mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Janela.usuarioAtual == null) {
		            JOptionPane.showMessageDialog(null, "Você precisa fazer login primeiro!");
		            return;
			   }
				Janela.frame.setContentPane(new TelaListacerveja());
				Janela.frame.setVisible(true);
			}
		});
		this.mnNewMenu_1.add(this.mntmNewMenuItem_4);
		
		this.mntmNewMenuItem_5 = new JMenuItem("Galeria de Rótulos", iconGaleria);
		this.mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Janela.usuarioAtual == null) {
		            JOptionPane.showMessageDialog(null, "Você precisa fazer login primeiro!");
		            return;
			   }
				Janela.frame.setContentPane(new TelaGaleriaRotulos());
				Janela.frame.setVisible(true);
			}
		});
		this.mnNewMenu_1.add(this.mntmNewMenuItem_5);
		
		this.mntmNewMenuItem_6 = new JMenuItem("Estatísticas", iconEstatistica);
		this.mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Janela.usuarioAtual == null) {
		            JOptionPane.showMessageDialog(null, "Você precisa fazer login primeiro!");
		            return;
			   }
				Janela.frame.setContentPane(new TelaEstatisticas());
				Janela.frame.setVisible(true);
			}
		});
		this.mnNewMenu_1.add(this.mntmNewMenuItem_6);
		
		this.mnNewMenu_2 = new JMenu("Sair");
		this.mnNewMenu_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		this.mnNewMenu_2.setIcon(iconSair);
		this.menuBar.add(this.mnNewMenu_2);
		
		PaginaInicial pi = new PaginaInicial();
		this.setContentPane(pi);
	}
	
	private ImageIcon carregarIcone(String caminho) {
	    ImageIcon icon = new ImageIcon(getClass().getResource(caminho));
	    Image img = icon.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
	    ImageIcon iconPequena = new ImageIcon(img);
	    return iconPequena;
	}

}
