package TelaThread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Tela extends JDialog{
	
	private JPanel jpainel = new JPanel(new GridBagLayout());
	
	private JLabel descricaoNome = new JLabel("Nome");
	private JTextField nome = new JTextField();
	
	private JLabel descricaoEmail = new JLabel("Email");
	private JTextField email = new JTextField();
			
	private JButton jbutton = new JButton("Gerar");
	private JButton jbutton2 = new JButton("Stop");
	
	private FIlaThread fila = new FIlaThread();
	
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
	    grid.gridwidth = 1 ;
	    jbutton.setPreferredSize(new Dimension(90, 20));
	    grid.gridy++;
	    jpainel.add(jbutton, grid);
	    
	    jbutton2.setPreferredSize(new Dimension(90, 20));
	    grid.gridx++;
	    jpainel.add(jbutton2, grid);
	    
	    /*acao do botao gerar */
	    
	    jbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { /*executa o click do botao*/
				if (fila == null) {
					fila = new FIlaThread();
					fila.start();
				}
				for(int qtd=0; qtd<100; qtd++) { /*simular envio em massa */
					ObjetoThread filaThread = new ObjetoThread();
					filaThread.setNome(nome.getText());
					filaThread.setEmail(email.getText());
					fila.add(filaThread);
					jbutton.setEnabled(false);
					jbutton2.setEnabled(true);
				}
				
			}
		});
	    /*acao do segundo botao */
	    jbutton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fila.stop(); 
				fila = null;
				jbutton2.setEnabled(false);
				jbutton.setEnabled(true);
			}
		});
	    fila.start();
	    
		add(jpainel , BorderLayout.WEST);
		setVisible(true);
	}

}
