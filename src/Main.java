import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public abstract class Main {

    static ArrayList<Books> books = new ArrayList<>();

    public static void setData() {

        books.add(new Books(1, "1984", "George Orwell", 1984, BookGenre.Art));
        books.add(new Books(2, "Thorn Bird", "Colleen McCulough", 2050, BookGenre.Art));
        books.add(new Books(3, "The adventure of Sherlock Holmes", "Arthur Conan Doyle", 1890, BookGenre.Art));
        books.add(new Books(4, "Three Comrades", "Erich Maria Remarque", 2500, BookGenre.Art));
        books.add(new Books(5, "Crime and Punishment", "Fedor Dostoevsky", 3000, BookGenre.Art));
        books.add(new Books(6, "Angels & Demons", "Dan Brown", 4500, BookGenre.Art));

        books.add(new Books(7, "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert Martin", 5600, BookGenre.Programming));
        books.add(new Books(8, "The Art of Computer Programming", "Donald Knuth", 6700, BookGenre.Programming));
        books.add(new Books(9, "Programming - Principles and Practice Using C++", "Bjarne Stroustrup", 4900, BookGenre.Programming));
        books.add(new Books(10, "Code Complete: A Practical Handbook of Software Construction", "Steve McConnell", 6300, BookGenre.Programming));
        books.add(new Books(11, "Design Patterns: Elements of Reusable Object-Oriented Software", "Erich Gamma", 5300, BookGenre.Programming));
        books.add(new Books(12, "The Pragmatic Programmer", "Andrew Hunt", 3500, BookGenre.Programming));

        books.add(new Books(13, "The Psychopath Test", "Jon Ronson", 3500, BookGenre.Psychology));
        books.add(new Books(14, "Thinking Fast and Slow", "Daniel Kahenman", 4090, BookGenre.Psychology));
        books.add(new Books(15, "Predictably Irrational", "Dan Ariely", 5000, BookGenre.Psychology));
        books.add(new Books(16, "The Confidence Game", "Maria Konnikova", 7200, BookGenre.Psychology));
        books.add(new Books(17, "The Power of Habit", "Charles Duhigg", 4600, BookGenre.Psychology));
        books.add(new Books(18, "Grit", "Angela Duckworth", 2500, BookGenre.Psychology));

    }

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        setData(); // sets the books
        Costumer Altan = new Costumer(20000, 5); // adds the costumer Altan who has 20,000 forints and the book which id 5

        System.out.println("Hello, Sir! Welcome to Almat's book store. What would you like to ask? Do you want to buy or sell a book? (buy/sell)");
        String choiceBuySell = scan.nextLine();
        boolean found = false;

        switch (choiceBuySell) {

            // if we choose buying a book---------------------------------------------------------------------------------------
            case "buy": {
                System.out.println("Would you like to add some filters? (yes/no)");
                String choiceAddingFilter = scan.nextLine();

                // options about adding filters or not ( yes / no )
                switch (choiceAddingFilter) {

                    // choice about adding filter
                    case "yes": {
                        System.out.println("Choose one of the price segments (Write the digit!) \n1. > 0 HUF \n2. 0 - 2000 HUF \n3. > 2000 HUF \n4. 2000 - 4000 HUF \n5. > 4000 HUF \n6. 4000 - 6000 HUF \n7. > 6000 HUF");

                        int choicePrice = scan.nextInt();

                        // if we choose the 1st price segment-----------------------------------------------------------
                        if (choicePrice == 1) {
                            List<Books> resultPrice = books.stream()
                                    .filter(bookp -> bookp.getPrice() > 0)
                                    .collect(Collectors.toList());

                            System.out.println("Do you want to see the exact genre of the books? (yes/no)");
                            String choiceFilterGenre = scan.nextLine();
                            choiceFilterGenre = scan.nextLine();

                            switch (choiceFilterGenre) {
                                case "yes": {
                                    System.out.println("Choose the genre (Write the number (1 - 3)): \n1. Art \n2. Programming \n3. Psychology");
                                    int choiceGenre = scan.nextInt();

                                    // Art
                                    if (choiceGenre == 1) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Art)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Programming
                                    else if (choiceGenre == 2) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Programming)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Psychology
                                    else if (choiceGenre == 3) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Psychology)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // if we don't choose from 1 to 3
                                    else
                                        System.out.println("Please, choose from the given options (1 - 3)!");
                                    break;
                                }

                                // if we don't need any genre filters
                                case "no": {
                                    System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                    resultPrice.forEach(bookp -> System.out.println(bookp));
                                    int choiceBookId = scan.nextInt();

                                    try {
                                        for (Books i : resultPrice) {
                                            if (i.getId() == choiceBookId) {
                                                System.out.println(books.get(choiceBookId - 1));
                                                Altan.buy(choiceBookId);
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found)
                                            System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                        else
                                            throw new OutOfListException();
                                    }
                                    catch (OutOfListException e) {
                                        System.out.println(e);
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println("Please, choose from the given options (yes/no)!");
                                }
                            }
                        }

                        // 2nd price segment----------------------------------------------------------------------------
                        else if (choicePrice == 2) {
                            List<Books> resultPrice = books.stream()
                                    .filter(bookp -> bookp.getPrice() > 0 && bookp.getPrice() < 2000)
                                    .collect(Collectors.toList());

                            System.out.println("Do you want to see the exact genre of the books? (yes/no)");
                            String choiceFilterGenre = scan.nextLine();
                            choiceFilterGenre = scan.nextLine();

                            switch (choiceFilterGenre) {
                                case "yes": {
                                    System.out.println("Choose the genre (Write the number (1 - 3)): \n1. Art \n2. Programming \n3. Psychology");
                                    int choiceGenre = scan.nextInt();

                                    // Art
                                    if (choiceGenre == 1) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Art)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Programming
                                    else if (choiceGenre == 2) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Programming)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Psychology
                                    else if (choiceGenre == 3) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Psychology)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // if we don't choose from 1 to 3
                                    else
                                        System.out.println("Please, choose from the given options (1 - 3)!");
                                    break;
                                }

                                // if we don't need any genre filters
                                case "no": {
                                    System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                    resultPrice.forEach(book -> System.out.println(book));
                                    int choiceBookId = scan.nextInt();

                                    try {
                                        for (Books i : resultPrice) {
                                            if (i.getId() == choiceBookId) {
                                                System.out.println(books.get(choiceBookId - 1));
                                                Altan.buy(choiceBookId);
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found)
                                            System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                        else
                                            throw new OutOfListException();
                                    }
                                    catch (OutOfListException e) {
                                        System.out.println(e);
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println("Please, choose from the given options (yes/no)!");
                                }
                            }
                        }

                        // 3rd price segment----------------------------------------------------------------------------
                        else if (choicePrice == 3) {
                            List<Books> resultPrice = books.stream()
                                    .filter(book -> book.getPrice() > 2000)
                                    .collect(Collectors.toList());

                            System.out.println("Do you want to see the exact genre of the books? (yes/no)");
                            String choiceFilterGenre = scan.nextLine();
                            choiceFilterGenre = scan.nextLine();

                            switch (choiceFilterGenre) {
                                case "yes": {
                                    System.out.println("Choose the genre (Write the number (1 - 3)): \n1. Art \n2. Programming \n3. Psychology");
                                    int choiceGenre = scan.nextInt();

                                    // Art
                                    if (choiceGenre == 1) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Art)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Programming
                                    else if (choiceGenre == 2) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Programming)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Psychology
                                    else if (choiceGenre == 3) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Psychology)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // if we don't choose from 1 to 3
                                    else
                                        System.out.println("Please, choose from the given options (1 - 3)!");
                                    break;
                                }

                                // if we don't need any genre filters
                                case "no": {
                                    System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                    resultPrice.forEach(book -> System.out.println(book));
                                    int choiceBookId = scan.nextInt();

                                    try {
                                        for (Books i : resultPrice) {
                                            if (i.getId() == choiceBookId) {
                                                System.out.println(books.get(choiceBookId - 1));
                                                Altan.buy(choiceBookId);
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found)
                                            System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                        else
                                            throw new OutOfListException();
                                    }
                                    catch (OutOfListException e) {
                                        System.out.println(e);
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println("Please, choose from the given options (yes/no)!");
                                }
                            }
                        }

                        // 4th price segment----------------------------------------------------------------------------
                        else if (choicePrice == 4) {
                            List<Books> resultPrice = books.stream()
                                    .filter(book -> book.getPrice() > 2000 && book.getPrice() < 4000)
                                    .collect(Collectors.toList());

                            System.out.println("Do you want to see the exact genre of the books? (yes/no)");
                            String choiceFilterGenre = scan.nextLine();
                            choiceFilterGenre = scan.nextLine();

                            switch (choiceFilterGenre) {
                                case "yes": {
                                    System.out.println("Choose the genre (Write the number (1 - 3)): \n1. Art \n2. Programming \n3. Psychology");
                                    int choiceGenre = scan.nextInt();

                                    // Art
                                    if (choiceGenre == 1) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Art)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Programming
                                    else if (choiceGenre == 2) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Programming)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Psychology
                                    else if (choiceGenre == 3) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Psychology)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // if we don't choose from 1 to 3
                                    else
                                        System.out.println("Please, choose from the given options (1 - 3)!");
                                    break;
                                }

                                // if we don't need any genre filters
                                case "no": {
                                    System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                    resultPrice.forEach(book -> System.out.println(book));
                                    int choiceBookId = scan.nextInt();

                                    try {
                                        for (Books i : resultPrice) {
                                            if (i.getId() == choiceBookId) {
                                                System.out.println(books.get(choiceBookId - 1));
                                                Altan.buy(choiceBookId);
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found)
                                            System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                        else
                                            throw new OutOfListException();
                                    }
                                    catch (OutOfListException e) {
                                        System.out.println(e);
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println("Please, choose from the given options (yes/no)!");
                                }
                            }
                        }

                        // 5th price segment----------------------------------------------------------------------------
                        else if (choicePrice == 5) {
                            List<Books> resultPrice = books.stream()
                                    .filter(book -> book.getPrice() > 4000)
                                    .collect(Collectors.toList());

                            System.out.println("Do you want to see the exact genre of the books? (yes/no)");
                            String choiceFilterGenre = scan.nextLine();
                            choiceFilterGenre = scan.nextLine();

                            switch (choiceFilterGenre) {
                                case "yes": {
                                    System.out.println("Choose the genre (Write the number (1 - 3)): \n1. Art \n2. Programming \n3. Psychology");
                                    int choiceGenre = scan.nextInt();

                                    // Art
                                    if (choiceGenre == 1) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Art)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Programming
                                    else if (choiceGenre == 2) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Programming)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Psychology
                                    else if (choiceGenre == 3) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Psychology)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // if we don't choose from 1 to 3
                                    else
                                        System.out.println("Please, choose from the given options (1 - 3)!");
                                    break;
                                }

                                // if we don't need any genre filters
                                case "no": {
                                    System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                    resultPrice.forEach(book -> System.out.println(book));
                                    int choiceBookId = scan.nextInt();

                                    try {
                                        for (Books i : resultPrice) {
                                            if (i.getId() == choiceBookId) {
                                                System.out.println(books.get(choiceBookId - 1));
                                                Altan.buy(choiceBookId);
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found)
                                            System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                        else
                                            throw new OutOfListException();
                                    }
                                    catch (OutOfListException e) {
                                        System.out.println(e);
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println("Please, choose from the given options (yes/no)!");
                                }
                            }
                        }

                        // 6th price segment----------------------------------------------------------------------------
                        else if (choicePrice == 6) {
                            List<Books> resultPrice = books.stream()
                                    .filter(book -> book.getPrice() > 4000 && book.getPrice() < 6000)
                                    .collect(Collectors.toList());

                            System.out.println("Do you want to see the exact genre of the books? (yes/no)");
                            String choiceFilterGenre = scan.nextLine();
                            choiceFilterGenre = scan.nextLine();

                            switch (choiceFilterGenre) {
                                case "yes": {
                                    System.out.println("Choose the genre (Write the number (1 - 3)): \n1. Art \n2. Programming \n3. Psychology");
                                    int choiceGenre = scan.nextInt();

                                    // Art
                                    if (choiceGenre == 1) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Art)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Programming
                                    else if (choiceGenre == 2) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Programming)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Psychology
                                    else if (choiceGenre == 3) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Psychology)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // if we don't choose from 1 to 3
                                    else
                                        System.out.println("Please, choose from the given options (1 - 3)!");
                                    break;
                                }

                                // if we don't need any genre filters
                                case "no": {
                                    System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                    resultPrice.forEach(book -> System.out.println(book));
                                    int choiceBookId = scan.nextInt();

                                    try {
                                        for (Books i : resultPrice) {
                                            if (i.getId() == choiceBookId) {
                                                System.out.println(books.get(choiceBookId - 1));
                                                Altan.buy(choiceBookId);
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found)
                                            System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                        else
                                            throw new OutOfListException();
                                    }
                                    catch (OutOfListException e) {
                                        System.out.println(e);
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println("Please, choose from the given options (yes/no)!");
                                }
                            }
                        }

                        // 7th price segment----------------------------------------------------------------------------
                        else if (choicePrice == 7) {
                            List<Books> resultPrice = books.stream()
                                    .filter(book -> book.getPrice() > 6000)
                                    .collect(Collectors.toList());

                            System.out.println("Do you want to see the exact genre of the books? (yes/no)");
                            String choiceFilterGenre = scan.nextLine();
                            choiceFilterGenre = scan.nextLine();

                            switch (choiceFilterGenre) {
                                case "yes": {
                                    System.out.println("Choose the genre (Write the number (1 - 3)): \n1. Art \n2. Programming \n3. Psychology");
                                    int choiceGenre = scan.nextInt();

                                    // Art
                                    if (choiceGenre == 1) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Art)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Programming
                                    else if (choiceGenre == 2) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Programming)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // Psychology
                                    else if (choiceGenre == 3) {
                                        List<Books> resultGenre = resultPrice.stream()
                                                .filter(bookg -> bookg.getGenre() == BookGenre.Psychology)
                                                .collect(Collectors.toList());
                                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                        resultGenre.forEach(bookg -> System.out.println(bookg));
                                        int choiceBookId = scan.nextInt();

                                        try {
                                            for (Books i : resultGenre) {
                                                if (i.getId() == choiceBookId) {
                                                    System.out.println(books.get(choiceBookId - 1));
                                                    Altan.buy(choiceBookId);
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                            else
                                                throw new OutOfListException();
                                        }
                                        catch (OutOfListException e) {
                                            System.out.println(e);
                                        }
                                    }

                                    // if we don't choose from 1 to 3
                                    else
                                        System.out.println("Please, choose from the given options (1 - 3)!");
                                    break;
                                }

                                // if we don't need any genre filters
                                case "no": {
                                    System.out.println("Please, choose one of these books! Write one of the book id.\n");
                                    resultPrice.forEach(book -> System.out.println(book));
                                    int choiceBookId = scan.nextInt();

                                    try {
                                        for (Books i : resultPrice) {
                                            if (i.getId() == choiceBookId) {
                                                System.out.println(books.get(choiceBookId - 1));
                                                Altan.buy(choiceBookId);
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (found)
                                            System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                                        else
                                            throw new OutOfListException();
                                    }
                                    catch (OutOfListException e) {
                                        System.out.println(e);
                                    }
                                    break;
                                }
                                default: {
                                    System.out.println("Please, choose from the given options (yes/no)!");
                                }
                            }
                        } else {
                            System.out.println("Please, choose from the given numbers ( 1 - 4 )!");
                        }
                        break;
                    }

                    // choice about not adding filter
                    case "no": {
                        System.out.println("Please, choose one of these books! Write one of the book id.\n");
                        for (Books i : books) {
                            System.out.println(i);
                        }
                        int choiceBookId = scan.nextInt();

                        try {
                            for (Books i : books) {
                                if (i.getId() == choiceBookId) {
                                    System.out.println(books.get(choiceBookId - 1));
                                    Altan.buy(choiceBookId);
                                    found = true;
                                    break;
                                }
                            }
                            if (found)
                                System.out.println("You bought this book. Now you have " + Altan.getWallet() + " HUF.");
                            else
                                throw new OutOfListException();
                        }
                        catch (OutOfListException e) {
                            System.out.println(e);
                        }

                        break;
                    }

                    // in case, if we choose neither yes nor no
                    default: {
                        System.out.println("Please, choose from the given options (yes/no)!");
                    }
                }
                break;
            }

            // if we choose selling the book that we have-----------------------------------------------------------------------
            case "sell": {

                // if the costumer has a book
                if (Altan.getHasBook()) {
                    System.out.println("You have a book: ");
                    System.out.println(books.get(Altan.getBookId()));
                    System.out.println("Would you like to sell it? (yes/no)");
                    String choice22 = scan.nextLine();
                    switch (choice22) {
                        case "yes": {
                            Altan.sell(Altan.getBookId());
                            System.out.println("Sir, you sold your book. Now you have " + Altan.getWallet() + " HUF.");
                            break;
                        }
                        case "no": {
                            System.out.println("Okay, sir, as you wish!");
                            break;
                        }
                        default: {
                            System.out.println("Please, choose from the given options (yes/no)!");
                        }
                    }
                }

                // if the customer doesn't have a book
                else
                    System.out.println("Sorry, sir. You don't have any book.");
                break;
            }

            // in case, if we choose neither buy nor sell-----------------------------------------------------------------------
            default: {
                System.out.println("Please, choose from the given options (buy/sell)!");
            }
        }
    }

    public static class OutOfListException extends Exception {
       public String toString(){
           return "Sir, please choose from the given books.";
       }
    }
}