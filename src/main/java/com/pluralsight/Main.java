package com.pluralsight;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static void main() {
        Book[] books = new Book[10];

            books[0] = new Book(0, "978-0451524935", "1984", false, "");
            books[1] = new Book(1, "978-0140449136", "The Odyssey", false, "");
            books[2] = new Book(2, "978-0439139601", "Harry Potter and the Goblet of Fire", false, "");
            books[3] = new Book(3, "978-0061120084", "To Kill a Mockingbird", false, "");
            books[4] = new Book(4, "978-0307277671", "The Road", false, "");
            books[5] = new Book(5, "978-0743273565", "The Great Gatsby", false, "");
            books[6] = new Book(6, "978-1501128035", "It", false, "");
            books[7] = new Book(7, "978-0553386790", "A Game of Thrones", true, "");
            books[8] = new Book(8, "978-0060850524", "Brave New World", false, "");
            books[9] = new Book(9, "978-1594633669", "The Kite Runner", true, "");

            boolean keepGoing = true;
            do {
                String mainPrompt = """
                        =======MAIN MENU=======
                        1. Show available books
                        2. Show checked out books
                        3. Exit this application
                        =======================
                        
                        Please enter you selection.
                        """;

                System.out.println(mainPrompt);
                String userSelection = scanner.nextLine();

                switch (userSelection) {
                    case "1":
                        //available book menu
                        showAvailableMenu(books);
                        break;
                    case "2":
                        //checked out books menu
                        showCheckedOutMenu(books);
                        break;
                    case "3":
                        //exit
                        keepGoing = false;
                        break;
                    default:
                        System.err.println("Invalid Selection");
                }
            } while (keepGoing);
    }

    public static void showAvailableMenu(Book[] books){
        System.out.println("========Available books===========");
        System.out.println("ID\tISBN\t\tTitle");
        for (Book currentBook : books) {
            if (!currentBook.isCheckedOut) {
                System.out.print(currentBook.id + " ");
                System.out.print(currentBook.isbn + " ");
                System.out.println(currentBook.title);
            }
        }
        String prompt = """
            1. Check out a book
            2. Exit to menu
            """;
        System.out.println(" ");
        System.out.println(prompt);
        String userSelection = scanner.nextLine();

        switch (userSelection) {
            case "1":
                //check out book
                System.out.println("Enter the book ID number of the book you want to check out: ");
                userSelection = scanner.nextLine();
                int id = Integer.parseInt(userSelection);

                System.out.println("Enter your name: ");
                String name = scanner.nextLine();

                books[id].isCheckedOut = true;
                books[id].checkedOUtTo = name;


                break;
            case "2":
                //exit
                break;
            default:
                System.err.println("Invalid Selection");

        }
    }

    public static void showCheckedOutMenu(Book[] books){
        System.out.println("========Available books===========");
        System.out.println("ID\tISBN\t\tTitle");
        for (Book currentBook : books) {
            if (currentBook.isCheckedOut) {
                System.out.print(currentBook.id + " ");
                System.out.print(currentBook.isbn + " ");
                System.out.print(currentBook.title);
                System.out.println(currentBook.checkedOUtTo);
            }
        }
        String prompt = """
            1. Check in a book
            2. Exit to menu
            """;
        System.out.println(" ");
        System.out.println(prompt);
        String userSelection = scanner.nextLine();

        switch (userSelection) {
            case "1":
                //check out book
                System.out.println("Enter the book ID number of the book you want to check in: ");
                userSelection = scanner.nextLine();
                int id = Integer.parseInt(userSelection);

                books[id].isCheckedOut = false;
                books[id].checkedOUtTo = "";

                break;
            case "2":
                //exit
                break;
            default:
                System.err.println("Invalid Selection");

        }
    }

}

