package biblioteca;

public class Libro extends Elemento{
    private String autore;
    private String genere;


    public Libro(String isbn, String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String Getgerenere(){
        return genere;
    }

    public String getAutore() {
        return autore;
    }
}
