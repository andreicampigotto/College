package bigPackage;

public class RegisterLogic {
	
	private Book book;
	private int codigo, quantidade;
	
	 public RegisterLogic(int codigo, Book book, int quantidade){
	     book = null;
	     codigo = 1;
	     quantidade = 0;
	    }


	public void setRegisterLogic(int codigo, String titulo, String autor, String editora, String edicao, String descricao, int quantidade){
        Book newBook = new Book(titulo, autor, editora, edicao, descricao );
        this.book = newBook;
        this.quantidade = quantidade;
        this.codigo = codigo;
        
	}
        
    public Book getRegisterLogic(){
        return book;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
	
    public int getCodigo(){
        return codigo++;
    }
    
	Register register = new Register();

	
}

