import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Homework1 extends JFrame implements ActionListener {
    private final JComboBox<String> comboBox;

    public Homework1() {
        setLayout(new FlowLayout());
        add(new JLabel("Choose the Shape"));

        String[] shapes = {"None", "Tree", "Hexagonal Polygon", "Circles"};
        comboBox = new JComboBox<>(shapes);
        comboBox.addActionListener(this);
        add(comboBox);

        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        switch (comboBox.getSelectedIndex()) {
            case 1 -> drawShape1(g);
            case 2 -> drawShape2(g);
            case 3 -> drawShape3(g);
            default -> {}
        }
    }

    private void drawShape1(Graphics g) {
        g.setColor(new Color(150, 70, 0));
        g.fillRect(250, 250, 20, 140);
        g.setColor(Color.GREEN);
        g.fillOval(222, 140, 75, 150);
    }

    private void drawShape2(Graphics g) {
        g.setColor(Color.CYAN);
        g.drawLine(200, 200, 300, 200);
        g.drawLine(200, 200, 150, 300);
        g.drawLine(300, 200, 350, 300);
        g.drawLine(200, 400, 300, 400);
        g.drawLine(350, 300, 300, 400);
        g.drawLine(150, 300, 200, 400);
        g.setColor(Color.MAGENTA);
        g.drawLine(150, 300, 350, 300);
        g.drawLine(300, 200, 200, 400);
        g.drawLine(200, 200, 300, 400);
        g.setColor(Color.RED);
        drawOval(g, 195, 195);
        drawOval(g, 295, 195);
        drawOval(g, 145, 295);
        drawOval(g, 345, 295);
        drawOval(g, 195, 395);
        drawOval(g, 295, 395);
        drawOval(g, 245, 295);
    }

    private void drawOval(Graphics g, int x, int y) {
        g.fillOval(x, y, 13, 13);
    }

    private void drawShape3(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(110, 210, 260, 200);
        g.setColor(Color.RED);
        drawOval(g, 240, 250, 90, 120);
        drawOval(g, 240, 240, 100, 140);
        drawOval(g, 240, 230, 110, 160);
        drawOval(g, 240, 220, 120, 180);
        drawOval(g, 240, 210, 130, 200);
        drawOval(g, 150, 250, 90, 120);
        drawOval(g, 140, 240, 100, 140);
        drawOval(g, 130, 230, 110, 160);
        drawOval(g, 120, 220, 120, 180);
        drawOval(g, 110, 210, 130, 200);
    }

    private void drawOval(Graphics g, int x, int y, int width, int height) {
        g.drawOval(x, y, width, height);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        repaint();
    }

    public static void main(String[] args) {
        new Homework1();
    }

}
