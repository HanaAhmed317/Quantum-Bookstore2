public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println("Quantum book store: Starting tests");
        Inventory inventory = new Inventory();

   
        Paperbook paper = new Paperbook("ISBN001", " Physics", 2005, 100.6,"Hana Ahmed", 6);
        Ebook ebook = new Ebook("ISBN002", " Computing", 2004, 200.5, "Mohamed Ahmed", "PDF");
        Showcasebook showcase = new Showcasebook("ISBN003", "biology", 2003, 300.5,"Ahmed Mohamed");

        inventory.addBook(paper);
        inventory.addBook(ebook);
        inventory.addBook(showcase);

       
        System.out.println("Quantum book store: Removing outdated books (>10 years old)...");
        inventory.removeOutdatedBooks(10);

      
        System.out.println("Quantum book store: Buying a paper book...");
        try {
            inventory.buyBook("ISBN001", 2, null, "123 Quantum Ave");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    
        System.out.println("Quantum book store: Buying an ebook...");
        try {
            inventory.buyBook("ISBN002", 1, "user@example.com", null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

      
        System.out.println("Quantum book store: Attempting to buy a showcase book...");
        try {
            inventory.buyBook("ISBN003", 1, null, null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

      
        System.out.println("Quantum book store: Attempting to buy more paper books than in stock...");
        try {
            inventory.buyBook("ISBN001", 10, null, "123 Quantum Ave");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Quantum book store: Tests complete.");
    }
}
