import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TelaEstatisticas extends JPanel {
	private JLabel lblNewLabel;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel_2;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JLabel lblNewLabel_3;
	private JScrollPane scrollPane_2;
	private JTable table_2;

	public TelaEstatisticas() {
		initComponents();
		carregarDados();
	}

	private void initComponents() {
		setBounds(100, 100, 1000, 700);
		setBackground(new Color(252, 197, 82));
		setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][grow]"));

		this.lblNewLabel = new JLabel("Estatística");
		this.lblNewLabel.setForeground(new Color(72, 79, 38));
		this.lblNewLabel.setFont(new Font("Stencil", Font.BOLD, 30));
		add(this.lblNewLabel, "cell 1 1,alignx center");

		this.panel = new JPanel();
		this.panel.setBackground(new Color(252, 197, 82));
		add(this.panel, "cell 1 2,grow");
		this.panel.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][][grow][][][grow][][][grow][][]"));

		this.lblNewLabel_1 = new JLabel("Média de Notas por Tipo");
		this.lblNewLabel_1.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.panel.add(this.lblNewLabel_1, "cell 1 1");

		this.scrollPane = new JScrollPane();
		this.panel.add(this.scrollPane, "cell 1 2,grow");

		this.table = new JTable();
		this.table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Tipo", "Média" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.scrollPane.setViewportView(this.table);

		this.lblNewLabel_2 = new JLabel("Ranking das Cervejas Favoritas");
		this.lblNewLabel_2.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_2.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.panel.add(this.lblNewLabel_2, "cell 1 4");

		this.scrollPane_1 = new JScrollPane();
		this.panel.add(this.scrollPane_1, "cell 1 5,grow");

		this.table_1 = new JTable();
		this.table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Cerveja", "Nota" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.scrollPane_1.setViewportView(this.table_1);

		this.lblNewLabel_3 = new JLabel("Quantidade de Degustações por Mês");
		this.lblNewLabel_3.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_3.setFont(new Font("Sylfaen", Font.BOLD, 20));
		this.panel.add(this.lblNewLabel_3, "cell 1 7");

		this.scrollPane_2 = new JScrollPane();
		this.panel.add(this.scrollPane_2, "cell 1 8,grow");

		this.table_2 = new JTable();
		this.table_2.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Mês", "Quantidade" }) {
			boolean[] columnEditables = new boolean[] { false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		this.scrollPane_2.setViewportView(this.table_2);
	}

	public void carregarDados() {
		CervejaDAO dao = new CervejaDAO();
		int idUser = Janela.usuarioAtual.getId();

		DefaultTableModel modelo1 = (DefaultTableModel) table.getModel();
		List<EstatisticaTipo> listaTipo = dao.mediaPorTipo(idUser);
		for (int i = 0; i < listaTipo.size(); i++) {
			EstatisticaTipo e = listaTipo.get(i);
			modelo1.addRow(new Object[] { e.getTipo(), e.getMedia() });
		}

		DefaultTableModel modelo2 = (DefaultTableModel) table_1.getModel();
		List<Cerveja> ranking = dao.rankingFavoritas(idUser);
		for (int i = 0; i < ranking.size(); i++) {
			Cerveja c = ranking.get(i);
			modelo2.addRow(new Object[] { c.getNome(), c.getNota() });
		}

		DefaultTableModel modelo3 = (DefaultTableModel) table_2.getModel();
		List<EstatisticaMes> listaMes = dao.qtdPorMes(idUser);
		for (int i = 0; i < listaMes.size(); i++) {
			EstatisticaMes m = listaMes.get(i);
			modelo3.addRow(new Object[] { m.getMes(), m.getQuantidade() });
		}
	}
}
