public class Books {
    private int id;
    private String title;
    private String author;
    private double price;
    private BookGenre genre;

    Books(int id, String title, String author, double price, BookGenre genre){
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.genre = genre;
    }

    public int getId() { return this.id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return this.title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return this.author; }
    public void setAuthor(String author) { this.author = author; }

    public double getPrice() { return this.price; }
    public void setPrice(double price) { this.price = price; }

    public BookGenre getGenre() { return this.genre; }
    public void setGenre(BookGenre genre) { this.genre = genre; }

    @Override
    public String toString() {
        return (this.id + " | " + this.getAuthor() + " - " + this.getTitle() + " | " + this.getGenre() + " genre | " + this.getPrice() + " HUF\n");
    }
}

