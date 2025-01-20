package biblioteca;

import java.util.*;
import java.util.stream.Collectors;

public class Archivio {

    private Map<String, Elemento> catalogo;
    public Archivio() {
        this.catalogo = new HashMap<>();
    }

        //    controllo di un oggetto se dubplicato o meno

    public void putElemento (Elemento elemento) throws ArchivioException {
        if (catalogo.containsKey(elemento.getIsbn())){
            throw new ArchivioException ("Questo articolo con ibsn" + elemento.getIsbn()  + " è gia presente nell'archivio ");
        } else catalogo.put(elemento.getIsbn(),elemento);
    }

        //    ricerca oggetto tramite ibsn
    public Elemento ricercaConIbsn (String isbn) throws ArchivioException {
        Elemento elemento = catalogo.get(isbn);
        if (elemento == null){
            throw new ArchivioException("nessun oggetto con questo ibsn" + isbn);

        } return elemento;
    }

        //    rimozione oggetto tramite isbn
    public void rimuoviElemento (String isbn) throws ArchivioException{
        if (!catalogo.containsKey(isbn)){
            throw new ArchivioException("nessun oggetto con questo ibsn" + isbn);
        }
        catalogo.remove(isbn);
    }
        //     ricerca x anno
    public List<Elemento> ricercaAnno (int anno){
        return catalogo
                .values()
                .stream()
                .filter(elemento -> elemento.getAnnoPubblicazione() == anno)
                .collect(Collectors.toList());

    }

        //     ricerca x autore libri

    public List<Libro> ricercaAutore (String autore){
        return catalogo
                .values()
                .stream()
                .filter(elemento -> elemento instanceof Libro && ((Libro) elemento).getAutore().equalsIgnoreCase(autore))
                .map(elemento -> (Libro) elemento)
                .collect(Collectors.toList());

    }
        //     reload di un oggetto
    public void aggiornaElemento (String isbn, Elemento nuovoElemento) throws ArchivioException {
            if (!catalogo.containsKey(isbn)) {
                throw new ArchivioException("nessun oggetto trovato con isbn:" + isbn);
            }
            catalogo.put(isbn,nuovoElemento);
    }

    public void statistiche(){
        //libri totali
        int totLibri = (int) catalogo.values().stream()
                .filter(elemento -> elemento instanceof Libro)
                .count();
        //riviste totali
        int totRiviste = (int) catalogo.values().stream()
                .filter(elemento -> elemento instanceof Rivista)
                .count();
        //oggetto con piu pag.
        Elemento elementoConPiuPagine = catalogo.values().stream()
                .max(Comparator.comparing(Elemento::getNumeroPagine))
                .orElse(null);
        //media pagine
        double mediaPagine = catalogo.values().stream()
                .mapToInt(Elemento::getNumeroPagine)
                .average()
                .orElse(0.0);

        System.out.println("statistiche:");
        System.out.println("nuymero tot di libri" + totLibri);
        System.out.println("numero di riviste" + totRiviste);
        if (elementoConPiuPagine != null){
            System.out.println("elemento con piu pag:" + elementoConPiuPagine.getTitolo() + elementoConPiuPagine.getNumeroPagine());
        }
        System.out.println("media pagine " + mediaPagine);


    }

    public void putElemento(Archivio archivio, Scanner scanner) {
    }
}
