
import java.awt.Image;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class TelaDetalhaCerveja extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel img;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel nome;
	private JLabel estilo;
	private JLabel pais;
	private JLabel local;
	private JLabel fabricante;
	private JLabel nota;
	private JLabel data;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea comentarios;
	private JTextArea sugestao;
	private Cerveja cerveja;

	public TelaDetalhaCerveja(Cerveja c) {
		this.cerveja = c;
		initComponents();
		preencherDados();
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		this.contentPane = new JPanel();
		this.contentPane.setBackground(new Color(252, 197, 82));
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane
				.setLayout(new MigLayout("", "[grow][grow][][][][][grow]", "[grow][][][][][][][grow][][grow][grow]"));

		this.img = new JLabel("");
		this.img.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.contentPane.add(this.img, "cell 1 1 1 4");

		this.lblNewLabel = new JLabel("Nome:");
		this.lblNewLabel.setForeground(new Color(72, 79, 38));
		this.lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.contentPane.add(this.lblNewLabel, "cell 2 1,alignx right");

		this.nome = new JLabel("");
		this.contentPane.add(this.nome, "cell 3 1");

		this.lblNewLabel_3 = new JLabel("Fabricante:");
		this.lblNewLabel_3.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.contentPane.add(this.lblNewLabel_3, "cell 4 1,alignx right");

		this.fabricante = new JLabel("");
		this.contentPane.add(this.fabricante, "cell 5 1");

		this.lblNewLabel_1 = new JLabel("Estilo:");
		this.lblNewLabel_1.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.contentPane.add(this.lblNewLabel_1, "cell 2 2,alignx right");

		this.estilo = new JLabel("");
		this.contentPane.add(this.estilo, "cell 3 2");

		this.lblNewLabel_4 = new JLabel("Nota:");
		this.lblNewLabel_4.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.contentPane.add(this.lblNewLabel_4, "cell 4 2,alignx right");

		this.nota = new JLabel("");
		this.contentPane.add(this.nota, "cell 5 2");

		this.lblNewLabel_2 = new JLabel("Pais:");
		this.lblNewLabel_2.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.contentPane.add(this.lblNewLabel_2, "cell 2 3,alignx right");

		this.pais = new JLabel("");
		this.contentPane.add(this.pais, "cell 3 3");

		this.lblNewLabel_5 = new JLabel("Data:");
		this.lblNewLabel_5.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_5.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.contentPane.add(this.lblNewLabel_5, "cell 4 3,alignx right");

		this.data = new JLabel("");
		this.contentPane.add(this.data, "cell 5 3");

		this.lblNewLabel_6 = new JLabel("Local:");
		this.lblNewLabel_6.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_6.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.contentPane.add(this.lblNewLabel_6, "cell 2 4,alignx right");

		this.local = new JLabel("");
		this.contentPane.add(this.local, "cell 3 4");

		this.lblNewLabel_7 = new JLabel("Comentários:");
		this.lblNewLabel_7.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_7.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.contentPane.add(this.lblNewLabel_7, "cell 1 6");

		this.scrollPane = new JScrollPane();
		this.contentPane.add(this.scrollPane, "cell 1 7 5 1,grow");

		this.comentarios = new JTextArea();
		this.comentarios.setLineWrap(true);
		this.comentarios.setWrapStyleWord(true);
		this.comentarios.setBorder(null);
		this.comentarios.setBackground(new Color(252, 197, 82));
		this.comentarios.setEditable(false);
		this.scrollPane.setViewportView(this.comentarios);

		this.lblNewLabel_8 = new JLabel("Sugestão:");
		this.lblNewLabel_8.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_8.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.contentPane.add(this.lblNewLabel_8, "cell 1 8");

		this.scrollPane_1 = new JScrollPane();
		this.contentPane.add(this.scrollPane_1, "cell 1 9 5 1,grow");

		this.sugestao = new JTextArea();
		this.sugestao.setLineWrap(true);
		this.sugestao.setWrapStyleWord(true);
		this.sugestao.setBorder(null);
		this.sugestao.setBackground(new Color(252, 197, 82));
		this.sugestao.setEditable(false);
		this.scrollPane_1.setViewportView(this.sugestao);
	}

	public void preencherDados() {
		if (cerveja == null) {
			return;
		}

		nome.setText(cerveja.getNome());
		fabricante.setText(cerveja.getFabricante());
		estilo.setText(cerveja.getEstilo());
		nota.setText(String.valueOf(cerveja.getNota()));
		pais.setText(cerveja.getPais());
		SimpleDateFormat formatoBrasileiro = new SimpleDateFormat("dd/MM/yyyy");
		data.setText(formatoBrasileiro.format(cerveja.getDataDegustacao()));

		local.setText(cerveja.getLocalDegustacao());
		comentarios.setText(cerveja.getComentarios());
		sugestao.setText(cerveja.getSugestao());

		carregarImagem(cerveja.getFoto());
	}

	public void carregarImagem(byte[] bytes) {
		if (bytes == null || bytes.length == 0) {
			img.setIcon(null);
			img.setText("Sem foto");
			img.setHorizontalAlignment(SwingConstants.CENTER);
			return;
		}

		ImageIcon icon = new ImageIcon(bytes);
		Image escala = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		img.setIcon(new ImageIcon(escala));
		img.setText("");
	}

}
