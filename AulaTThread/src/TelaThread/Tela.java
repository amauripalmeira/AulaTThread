package TelaThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela extends JDialog{
	
	JPanel jpainel = new JPanel(new GridBagLayout());
	
	JLabel descricaoNome = new JLabel("Nome");
	JTextField nome = new JTextField();
	
	JLabel descricaoEmail = new JLabel("Email");
	JTextField email = new JTextField();
			
	JButton jbutton = new JButton("Gerar");
	JButton jbutton2 = new JButton("Stop");
	
	public Tela () {
		/*criando a tela */
		setTitle("Tela thread");/*titulo da telinha*/
		setSize(new Dimension(250, 250));/*tamanho da tela*/
		setLocationRelativeTo(null);/*centralizar a tela */
		setResizable(false);/*nao deixa modificar o tamanho*/
		
		GridBagConstraints grid = new GridBagConstraints();
		grid.gridx = 0; // linha 
		grid.gridy = 0 ; // coluna 
		grid.gridwidth = 2; // numeros de colunas 
		grid.anchor = grid.WEST; // para definir posicao do componente
		grid.insets= new Insets(5, 10, 5, 5);
		
		descricaoNome.setPreferredSize(new Dimension(200, 25));
		jpainel.add(descricaoNome, grid);
		
		nome.setPreferredSize(new Dimension(200, 25));
		grid.gridy++;
		jpainel.add(nome, grid);
		
	    descricaoEmail.setPreferredSize(new Dimension(200, 25));
	    grid.gridy++;
	    jpainel.add(descricaoEmail, grid);
	    
	    email.setPreferredSize(new Dimension(200, 25));
	    grid.gridy++;
	    jpainel.add(email, grid);
		
	    //*****************************
	    //adicionado botões 
	    jbutton.setPreferredSize(new Dimension(90, 20));
	    grid.gridy++;
	    jpainel.add(jbutton, grid);
	    
	    jbutton2.setPreferredSize(new Dimension(90, 20));
	    grid.gridx++;
	    jpainel.add(jbutton2, grid);
	    
	    
		add(jpainel , BorderLayout.WEST);
		setVisible(true);
	}

}
