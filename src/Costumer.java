public class Costumer extends Main {
    private int wallet;
    private boolean hasBook;
    private int bookId;
    Costumer (int wallet, int bookId) {
        this.wallet = wallet;
        this.bookId = --bookId;
        this.hasBook = true;
    }

    Costumer (int wallet) {
        this.wallet = wallet;
        hasBook = false;
    }

    public int getWallet() { return wallet; }
    public void setWallet(int wallet) { this.wallet = wallet; }

    public boolean getHasBook() { return hasBook; }
    public void setHasBook(boolean hasBook) { this.hasBook = hasBook; }

    public int getBookId() { return this.bookId; }
    public void setBookId(int bookId) { this.bookId = bookId; }

    public Costumer buy(int choice21) {
        int bookprice = 0;
        for (Books book : books) {
            if (book.getId() == choice21){
                bookprice = (int)book.getPrice();
                break;
            }
        }
        this.setWallet(this.getWallet() - bookprice);
        return this;
    }

    public Costumer sell(int choice22) {
        int bookprice = (int)books.get(this.bookId).getPrice();
        this.setWallet(this.getWallet() + bookprice);
        return this;
    }
}
