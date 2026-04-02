import javax.swing.*;
import net.miginfocom.swing.MigLayout;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.List;
import javax.imageio.ImageIO;

public class TelaGaleriaRotulos extends JPanel {

	public TelaGaleriaRotulos() {
		initComponents();
	}

	private void initComponents() {
		setBounds(100, 100, 1000, 700);
		setBackground(new Color(252, 197, 82));
		setLayout(new MigLayout("", "[grow]", "[][grow]"));

		JLabel titulo = new JLabel("Galeria de Rótulos", SwingConstants.CENTER);
		titulo.setForeground(new Color(72, 79, 38));
		titulo.setFont(new Font("Stencil", Font.BOLD, 30));
		add(titulo, "cell 0 0, alignx center, gapbottom 20");

		JPanel painelGaleria = new JPanel(new GridLayout(0, 2, 20, 20));
		painelGaleria.setBackground(new Color(252, 197, 82));

		CervejaDAO dao = new CervejaDAO();
		List<Cerveja> lista = dao.listar(Janela.usuarioAtual.getId());

		for (int i = 0; i < lista.size(); i++) {
			Cerveja c = lista.get(i);

			JPanel card = new JPanel(new BorderLayout());
			card.setPreferredSize(new Dimension(180, 240));
			card.setBackground(new Color(255, 230, 150));
			card.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

			JLabel lbImg;

			if (c.getFoto() != null) {
				try {
					BufferedImage img = ImageIO.read(new ByteArrayInputStream(c.getFoto()));
					if (img != null) {
						Image dimg = img.getScaledInstance(160, 160, Image.SCALE_SMOOTH);
						lbImg = new JLabel(new ImageIcon(dimg), SwingConstants.CENTER);
					} else {
						lbImg = new JLabel("Sem imagem", SwingConstants.CENTER);
					}
				} catch (Exception e) {
					lbImg = new JLabel("Erro img", SwingConstants.CENTER);
				}
			} else {
				lbImg = new JLabel("Sem imagem", SwingConstants.CENTER);
			}

			card.add(lbImg, BorderLayout.CENTER);

			JPanel info = new JPanel(new GridLayout(2, 1));
			info.setBackground(new Color(255, 230, 150));

			JLabel lbNome = new JLabel(c.getNome(), SwingConstants.CENTER);
			lbNome.setFont(new Font("Arial", Font.BOLD, 12));
			info.add(lbNome);

			JLabel lbData = new JLabel("", SwingConstants.CENTER);
			lbData.setFont(new Font("Arial", Font.PLAIN, 11));
			if (c.getDataDegustacao() != null) {
				lbData.setText(c.getDataDegustacao().toString());
			}
			info.add(lbData);

			card.add(info, BorderLayout.SOUTH);
			painelGaleria.add(card);
		}

		JScrollPane scroll = new JScrollPane(painelGaleria, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.getVerticalScrollBar().setUnitIncrement(15);
		add(scroll, "cell 0 1, grow");
	}
}
