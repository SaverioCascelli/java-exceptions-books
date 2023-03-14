public class Main {
    public static void main(String[] args) {

        Book test = null;
        try {
            test = new Book("primo libro", 25, "Gigi", "Gigione");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            test.setAuthor("");
        } catch (NullPointerException | IllegalArgumentException ex) {
            System.out.println("Errore nel campo Autore: " + ex.getMessage());
        }

        try {
            test.setPages(0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Errore nel campo Pagine: " + ex.getMessage());
        }
        System.out.println(test);

    }
}
