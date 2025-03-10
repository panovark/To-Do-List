# To-Do List (Java + SQLite)

## Overview
This is a small Java application that provides a simple To-Do List with a Swing-based GUI and a local SQLite database for data storage. You can **add** new tasks (title + description) and **delete** existing ones, with all operations saved in `tasks.db`.

## Main Components
- **Main.java**  
  Entry point of the application. Starts the Swing interface (`MainFrame`).
- **MainFrame.java**  
  The main window that allows you to add and remove tasks. Displays tasks in a table.
- **Task.java**  
  Represents a single Task, containing an `id`, `title`, and `description`.
- **TaskDAO.java**  
  Handles Create, Read, and Delete (CRUD) operations on the SQLite database.
- **DatabaseManager.java**  
  Manages the database connection and creates the `tasks` table if it doesn’t exist.

## Features
- **Swing GUI** for adding and deleting tasks.  
- **SQLite integration** with automatic table creation (`tasks.db`).  
- Simple table display of existing tasks.  
- Data persists across sessions.

## How to Run
1. **Clone** the repository and open it in your preferred Java IDE (e.g., IntelliJ, Eclipse).
2. **Check** that you have SQLite JDBC on your classpath (some JDKs include it by default).
3. **Compile** the project.  
4. **Run** the `Main` class. You should see the main window.
