package bigPackage;

public class Book {

	String titulo, editora, autor, edicao, descicao;
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getDescicao() {
		return descicao;
	}

	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}

	//Constructor
	 public Book(String titulo, String autor, String editora, String edicao, String descricao){
	        
		 this.titulo = titulo;
	     this.autor = autor;
	     this.editora = editora;
	     this.edicao = edicao;
	     this.descicao = descricao;
	     
	  }

	 
}
