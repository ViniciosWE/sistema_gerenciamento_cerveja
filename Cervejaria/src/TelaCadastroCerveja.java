import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.NumberFormatter;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class TelaCadastroCerveja extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtNome;
	private JLabel lblNewLabel_2;
	private JTextField txtEstilo;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JSpinner spData;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JTextField txtTeor;
	private JTextField txtIbu;
	private JTextField txtPais;
	private JTextField txtFabricante;
	private JTextField txtLocal;
	private JSpinner spNota;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JTextArea txtSugestao;
	private JTextArea textArea_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private byte[] fotoBytes = null;

	/**
	 * Create the panel.
	 */
	public TelaCadastroCerveja() {

		initComponents();
	}

	private void initComponents() {
		setBackground(new Color(252, 197, 82));
		setBounds(100, 100, 1000, 700);
		setLayout(new MigLayout("", "[grow][][grow][grow]", "[grow][][][][][][][][][][][grow][grow][42.00][][grow]"));

		this.lblNewLabel = new JLabel("Cadastro de Cerveja");
		this.lblNewLabel.setForeground(new Color(72, 79, 38));
		this.lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 30));
		add(this.lblNewLabel, "cell 1 1 2 1,alignx center");

		this.lblNewLabel_1 = new JLabel("Nome:");
		this.lblNewLabel_1.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_1, "cell 1 2,alignx right");

		this.txtNome = new JTextField();
		this.txtNome.setForeground(new Color(72, 79, 38));
		this.txtNome.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.txtNome, "cell 2 2,growx,aligny center");
		this.txtNome.setColumns(10);

		this.lblNewLabel_2 = new JLabel("Estilo:");
		this.lblNewLabel_2.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_2, "cell 1 3,alignx trailing");

		this.txtEstilo = new JTextField();
		this.txtEstilo.setForeground(new Color(72, 79, 38));
		this.txtEstilo.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.txtEstilo, "cell 2 3,growx,aligny center");
		this.txtEstilo.setColumns(10);

		this.lblNewLabel_3 = new JLabel("Teor Alcoólico:");
		this.lblNewLabel_3.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_3, "cell 1 4,alignx trailing");

		NumberFormat formatDecimal = NumberFormat.getNumberInstance(Locale.US);
		NumberFormatter formatterDecimal = new NumberFormatter(formatDecimal);
		formatterDecimal.setValueClass(Double.class);
		formatterDecimal.setAllowsInvalid(true);
		formatterDecimal.setMinimum(0.0);

		this.txtTeor = new JFormattedTextField(formatterDecimal);
		this.txtTeor.setForeground(new Color(72, 79, 38));
		this.txtTeor.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.txtTeor, "cell 2 4,growx,aligny center");


		this.lblNewLabel_4 = new JLabel("IBU:");
		this.lblNewLabel_4.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_4, "cell 1 5,alignx trailing");

		NumberFormatter formatterInt = new NumberFormatter(NumberFormat.getIntegerInstance());
		formatterInt.setValueClass(Integer.class);
		formatterInt.setAllowsInvalid(false);
		formatterInt.setMinimum(0);

		this.txtIbu = new JFormattedTextField(formatterInt);
		this.txtIbu.setForeground(new Color(72, 79, 38));
		this.txtIbu.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.txtIbu, "cell 2 5,growx,aligny center");

		this.lblNewLabel_5 = new JLabel("País:");
		this.lblNewLabel_5.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_5.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_5, "cell 1 6,alignx trailing");

		this.txtPais = new JTextField();
		this.txtPais.setForeground(new Color(72, 79, 38));
		this.txtPais.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.txtPais, "cell 2 6,growx,aligny center");
		this.txtPais.setColumns(10);

		this.lblNewLabel_6 = new JLabel("Fabricante:");
		this.lblNewLabel_6.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_6.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_6, "cell 1 7,alignx trailing");

		this.txtFabricante = new JTextField();
		this.txtFabricante.setForeground(new Color(72, 79, 38));
		this.txtFabricante.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.txtFabricante, "cell 2 7,growx,aligny center");
		this.txtFabricante.setColumns(10);

		this.lblNewLabel_7 = new JLabel("Local Degustação:");
		this.lblNewLabel_7.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_7.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_7, "cell 1 8,alignx trailing");

		this.txtLocal = new JTextField();
		this.txtLocal.setForeground(new Color(72, 79, 38));
		this.txtLocal.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.txtLocal, "cell 2 8,growx,aligny center");
		this.txtLocal.setColumns(10);

		this.lblNewLabel_8 = new JLabel("Data Degustação:");
		this.lblNewLabel_8.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_8.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_8, "cell 1 9,alignx right");

		this.spData = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor editorData = new JSpinner.DateEditor(this.spData, "dd-MM-yyyy");
		this.spData.setEditor(editorData);

		this.spData.setForeground(new Color(72, 79, 38));
		this.spData.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.spData, "cell 2 9,alignx left,aligny center");

		this.lblNewLabel_9 = new JLabel("Nota:");
		this.lblNewLabel_9.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_9.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_9, "cell 1 10,alignx right");

		this.spNota = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		this.spNota.setPreferredSize(new Dimension(111, 20));
		this.spNota.setForeground(new Color(72, 79, 38));
		this.spNota.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(this.spNota, "cell 2 10,alignx left,aligny center");

		this.lblNewLabel_10 = new JLabel("Comentários:");
		this.lblNewLabel_10.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_10.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_10, "cell 1 11,alignx right");

		this.scrollPane = new JScrollPane();
		add(this.scrollPane, "cell 2 11,grow");

		this.txtSugestao = new JTextArea();
		this.txtSugestao.setLineWrap(true);
		this.txtSugestao.setWrapStyleWord(true);
		this.txtSugestao.setForeground(new Color(72, 79, 38));
		this.txtSugestao.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.scrollPane.setViewportView(this.txtSugestao);

		this.lblNewLabel_11 = new JLabel("Sugestão:");
		this.lblNewLabel_11.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_11.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_11, "cell 1 12,alignx right");

		this.scrollPane_1 = new JScrollPane();
		add(this.scrollPane_1, "cell 2 12,grow");

		this.textArea_1 = new JTextArea();
		this.textArea_1.setLineWrap(true);
		this.textArea_1.setWrapStyleWord(true);
		this.textArea_1.setForeground(new Color(72, 79, 38));
		this.textArea_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.scrollPane_1.setViewportView(this.textArea_1);

		this.lblNewLabel_12 = new JLabel("Foto:");
		this.lblNewLabel_12.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_12.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(this.lblNewLabel_12, "cell 1 13,alignx right");

		this.btnNewButton_1 = new JButton("Escolher foto...");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png", "gif");
				fileChooser.setFileFilter(filter);

				int result = fileChooser.showOpenDialog(TelaCadastroCerveja.this);

				if (result == JFileChooser.APPROVE_OPTION) {
					File arquivo = fileChooser.getSelectedFile();

					try {
						fotoBytes = java.nio.file.Files.readAllBytes(arquivo.toPath());
						JOptionPane.showMessageDialog(null, "Foto carregada com sucesso!");

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Erro ao carregar foto: " + ex.getMessage());
					}
				}
			}
		});
		this.btnNewButton_1.setForeground(new Color(72, 79, 38));
		this.btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		add(this.btnNewButton_1, "cell 2 13");

		this.btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNome.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O nome é obrigatório!");
					return;
				}

				if (fotoBytes == null) {
					JOptionPane.showMessageDialog(null, "Escolha uma foto!");
					return;
				}

				Cerveja c = new Cerveja();
				c.setNome(txtNome.getText());
				c.setEstilo(txtEstilo.getText());
				c.setTeorAlcoolico(Double.parseDouble(txtTeor.getText()));
				c.setIbu(Integer.parseInt(txtIbu.getText()));
				c.setPais(txtPais.getText());
				c.setFabricante(txtFabricante.getText());
				c.setLocalDegustacao(txtLocal.getText());

				java.util.Date dataUtil = (java.util.Date) spData.getValue();
				java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
				c.setDataDegustacao(dataSql);

				c.setNota((Integer) spNota.getValue());
				c.setComentarios(txtSugestao.getText());
				c.setSugestao(textArea_1.getText());
				c.setFoto(fotoBytes);
				c.setUsuarioId(Janela.usuarioAtual.getId());

				new CervejaDAO().adicionar(c);

				JOptionPane.showMessageDialog(null, "Cerveja cadastrada com sucesso!");

				txtNome.setText("");
				txtEstilo.setText("");
				txtTeor.setText("0");
				txtIbu.setText("0");
				txtPais.setText("");
				txtFabricante.setText("");
				txtLocal.setText("");
				txtSugestao.setText("");
				textArea_1.setText("");

				spNota.setValue(0);
				spData.setValue(new java.util.Date());

				fotoBytes = null;
			}
		});

		this.btnNewButton.setForeground(new Color(72, 79, 38));
		this.btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		add(this.btnNewButton, "cell 1 14 2 1,alignx center,aligny center");
	}

}
