package TelaThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class Tela extends JDialog{
	
	JPanel jpaneil = new JPanel(new GridBagLayout());
	
	public Tela () {
		setTitle("Tela thread");/*titulo da telinha*/
		setSize(new Dimension(250, 250));/*tamanho da tela*/
		setLocationRelativeTo(null);/*centralizar a tela */
		setResizable(false);/*nao deixa modificar o tamanho*/
		
		add(jpaneil , BorderLayout.WEST);
		setVisible(true);
	}

}
