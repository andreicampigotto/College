public class Livro{

    String titulo;
    AutorLivro autor;
    String anoPublicacao;
    Editora editora;
    String sinopse;
    
    public String toString(){
        return titulo + " " + autor + " " + editora  + " " + sinopse + " " + anoPublicacao;    
    }
}