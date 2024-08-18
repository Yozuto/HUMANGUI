import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ZooGUI extends JFrame {

    private JPanel buttonPanel;
    private JTextArea outputArea;

    private List<Animal> animals;

    public ZooGUI() {
        setTitle("Zoo Management System");
        setSize(600, 500);  // Increased frame size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        getContentPane().setBackground(Color.PINK);

        animals = new ArrayList<>();
        initializeAnimals();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(animals.size(), 1));
        buttonPanel.setOpaque(false); 

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

        add(buttonPanel, BorderLayout.WEST);

        outputArea = new JTextArea(10, 40);  // Adjusted size
        outputArea.setFont(new Font("Arial", Font.PLAIN, 14));  // More readable text
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setOpaque(true);
        outputArea.setBackground(Color.LIGHT_GRAY);  // Set background for better readability

        add(outputArea, BorderLayout.CENTER);

        setVisible(true);
    }

    private void initializeAnimals() {
        animals.add(new Animal("Lion", "Lion", "Roar", 5));
        animals.add(new Animal("Elephant", "Elephant", "Trumpet", 10));
        animals.add(new Animal("Dog", "Dog", "Bark", 3));
        animals.add(new Animal("Cat", "Cat", "Meow", 2));
    }

    public static void main(String[] args) {
        new ZooGUI();
    }
}
