package biblioteca;

public class Rivista extends Elemento{
    private Periodicita Periodicita;

    public Rivista(String isbn, String titolo, int annoPubblicazione, int numeroPagine, Periodicita periodicita) {
        super(isbn, titolo, annoPubblicazione, numeroPagine);
    }

    public Periodicita getPeriodicita() {
        return Periodicita;
    }
}
