
import javax.swing.*;
import java.awt.*;

// Main class
public class DrawableTestGUI {

    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Shape Area Calculator");
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for input
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        // Input label and field
        JLabel inputLabel = new JLabel("Enter shapes (e.g., Size Shape Radius or Side):");
        JTextField inputField = new JTextField();
        panel.add(inputLabel);
        panel.add(inputField);

        // Submit button
        JButton submitButton = new JButton("Calculate Total Area");
        panel.add(submitButton);

        // Result display
        JLabel resultLabel = new JLabel("Result: ", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setForeground(Color.BLUE);

        // Add components to the frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(resultLabel, BorderLayout.SOUTH);

        // Action listener for the button
        submitButton.addActionListener(e -> {
            String input = inputField.getText();
            try {
                String[] inputArgs = input.split(" ");

                // Validate size input
                int size = Integer.parseInt(inputArgs[0]);
                if (size < 2) {
                    resultLabel.setText("Error: Minimum size is 2. Please try again.");
                    return;
                }

                // Create drawable objects
                Drawable[] drawableObjects = new Drawable[size];
                int argIndex = 1;

                for (int i = 0; i < size; i++) {
                    if (argIndex >= inputArgs.length) {
                        resultLabel.setText("Error: Insufficient input arguments.");
                        return;
                    }

                    String shape = inputArgs[argIndex++];
                    switch (shape.toLowerCase()) {
                        case "circle":
                            double radius = Double.parseDouble(inputArgs[argIndex++]);
                            if (radius <= 0) {
                                resultLabel.setText("Error: Circle radius must be positive.");
                                return;
                            }
                            drawableObjects[i] = new Circle(radius);
                            break;

                        case "cube":
                            double side = Double.parseDouble(inputArgs[argIndex++]);
                            if (side <= 0) {
                                resultLabel.setText("Error: Cube side must be positive.");
                                return;
                            }
                            drawableObjects[i] = new Cube(side);
                            break;

                        default:
                            resultLabel.setText("Error: Unsupported shape type: " + shape);
                            return;
                    }
                }
                double totalArea = 0;
                for (Drawable drawable : drawableObjects) {
                    if (drawable instanceof Circle circle) {
                        totalArea += circle.getArea();
                    } else if (drawable instanceof Cube cube) {
                        totalArea += cube.getArea();
                    }
                }

                resultLabel.setText("Total Area: " + (totalArea));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: Invalid number format. Please check your input.");
            } catch (Exception ex) {
                resultLabel.setText("Error: Invalid input format. Please follow the example.");
            }
        });

        // Show the frame
        frame.setVisible(true);
    }
}
