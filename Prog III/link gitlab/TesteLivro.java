public class TesteLivro {
    public static void main(String[] args) {
        AutorLivro autor = new AutorLivro();
        autor.nome = "Billy Bill";
        autor.anoNascimento = "1969";
        autor.bestSeller = "the middle";
        System.out.println(autor);

        Editora editora = new Editora();
        editora.nome = "middle of midldle";
        editora.cnpj = "098965414576";
        editora.endereco = "Rua Alcatraz n100";
        System.out.println(editora);

        Livro livro = new Livro();
        livro.titulo = "The Mito";
        livro.autor = autor;
        livro.editora = editora;
        livro.anoPublicacao = "1989";
        livro.sinopse = "the book hystory about the mito";     
        System.out.println(livro);

        VendaLivro venda =  new VendaLivro();
        venda.titulo = livro;
        venda.valor = 19.90;
        System.out.println(venda);
    }
}