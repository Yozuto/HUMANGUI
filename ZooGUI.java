import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ZooGUI extends JFrame {

    private JPanel buttonPanel;
    private JTextArea outputArea;

    // List to store animals
    private List<Animal> animals;

    public ZooGUI() {
        setTitle("Zoo Management System");
        setSize(600, 500);  // Increased frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Set background color to pink
        getContentPane().setBackground(Color.PINK);

        // Initialize animal list
        animals = new ArrayList<>();
        initializeAnimals();

        // Panel for buttons
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(animals.size(), 1));
        buttonPanel.setOpaque(false);  // Keep the pink background

        // Create buttons for each animal
        for (Animal animal : animals) {
            JButton animalButton = new JButton(animal.name);
            animalButton.setFont(new Font("Arial", Font.BOLD, 14));
            animalButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    outputArea.setText(animal.getInfo() + "\n\n" + animal.makeSound());
                }
            });
            buttonPanel.add(animalButton);
        }

        // Add button panel to the top of the frame
        add(buttonPanel, BorderLayout.WEST);

        // Output Area
        outputArea = new JTextArea(10, 40);  // Adjusted size
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14));  // More readable text
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setOpaque(true);
        outputArea.setBackground(Color.LIGHT_GRAY);  // Set background for better readability

        // Add output area to the center of the frame
        add(outputArea, BorderLayout.CENTER);

        setVisible(true);
    }

    private void initializeAnimals() {
        // Create and add animals to the list
        animals.add(new Animal("Lion", "Lion", "Roar", 5));
        animals.add(new Animal("Elephant", "Elephant", "Trumpet", 10));
        animals.add(new Animal("Dog", "Dog", "Bark", 3));
        animals.add(new Animal("Cat", "Cat", "Meow", 2));
        // Add more animals as needed
    }

    public static void main(String[] args) {
        new ZooGUI();
    }
}
