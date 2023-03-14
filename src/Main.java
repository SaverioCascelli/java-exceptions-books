import com.sun.jdi.NativeMethodException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);

        System.out.println("Quanti libri vuoi popolare?");

        int booksNumber = 0;
        try {
            int getNumber = Integer.parseInt(scan.nextLine());
            if (getNumber < 1) {
                System.out.println("Input non valido, devi inserire un numero ");
            } else booksNumber = getNumber;
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
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

        scan.close();

        FileWriter fw = null;
        try {
            fw = new FileWriter("./dump.txt");
            for (Book book : bookArr) {
                fw.write(book.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        File myFile = new File("./dump.txt");

        Scanner reader = null;
        try {
            reader = new Scanner(myFile);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
        } catch (FileNotFoundException e) {
            System.out.println("file non trovato");
            System.out.println(e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IllegalStateException e) {
                    System.out.println(e.getMessage());
                }
            }
        }


    }
}
