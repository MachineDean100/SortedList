import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SortedListApp extends JFrame implements ActionListener {
    private SortedList sortedList;

    private JTextField inputField;
    private JButton addButton;

    private JTextField searchField;
    private JButton searchButton;

    private JTextArea displayArea;

    public SortedListApp() {
        sortedList = new SortedList();

        setTitle("SortedList Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);


        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputField = new JTextField(15);
        addButton = new JButton("Add");

        inputPanel.add(new JLabel("Enter String to Add:"));
        inputPanel.add(inputField);
        inputPanel.add(addButton);

        addButton.addActionListener(this);

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        searchField = new JTextField(15);
        searchButton = new JButton("Search");

        searchPanel.add(new JLabel("Enter String to Search:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        searchButton.addActionListener(this);

        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(searchPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String value = inputField.getText().trim();
            if (!value.isEmpty()) {
                sortedList.add(value);
                displayArea.append("Added: " + value + "\n");
                displayArea.append("Current List: " + sortedList.toString() + "\n\n");
                inputField.setText("");
            }
        } else if (e.getSource() == searchButton) {
            String value = searchField.getText().trim();
            if (!value.isEmpty()) {
                int index = sortedList.search(value);
                if (index >= 0) {
                    displayArea.append("Found \"" + value + "\" at index: " + index + "\n");
                } else {
                    int insertPos = -(index + 1);
                    displayArea.append("\"" + value + "\" not found. It would be at index: " + insertPos + "\n");
                }
                displayArea.append("\n");
                searchField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SortedListApp();
        });
    }
}
