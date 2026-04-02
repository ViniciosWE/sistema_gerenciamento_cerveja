import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

public class TelaListacerveja extends JPanel {

	private static final long serialVersionUID = 1L;

	private JLabel lblTitulo;
	private JLabel lblFiltro;
	private JComboBox<String> comboTipoFiltro;
	private JLabel lblOrdenacao;
	private JComboBox<String> comboOrdenacao;

	private JLabel lblEstilo;
	private JComboBox<String> comboEstilos;
	private JLabel lblNota;
	private JSpinner spNota;
	private JLabel lblData;
	private JSpinner spData;

	private JScrollPane scrollPane;
	private JTable tabela;

	private JButton buscar;
	private JButton limpar;

	private CervejaDAO dao = new CervejaDAO();
	private int usuarioID;

	public TelaListacerveja() {
		usuarioID = Janela.usuarioAtual.getId();
		initComponents();
		configurarEventos();
		carregarFiltros();
		atualizarFiltro();
		aplicarFiltros();
	}

	private void initComponents() {
		setBackground(new Color(252, 197, 82));
		setBounds(100, 100, 1000, 700);
		setLayout(new MigLayout("", "[grow][][][][grow][][][][][][][grow]", "[grow][][][][][grow]"));

		lblTitulo = new JLabel("Listar Cervejas");
		lblTitulo.setForeground(new Color(72, 79, 38));
		lblTitulo.setFont(new Font("Stencil", Font.BOLD, 30));
		add(lblTitulo, "cell 2 1 8 1,alignx center");

		lblFiltro = new JLabel("Filtro:");
		lblFiltro.setForeground(new Color(72, 79, 38));
		lblFiltro.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblFiltro, "cell 1 2,alignx right");

		comboTipoFiltro = new JComboBox<String>();
		comboTipoFiltro.addItem("Nenhum");
		comboTipoFiltro.addItem("Estilo");
		comboTipoFiltro.addItem("Nota");
		comboTipoFiltro.addItem("Data");
		add(comboTipoFiltro, "cell 2 2,growx");

		lblEstilo = new JLabel("Estilo:");
		this.lblEstilo.setForeground(new Color(72, 79, 38));
		this.lblEstilo.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblEstilo, "cell 3 2,alignx trailing");
		comboEstilos = new JComboBox<String>();
		add(comboEstilos, "cell 4 2,growx");

		lblData = new JLabel("Data:");
		this.lblData.setForeground(new Color(72, 79, 38));
		this.lblData.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblData, "cell 5 2");
		spData = new JSpinner(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH));
		spData.setEditor(new JSpinner.DateEditor(spData, "dd/MM/yyyy"));
		add(spData, "cell 6 2");

		lblNota = new JLabel("Nota:");
		this.lblNota.setForeground(new Color(72, 79, 38));
		this.lblNota.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblNota, "cell 7 2");
		spNota = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
		add(spNota, "cell 8 2");

		lblOrdenacao = new JLabel("Ordenação:");
		lblOrdenacao.setForeground(new Color(72, 79, 38));
		lblOrdenacao.setFont(new Font("Sylfaen", Font.BOLD, 20));
		add(lblOrdenacao, "cell 9 2,alignx right");

		comboOrdenacao = new JComboBox<String>();
		comboOrdenacao.addItem("Nome");
		comboOrdenacao.addItem("Nota");
		comboOrdenacao.addItem("Pais");
		add(comboOrdenacao, "cell 10 2,growx");

		tabela = new JTable(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "Estilo", "Nota", "País", "Data" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

		tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabela.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					abrirDetalhes();
				}
			}
		});

		buscar = new JButton("Buscar");
		this.buscar.setForeground(new Color(72, 79, 38));
		this.buscar.setFont(new Font("Tahoma", Font.BOLD, 15));
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aplicarFiltros();
			}
		});
		add(buscar, "cell 1 3 5 1,alignx center");

		limpar = new JButton("Limpar");
		this.limpar.setForeground(new Color(72, 79, 38));
		this.limpar.setFont(new Font("Tahoma", Font.BOLD, 15));
		limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboTipoFiltro.setSelectedIndex(0);
				comboOrdenacao.setSelectedIndex(0);
				comboEstilos.setSelectedIndex(0);
				spNota.setValue(0);
				spData.setValue(new Date());
				atualizarFiltro();
				aplicarFiltros();
			}
		});
		add(limpar, "cell 6 3 5 1,alignx center");

		scrollPane = new JScrollPane(tabela);
		add(scrollPane, "cell 1 4 10 1,grow");
	}

	public void configurarEventos() {
		comboTipoFiltro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atualizarFiltro();
			}
		});
	}

	public void carregarFiltros() {
		comboEstilos.removeAllItems();
		List<String> estilos = dao.listarEstilosDoUsuario(usuarioID);
		for (int i = 0; i < estilos.size(); i++) {
			comboEstilos.addItem(estilos.get(i));
		}
	}

	public void carregarTabela(List<Cerveja> lista) {
		DefaultTableModel m = (DefaultTableModel) tabela.getModel();
		m.setRowCount(0);

		for (Cerveja c : lista) {
			m.addRow(new Object[] { c.getId(), c.getNome(), c.getEstilo(), c.getNota(), c.getPais(),
					c.getDataDegustacao() });
		}

	}

	public void atualizarFiltro() {
		String tipo = (String) comboTipoFiltro.getSelectedItem();

		comboEstilos.setVisible(false);
		lblEstilo.setVisible(false);
		spNota.setVisible(false);
		lblNota.setVisible(false);
		spData.setVisible(false);
		lblData.setVisible(false);

		if (tipo.equals("Estilo")) {
			comboEstilos.setVisible(true);
			lblEstilo.setVisible(true);
		}
		if (tipo.equals("Nota")) {
			spNota.setVisible(true);
			lblNota.setVisible(true);
		}
		if (tipo.equals("Data")) {
			spData.setVisible(true);
			lblData.setVisible(true);
		}
	}

	public void aplicarFiltros() {
	    String tipo = (String) comboTipoFiltro.getSelectedItem();
	    String ord = (String) comboOrdenacao.getSelectedItem();
	    List<Cerveja> lista = null;

	    if (tipo.equals("Nenhum")) {
	        lista = dao.listar(usuarioID);
	    } else if (tipo.equals("Estilo")) {
	        lista = dao.listarPorEstilo((String) comboEstilos.getSelectedItem(), usuarioID);
	    } else if (tipo.equals("Nota")) {
	        lista = dao.listarPorNota((int) spNota.getValue(), usuarioID);
	    } else if (tipo.equals("Data")) {
	        Date d = (Date) spData.getValue();
	        java.sql.Date sql = new java.sql.Date(d.getTime());
	        lista = dao.listarPorData(sql.toString(), usuarioID);
	    }

	    for (int i = 0; i < lista.size() - 1; i++) {
	        for (int j = i + 1; j < lista.size(); j++) {
	            Cerveja c1 = lista.get(i);
	            Cerveja c2 = lista.get(j);
	            boolean trocar = false;

	            if (ord.equals("Nome")) {
	                if (c1.getNome().compareToIgnoreCase(c2.getNome()) > 0) {
	                    trocar = true;
	                }
	            } else if (ord.equals("Nota")) {
	                if (c1.getNota() < c2.getNota()) { 
	                    trocar = true;
	                }
	            } else if (ord.equals("Pais")) {
	                if (c1.getPais().compareToIgnoreCase(c2.getPais()) > 0) {
	                    trocar = true;
	                }
	            }

	            if (trocar) {
	                Cerveja temp = c1;
	                lista.set(i, c2);
	                lista.set(j, temp);
	            }
	        }
	    }

	    carregarTabela(lista);
	}


	public void abrirDetalhes() {
	    int linha = tabela.getSelectedRow();
	    if (linha == -1) return;

	    int id = (int) tabela.getModel().getValueAt(linha, 0);

	    Cerveja c = dao.buscarPorId(id); 

	    if (c == null) {
	        JOptionPane.showMessageDialog(null, "Erro ao carregar detalhes.");
	        return;
	    }

	    TelaDetalhaCerveja tela = new TelaDetalhaCerveja(c);
	    tela.setVisible(true);
	}

}
