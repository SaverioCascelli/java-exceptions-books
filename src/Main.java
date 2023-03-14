import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Quanti libri vuoi popolare?");

        int booksNumber = 0;
        try {
            booksNumber = Integer.parseInt(scan.nextLine());
            if (booksNumber < 1) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Input non valido, devi inserire un numero positivo");
        }

        Book[] bookArr = new Book[booksNumber];

        for (int i = 0; i < bookArr.length; i++) {

            boolean bookDone = false;

            do {


                System.out.println("Libro " + (i + 1));
                System.out.println("Inserisci Autore");
                String author = scan.nextLine();

                System.out.println("Inserisci Titolo");
                String title = scan.nextLine();

                System.out.println("Inserisci Editore");
                String editor = scan.nextLine();

                System.out.println("Inserisci numero di pagine");
                int pages = 0;
                try {
                    pages = Integer.parseInt(scan.nextLine());
                } catch (IllegalArgumentException e) {
                    System.out.println("Input non valido");
                }

                Book newBook = null;
                try {
                    newBook = new Book(title, pages, author, editor);
                    bookDone = true;
                    bookArr[i] = newBook;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (!bookDone);
        }

        for (int i = 0; i < bookArr.length; i++) {
            System.out.println(bookArr[i]);
        }


    }
}
