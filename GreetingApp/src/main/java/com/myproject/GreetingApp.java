
package com.myproject;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GreetingApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Greeting App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GreetingPanel greetingPanel = new GreetingPanel();
            frame.getContentPane().add(greetingPanel);

            frame.setSize(300, 150);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

class GreetingPanel extends JPanel {

    private JTextField nameTextField;
    private JLabel greetingLabel;

    public GreetingPanel() {
        setLayout(new BorderLayout());

        
        setBackground(new Color(255, 255, 224));

       
        setBorder(new LineBorder(Color.black, 2)); 

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false); 
        inputPanel.add(new JLabel("Enter Your Name: "));
        nameTextField = new JTextField(15);
        inputPanel.add(nameTextField);

        // Button Panel
        JButton greetButton = new JButton("Greet");
        greetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                greet();
            }
        });

        //  the layout manager for the button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false); // Make the panel transparent
        buttonPanel.add(greetButton);

        // Greeting Label
        greetingLabel = new JLabel("Greeting will appear here.");
        greetingLabel.setForeground(Color.BLACK); // Set text color to black

        //  separate panel for the greeting label with a different background color
        JPanel greetingLabelPanel = new JPanel(new BorderLayout());
        greetingLabelPanel.setBackground(Color.pink); 
        greetingLabelPanel.add(greetingLabel, BorderLayout.CENTER);

        // Adding Components to Main Panel
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(greetingLabelPanel, BorderLayout.SOUTH); 
    }

    private void greet() {
        String name = nameTextField.getText().trim();
        if (!name.isEmpty()) {
            greetingLabel.setText("Hello, " + name + "!");
        } else {
            greetingLabel.setText("Please enter your name.");
        }
    }
}
