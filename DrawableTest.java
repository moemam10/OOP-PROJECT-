
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DrawableTest {

    public static void main(String[] args) {
        // Validate the number of arguments
        if (args.length < 1) {
            System.out.println("Error: Please provide the size of the Drawable array and its details.");
            return;
        }

        // Parse the size of the Drawable array
        if (Integer.parseInt(args[0]) < 2) {
            System.out.println("Error: The size of the Drawable array must be a numeric value of at least 2.");
            return;
        }

        int size = Integer.parseInt(args[0]);
        if (args.length < (1 + size * 2)) {
            System.out.println("Error: Insufficient arguments for the specified number of shapes.");
            return;
        }

        // Create the Drawable array
        Drawable[] drawableObjects = new Drawable[size];
        int argIndex = 1;

        for (int i = 0; i < size; i++) {
            if (argIndex >= args.length) {
                System.out.println("Error: Not enough arguments provided for shape definitions.");
                return;
            }

            String shape = args[argIndex++];
            switch (shape.toLowerCase()) {
                case "circle":
                    if (argIndex >= args.length) {
                        System.out.println("Error: Invalid or missing radius value for circle.");
                        return;
                    }
                    double radius = Double.parseDouble(args[argIndex++]);
                    if (radius <= 0) {
                        System.out.println("Error: Radius must be a positive number.");
                        return;
                    }
                    drawableObjects[i] = new Circle(radius);
                    break;

                case "cube":
                    if (argIndex >= args.length) {
                        System.out.println("Error: Invalid or missing side length value for cube.");
                        return;
                    }
                    double side = Double.parseDouble(args[argIndex++]);
                    if (side <= 0) {
                        System.out.println("Error: Side length must be a positive number.");
                        return;
                    }
                    drawableObjects[i] = new Cube(side);
                    break;

                default:
                    System.out.println("Error: Unsupported shape type: " + shape);
                    return;
            }
        }
        
        
        double totalArea = 0;
        for (Drawable drawable : drawableObjects) {
            if (drawable instanceof Circle circle) {
                totalArea += circle.getArea();
                System.out.println(circle.getName());
            } else if (drawable instanceof Cube cube) {
                totalArea += cube.getArea();
                System.out.println(cube.getName());
            }
        }

        System.out.println("The Total Area Is: " + totalArea);
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
                int Size = Integer.parseInt(inputArgs[0]);
                if (Size < 2) {
                    resultLabel.setText("Error: Minimum size is 2. Please try again.");
                    return;
                }

                // Create drawable objects
                Drawable[] drawableObject = new Drawable[size];
                int ArgIndex = 1;

                for (int i = 0; i < size; i++) {
                    if (ArgIndex >= inputArgs.length) {
                        resultLabel.setText("Error: Insufficient input arguments.");
                        return;
                    }

                    String shape = inputArgs[ArgIndex++];
                    switch (shape.toLowerCase()) {
                        case "circle":
                            double radius = Double.parseDouble(inputArgs[ArgIndex++]);
                            if (radius <= 0) {
                                resultLabel.setText("Error: Circle radius must be positive.");
                                return;
                            }
                            drawableObjects[i] = new Circle(radius);
                            break;

                        case "cube":
                            double side = Double.parseDouble(inputArgs[ArgIndex++]);
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
                double TotalArea = 0;
                for (Drawable drawable : drawableObjects) {
                    if (drawable instanceof Circle circle) {
                        TotalArea += circle.getArea();
                    } else if (drawable instanceof Cube cube) {
                        TotalArea += cube.getArea();
                    }
                }

                resultLabel.setText("Total Area: " + (TotalArea));
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
