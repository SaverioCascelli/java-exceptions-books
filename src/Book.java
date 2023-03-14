public class Book {
    private String title;
    private int pages;
    private String author;
    private String editor;

    public Book(String title, int pages, String author, String editor) throws IllegalArgumentException, NullPointerException {
        checkString(title, "Titolo");
        checkString(author, "Autore");
        checkString(editor, "Editore");
        checkPositiveInt(pages, "Pagine");
        this.title = title;
        this.pages = pages;
        this.author = author;
        this.editor = editor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        checkString(title, "Titolo");
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        checkPositiveInt(pages, "Pagine");
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        checkString(author, "Autore");
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        checkString(editor, "Editore");
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", editor='" + editor + '\'' +
                '}';
    }

    private void checkString(String str, String field) throws NullPointerException, IllegalArgumentException {
        if (str == null) {
            throw new NullPointerException(field + " nullo non valido.");
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException(field + " di 0 caratteri non valido.");
        }
    }

    private void checkPositiveInt(int numb, String field) throws IllegalArgumentException {
        if (numb <= 0) {
            throw new IllegalArgumentException(field + " deve essere di almeno 1.");
        }
    }
}
