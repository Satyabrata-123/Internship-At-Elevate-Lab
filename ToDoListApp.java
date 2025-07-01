
import javax.swing.*;
import java.awt.*;

public class ToDoListApp extends JFrame {

    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInputField;
    private JButton addTaskButton;
    private JButton deleteTaskButton;

    public ToDoListApp() {
        setTitle("To-Do List App");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); 
        setLayout(new BorderLayout(10, 10)); 

        // Top panel for task input
        JPanel inputPanel = new JPanel(new BorderLayout(5, 5));
        taskInputField = new JTextField();
        addTaskButton = new JButton("Add Task");

        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addTaskButton, BorderLayout.EAST);
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        // Middle panel for the task list
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        JScrollPane taskScrollPane = new JScrollPane(taskList);
        taskScrollPane.setBorder(BorderFactory.createTitledBorder("Your Tasks"));

        // Bottom panel for delete button
        JPanel bottomPanel = new JPanel();
        deleteTaskButton = new JButton("Delete Selected Task");
        bottomPanel.add(deleteTaskButton);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

        // Add components to the frame
        add(inputPanel, BorderLayout.NORTH);
        add(taskScrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add functionality to buttons
        addTaskButton.addActionListener(_ -> addTask());
        deleteTaskButton.addActionListener(_ -> deleteTask());

        // Enter key also adds task
        taskInputField.addActionListener(_ -> addTask());

        setVisible(true);
    }

    private void addTask() {
        String task = taskInputField.getText().trim();
        if (!task.isEmpty()) {
            taskListModel.addElement(task);
            taskInputField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a task.");
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            taskListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoListApp::new);
    }
}