import biblioteca.Archivio;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Archivio archivio = new Archivio();    //istanza
        Scanner scanner = new Scanner(System.in);

        //true per far parti il codice
        boolean exe = true;



        while (exe) {


            System.out.println(" \n menu, seleziona un opzione valida");
            System.out.println("1- aggiunta di un elementi");
            System.out.println("2- ricerca x isbn");
            System.out.println("3- rimozione elemento");
            System.out.println("4- ricerca x anno");
            System.out.println("5- ricerca x autore");
            System.out.println("6- aggiorna un elemento");
            System.out.println("7- statistiche ");
            System.out.println("8- chiudi");


            int scelta = scanner.nextInt();
            scanner.nextLine();


            try {
                switch (scelta) {
                    case 1:
                        putElemento(archivio, scanner);
                        break;
                    case 2:
                        ricercaConIsbn(archivio, scanner);
                        break;
                    case 3:
                        rimuoviElemento(archivio, scanner);
                        break;
                    case 4:
                        ricercaPerAnno(archivio, scanner);
                        break;
                    case 5:
                        ricercaPerAutore(archivio, scanner);
                        break;
                    case 6:
                        aggiornaElemento(archivio, scanner);
                        break;
                    case 7:
                        archivio.statisticheCatalogo();
                        break;
                    case 8:
                        System.out.println("Chiusura del programma...");
                        exe = false;
                        break;
                    default:
                        System.out.println("Opzione non valida. Riprova.");
                }
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }


        }




    }
}