#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

class Book {
public:
    string id;
    string title;
    string author;
    bool isIssued;

    Book(string id, string title, string author) : id(id), title(title), author(author), isIssued(false) {}
};

class Library {
private:
    vector<Book> books;

public:
    void addBook(string id, string title, string author) {
        books.push_back(Book(id, title, author));
        cout << "Book added successfully." << endl;
    }

    void issueBook(string id) {
        for (auto &book : books) {
            if (book.id == id && !book.isIssued) {
                book.isIssued = true;
                cout << "Book issued successfully." << endl;
                return;
            }
        }
        cout << "Book not found or already issued." << endl;
    }

    void returnBook(string id) {
        for (auto &book : books) {
            if (book.id == id && book.isIssued) {
                book.isIssued = false;
                cout << "Book returned successfully." << endl;
                return;
            }
        }
        cout << "Book not found or not issued." << endl;
    }

    void displayBooks() {
        for (const auto &book : books) {
            cout << "ID: " << book.id << ", Title: " << book.title << ", Author: " << book.author << ", Issued: " << (book.isIssued ? "Yes" : "No") << endl;
        }
    }
};

int main() {
    Library library;
    int choice;
    string id, title, author;

    while (true) {
        cout << "\nLibrary Management System\n";
        cout << "1. Add Book\n";
        cout << "2. Issue Book\n";
        cout << "3. Return Book\n";
        cout << "4. Display Books\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1:
                cout << "Enter book ID: ";
                cin >> id;
                cout << "Enter book title: ";
                cin.ignore();
                getline(cin, title);
                cout << "Enter book author: ";
                getline(cin, author);
                library.addBook(id, title, author);
                break;
            case 2:
                cout << "Enter book ID to issue: ";
                cin >> id;
                library.issueBook(id);
                break;
            case 3:
                cout << "Enter book ID to return: ";
                cin >> id;
                library.returnBook(id);
                break;
            case 4:
                library.displayBooks();
                break;
            case 5:
                return 0;
            default:
                cout << "Invalid choice. Please try again." << endl;
        }
    }

    return 0;
}