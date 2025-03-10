package com.example.todolist;

import javax.swing.SwingUtilities;

/**
 * The entry point of the application.
 */
public class Main {
    public static void main(String[] args) {
        // Create the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
