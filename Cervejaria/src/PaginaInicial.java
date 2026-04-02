import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class PaginaInicial extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Create the panel.
	 */
	public PaginaInicial() {

		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(252, 197, 82));
		setBounds(100, 100, 1000, 700);
		setLayout(new MigLayout("", "[grow][][grow]", "[grow][][][grow]"));
		
		ImageIcon icon = new ImageIcon(getClass().getResource("/img/logo.png"));
	    Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
	    ImageIcon iconGrande = new ImageIcon(img);
	    lblNewLabel = new JLabel(iconGrande);
	    add(lblNewLabel, "cell 1 1");
		
		this.lblNewLabel_1 = new JLabel("Bem Vindo");
		this.lblNewLabel_1.setForeground(new Color(72, 79, 38));
		this.lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 50));
		add(this.lblNewLabel_1, "cell 1 2,alignx center");
	}

}
