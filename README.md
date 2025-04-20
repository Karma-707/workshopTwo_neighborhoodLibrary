# 📚🐾Stray Dogs Library

Welcome to **Stray Dogs Library**, a simple library management system written in Java. This project simulates the checking in and out of books at a library. Users can browse available books, check out books, and return them when done. The system manages book availability and records the person who has checked out each book.

# 🧠 Features
* 📖 Display a list of available books.
* 🆔 Check out books using their ID.
* 👤 View a list of checked-out books and the person who checked them out.
* 🔁 Return books to make them available for others to check out.

# 📸 Screenshot of Outputs

## 🖥️ Home Screen
* 👋 **Welcome Greeting**
* 🟢 **Press 1**: Show available books.
* 🔵 **Press 2**: Show checked-out books.
* 🔴 **Press 0**: Exit the application.

![Home Page](/images/homeScreen.png)

## 📘Book Checkout
🏷️Before checking out
* 📋Display all the books available to check out
  * Including ID, ISBN, Title, and Author of book

![Sample Book List](/images/sampleBookList.png)

🧾Checkout Flow:
* ✍️ The user is prompted to enter their name and the ID of the book they wish to check out.
* ✅ System will confirm if the book is available.
* 🔓 If available, it will be checked out to the user.
* 🔄 The user is prompted to choose the next step to check out another book or go back to home screen

![Check Out Books](/images/checkOut.png)

## 📙Book Return
🏷️Before checking in/return
* 📦Display all the books checked out.
  * Including ID, ISBN, Title, Author, and person who checked out the book.

![Check In Books](/images/checkIn.png)

🔁Check-in/Return flow:
* 🔎The user is prompted to enter the ID of the book they wish to return.
* 📤System will confirm if the book was checked out.
* ✅If checked out, the book is marked available again for check out (after return).

![Return Book](/images/returnBook.png)

# ⚠️ Error Handling
### 🔴 If the user enters an invalid command (e.g., letters instead of numbers or vice versa when applicable), the program will display an error message and prompt them to try again.
![Error Handling](/images/errorHandling.png)

# 🧩 Fun Fact
### 🐢The first display is slowed down so user can see full catalog
### ⚡Later screen are faster to avoid tedious time and efficient

# 🧑‍💻 Author
💻 Developed by: Meixin Zhang
📅 Date: April 20th, 2025

Created with ❤️ using Java.