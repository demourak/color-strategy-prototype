package main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class color_strategy {

    private static final String IMG_PATH = "H:\\GitHub\\color-strategy-prototype\\main\\src\\main\\resources\\map.jpg";

    private static void makeGUI() throws IOException {

        //Create the window
        JFrame frame = new JFrame("Main_Window");
        //What happens when frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Outer panel
        JPanel outer = new JPanel();

        //Bottom panel, pick colors
        JPanel colors = new JPanel();
        JButton redColor = new JButton();
        redColor.setBackground(Color.red);
        JButton greenColor = new JButton();
        greenColor.setBackground(Color.green);

        //Image of map
        BufferedImage map = ImageIO.read(new File(IMG_PATH));
        ImageIcon icon = new ImageIcon(map);
        JLabel image = new JLabel(icon);

        //Panel with controls
        JPanel controls = new JPanel();
        JComboBox firstColorFilter = new JComboBox();
        JComboBox secondColorFilter = new JComboBox();
        JComboBox airports1 = new JComboBox();
        JComboBox airports2 = new JComboBox();
        controls.add(firstColorFilter);
        controls.add(airports1);
        controls.add(secondColorFilter);
        controls.add(airports2);

        //Add all items to respective panels
        frame.add(outer);
        outer.add(image);
        outer.add(controls);
        outer.add(colors);
        colors.add(redColor);
        colors.add(greenColor);

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
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
            }
        });
    }
}
