import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;

public class Homework3 extends JFrame implements ActionListener {
    JComboBox comboBox;
    Graphics2D g2d;

    public Homework3() {
        super("HomeWork3");
        setLayout(new FlowLayout());
        add(new JLabel("Choose the Shape"));

        String[] shapes = {"None", "Reflecting the shape", "Shape1", "Shape2", "Shape3"};
        comboBox = new JComboBox(shapes);
        comboBox.addActionListener(this);
        add(comboBox);

        setSize(800, 700);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void left(double a) {
        g2d.rotate(-a * Math.PI / 180);
    }

    public void right(double a) {
        g2d.rotate(a * Math.PI / 180);
    }

    public void forward(int length) {
        g2d.drawLine(0, 0, length, 0);
        g2d.translate(length, 0);
    }

    public void moveTo(int x, int y) {
        g2d.translate(x, y);
    }

    void drawShape0() {
        double[] m = new double[6];
        Polygon p = new Polygon();
        p.addPoint(250, 130);
        p.addPoint(220, 130);
        p.addPoint(220, 160);
        p.addPoint(190, 180);
        p.addPoint(160, 160);
        g2d.drawPolygon(p);

        g2d.drawLine(0, 700, 700, 0);
        g2d.translate(700, 0);
        g2d.scale(-1, 1);
        g2d.fillPolygon(p);
        g2d.getTransform().getMatrix(m);
    }


    void drawShape1() {
        left(-60);

        for (int i = 0; i <= 5; i++) {
            g2d.setColor(Color.blue);
            g2d.drawOval(0, -15, 120, 30);
            left(-60);
            g2d.setColor(Color.black);
            forward(120);
            left(120);
            g2d.setColor(Color.blue);
            g2d.drawOval(0, -15, 120, 30);
            left(-60);
            g2d.setColor(Color.blue);
            g2d.fillOval(0, -15, 120, 30);
            forward(120);
            g2d.setColor(Color.red);
            g2d.fillRect(-90, 0, 60, 60);
            g2d.setColor(Color.blue);
            left(120);
            g2d.drawOval(0, -15, 120, 30);
        }
    }

    void drawShape2() {
        for (int j = 1; j <= 2; j++) {
            forward(120);
            left(120);
        }

        forward(120);
        left(115);
    }

    void drawShape3() {
        for (int j = 1; j <= 3; j++) {
            forward(50);
            left(120);
        }

        forward(50);
        left(30);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g2d = (Graphics2D) g;

        switch (comboBox.getSelectedIndex()) {
            case 1 -> drawShape0();
            case 2 -> {
                moveTo(300, 250);
                drawShape1();
            }
            case 3 -> {
                moveTo(350, 300);

                for (int i = 1; i <= 8; i++) {
                    g2d.rotate(-50 * Math.PI / 180);
                    drawShape2();
                }
            }
            case 4 -> {
                moveTo(350, 350);

                for (int i = 1; i <= 12; i++) {
                    drawShape3();
                }
            }
            default -> {
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        repaint();
    }

    public static void main(String[] args) {
        new Homework3();
    }

}