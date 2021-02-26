package bigPackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Component;

public class BookList extends JFrame {

	
	Register register = new Register();
	
	private DAO dao = new DAO();
	private DefaultTableModel tableData;
	private JPanel contentPane;
	private JButton btAtt;
	private JTable table;

	public BookList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 354);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btNewBook = new JButton("Novo Livro");
		btNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					register.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		tableData = new DefaultTableModel(
				new String[][] { },
				new String[] { "Codigo", "Titulo", "Autor", "Editora", "Edicao", "Quantidade", "Descricao" }
		);
		
		btNewBook.setBounds(5, 5, 114, 29);
		contentPane.add(btNewBook);
		
		
		btAtt = new JButton("Atualizar");
		btAtt.setBounds(343, 5, 117, 29);
		contentPane.add(btAtt);
		btAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (RegisterLogic  registerLogic  : dao.returnRegister() ) {
					tableData.addRow(new String[] {String.valueOf(registerLogic.getCodigo()), registerLogic.getRegisterLogic().getTitulo(), 
							registerLogic.getRegisterLogic().getAutor(), registerLogic.getRegisterLogic().getEditora(), registerLogic.getRegisterLogic().getEdicao(),
							String.valueOf(registerLogic.getQuantidade()), registerLogic.getRegisterLogic().getDescicao()});
				};
			};
		});
		getContentPane().add(btAtt);
		
		
		JTable table = new JTable(tableData);
		table.setForeground(Color.LIGHT_GRAY);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.setRowSelectionAllowed(false);
		table.setBackground(Color.CYAN);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(tableData);
		table.setBounds(452, 56, -438, 270);
		contentPane.add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 45, 455, 281);
		contentPane.add(scrollPane);

			
	}
}
