package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class color_strategy {

    private static final String IMG_PATH = "main\\src\\main\\resources\\map.jpg";

    private static void makeGUI() throws IOException {

        //Create the window
        JFrame frame = new JFrame("Main_Window");
        //What happens when frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Outer panel
        JPanel outer = new JPanel();
        JPanel mapPanel = new JPanel();
        JPanel side = new JPanel();
        side.setLayout(new BoxLayout(side, BoxLayout.PAGE_AXIS));

        //Bottom panel, pick colors
        JPanel colors = new JPanel();
        JButton redColor = new JButton();
        redColor.setBackground(Color.red);
        JButton greenColor = new JButton();
        greenColor.setBackground(Color.green);

        //Image of map
        BufferedImage map = ImageIO.read(new File(IMG_PATH));
        Image scaledMap = map.getScaledInstance(800, -1, Image.SCALE_FAST);
        ImageIcon icon = new ImageIcon(scaledMap);
        JLabel image = new JLabel(icon);

        //Panel with controls
        JPanel controls1 = new JPanel();
        JComboBox constraintSelection2 = new JComboBox(new String[] {"Departure", "Arrival", "Overflight"});
        JComboBox constraintSelection3 = new JComboBox(new String[] {"PHL", "LAX", "ORD", "ATL", "JFK"});
        controls1.add(constraintSelection2);
        controls1.add(constraintSelection3);
        controls1.add(redColor);

        JPanel controls2 = new JPanel();
        JComboBox constraintSelection5 = new JComboBox(new String[] {"Departure", "Arrival", "Overflight"});
        JComboBox constraintSelection6 = new JComboBox(new String[] {"PHL", "LAX", "ORD", "ATL", "JFK"});
        controls2.add(constraintSelection5);
        controls2.add(constraintSelection6);
        controls2.add(greenColor);

        JPanel buttons = new JPanel();
        JButton loadDatabase = new JButton("Load database");
        JButton generateVisualization = new JButton("Generate Visualization");
        JButton reset = new JButton("Reset");

        buttons.add(loadDatabase);
        buttons.add(generateVisualization);
        buttons.add(reset);

        //Add all items to respective panels
        frame.add(outer);
        outer.add(image);
        image.add(mapPanel);
        outer.add(side);
        side.add(controls1);
        side.add(controls2);
        side.add(buttons);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    makeGUI();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (
                        ClassNotFoundException | InstantiationException | IllegalAccessException |
                                UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}