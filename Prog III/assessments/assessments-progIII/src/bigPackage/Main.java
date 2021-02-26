package bigPackage;



public class Main {
	public static void main(String[] args) {
		
		//teste
		DAO dao = new DAO();
		Book book = new Book("blaWar","autor" ,"editora", "edicao", "descricao");
		RegisterLogic teste1 = new RegisterLogic(1, book, 2);
		RegisterLogic teste2 = new RegisterLogic(1, book, 2);
		RegisterLogic teste3 = new RegisterLogic(1, book, 2);

		dao.addRegister(teste1);
		dao.addRegister(teste2);
		dao.addRegister(teste3);
		
		BookList bookList = new BookList();
		
		try {
			bookList.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}
	
}
