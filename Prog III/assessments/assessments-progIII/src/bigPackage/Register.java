package bigPackage;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Register extends JFrame {
	
	private DAO dao = new DAO();
	
	private final JButton btSaveButton = new JButton("Cadastrar");
	private JTextField txBookName;
	private JTextField txAuthorName;
	private JTextField txEdition;
	private JTextField txPublish;
	private JTextField txBookCod;
	private JTextField txQuantidade;


	public Register() {
		
		JLabel lbTittle = new JLabel("Cadastro de livros");
		lbTittle.setBounds(258, 6, 117, 16);
		getContentPane().add(lbTittle);
		
		JLabel lbBookName = new JLabel("Titulo:");
		lbBookName.setBounds(154, 34, 41, 16);
		getContentPane().add(lbBookName);
		
		txBookName = new JTextField();
		txBookName.setBounds(191, 29, 165, 26);
		getContentPane().add(txBookName);
		txBookName.setColumns(10);
		
		JLabel lbAuthor = new JLabel("Autor:");
		lbAuthor.setBounds(6, 62, 41, 16);
		getContentPane().add(lbAuthor);
		
		txAuthorName = new JTextField();
		txAuthorName.setBounds(74, 57, 217, 26);
		getContentPane().add(txAuthorName);
		txAuthorName.setColumns(10);
		
		JLabel lbEdition = new JLabel("Edicao:");
		lbEdition.setBounds(293, 62, 48, 16);
		getContentPane().add(lbEdition);
		
		txEdition = new JTextField();
		txEdition.setBounds(338, 57, 61, 26);
		getContentPane().add(txEdition);
		txEdition.setColumns(10);
		
		JLabel lbPublishing = new JLabel("Editora:");
		lbPublishing.setBounds(364, 34, 48, 16);
		getContentPane().add(lbPublishing);
		
		txPublish = new JTextField();
		txPublish.setBounds(414, 29, 130, 26);
		getContentPane().add(txPublish);
		txPublish.setColumns(10);
		
		JLabel lbcod = new JLabel("Codigo:");
		lbcod.setBounds(6, 35, 61, 16);
		getContentPane().add(lbcod);
		
		txBookCod = new JTextField();
		txBookCod.setText("001");
		txBookCod.setBounds(74, 29, 68, 26);
		txBookCod.setEditable(false);
		getContentPane().add(txBookCod);
		txBookCod.setColumns(10);
		
		JLabel lbDescription = new JLabel("Descicao:");
		lbDescription.setBounds(6, 90, 61, 16);
		getContentPane().add(lbDescription);
		
		JLabel lbQuantidade = new JLabel("Quantidade:");
		lbQuantidade.setBounds(410, 62, 76, 16);
		getContentPane().add(lbQuantidade);
		
		txQuantidade = new JTextField();
		txQuantidade.setBounds(496, 57, 48, 26);
		getContentPane().add(txQuantidade);
		txQuantidade.setColumns(10);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 183);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		
		btSaveButton.setBounds(434, 116, 117, 29);
		getContentPane().add(btSaveButton);
		btSaveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String titulo = txBookName.getText();
				String autor = txAuthorName.getText();
				String editora = txPublish.getText();
				String edicao = txEdition.getText();
				String descricao = txDescription.getText();
				int codigo = Integer.parseInt(txBookCod.getText());
				int quantidade = Integer.parseInt(txQuantidade.getText());

				Book book = new Book(titulo,autor ,editora, edicao, descricao);
				RegisterLogic registerLogic= new RegisterLogic(codigo, book, quantidade);
				
				registerLogic.setRegisterLogic(codigo, titulo,autor ,editora, edicao, descricao, quantidade);
				
				// Add to DAO
				dao.addRegister(registerLogic);

				// Reset
				txBookName.setText("");
				txAuthorName.setText("");
				txPublish.setText("");
				txEdition.setText("");
				txDescription.setText("");
				txBookCod.setText("");
				txQuantidade.setText("");
				
			};
			
			
		});
		
		txDescription = new JTextField();
		txDescription.setBounds(74, 85, 470, 26);
		getContentPane().add(txDescription);
		txDescription.setColumns(10);
		
		
	}
	

	private JTextField txDescription;
		
	
}
