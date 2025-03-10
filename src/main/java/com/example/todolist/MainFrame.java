package com.example.todolist;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Main window (GUI) of the app. Extends JFrame to show tasks and handle user actions.
 */
public class MainFrame extends JFrame {

    private final TaskDAO taskDAO;            // For database operations
    private final JTextField titleField;
    private final JTextField descriptionField;
    private final JTable taskTable;
    private final DefaultTableModel tableModel;

    public MainFrame() {
        super("To-Do List");                 // Set window title

        taskDAO = new TaskDAO();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);         // Center on screen

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Title:"));
        titleField = new JTextField(10);
        topPanel.add(titleField);

        topPanel.add(new JLabel("Description:"));
        descriptionField = new JTextField(10);
        topPanel.add(descriptionField);

        JButton addButton = new JButton("Add");
        topPanel.add(addButton);

        JButton deleteButton = new JButton("Delete");
        topPanel.add(deleteButton);

        // Columns: ID, Title, Description
        tableModel = new DefaultTableModel(new Object[]{"ID", "Title", "Description"}, 0);
        taskTable = new JTable(tableModel);

        refreshTaskTable();  // Load tasks on startup

        // When "Add" is clicked, add a new task to DB
        addButton.addActionListener((ActionEvent e) -> {
            String title = titleField.getText().trim();
            String description = descriptionField.getText().trim();

            if (!title.isEmpty()) {
                taskDAO.addTask(new Task(title, description));
                refreshTaskTable();
                titleField.setText("");
                descriptionField.setText("");
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Enter at least Title",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        // When "Delete" is clicked, delete the selected row in DB
        deleteButton.addActionListener((ActionEvent e) -> {
            int selectedRow = taskTable.getSelectedRow();
            if (selectedRow >= 0) {
                int taskId = (int) tableModel.getValueAt(selectedRow, 0);
                taskDAO.deleteTask(taskId);
                refreshTaskTable();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Select a row to delete",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE
                );
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(taskTable), BorderLayout.CENTER);

        add(mainPanel);
    }

    /**
     * Updates the table model with the latest tasks from the database.
     */
    private void refreshTaskTable() {
        tableModel.setRowCount(0); // Clear rows
        List<Task> tasks = taskDAO.getAllTasks();
        for (Task t : tasks) {
            tableModel.addRow(new Object[]{t.getId(), t.getTitle(), t.getDescription()});
        }
    }
}
