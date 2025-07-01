import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class ToDoApp {
    private JFrame frame;
    private JTextField taskField;
    private JButton addButton, deleteButton;
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;

    public ToDoApp() {
        // Frame
        frame = new JFrame("To-Do List");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Top panel for input
        JPanel topPanel = new JPanel();
        taskField = new JTextField(20);
        addButton = new JButton("Add Task");
        topPanel.add(taskField);
        topPanel.add(addButton);

        // Center list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);

        // Bottom panel for delete
        JPanel bottomPanel = new JPanel();
        deleteButton = new JButton("Delete Selected");
        bottomPanel.add(deleteButton);

        // Add panels to frame
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Add button action
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String task = taskField.getText().trim();
                if (!task.isEmpty()) {
                    taskListModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        // Delete button action
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = taskList.getSelectedIndex();
                if (selectedIndex != -1) {
                    taskListModel.remove(selectedIndex);
                }
            }
        });

        // Show frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ToDoApp();
    }
}
