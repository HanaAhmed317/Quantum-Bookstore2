import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Book> books;

    public Inventory() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) throws Exception {
        if (findBookByIsbn(book.getIsbn()) != null) {
            throw new Exception("Quantum book store: Book with this ISBN already exists");
        }
        books.add(book);
        System.out.println("Quantum book store: Added '" + book.getTitle() + "' (ISBN: " + book.getIsbn() + ") to inventory.");
    }

    private Book findBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> removeOutdatedBooks(int maxAgeYears) {
        int currentYear = Year.now().getValue();
        List<Book> removedBooks = new ArrayList<>();
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (currentYear - book.getYear() > maxAgeYears) {
                removedBooks.add(book);
                System.out.println("Quantum book store: Removed outdated book '" + book.getTitle() + "' (ISBN: " + book.getIsbn() + ")");
                iterator.remove();
            }
        }
        return removedBooks;
    }

    public double buyBook(String isbn, int quantity, String email, String address) throws Exception {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            throw new Exception("Quantum book store: Book not found");
        }
        if (!book.isForSale()) {
            throw new Exception("Quantum book store: Book is not for sale");
        }
        double paidAmount = book.buy(quantity, email, address);
        System.out.println("Quantum book store: '" + book.getTitle() + "' purchased. Amount paid: " + paidAmount);
        return paidAmount;
    }
}

