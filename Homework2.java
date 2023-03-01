import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Homework2 extends JFrame {

    public Homework2() {
        super("Simple Animation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane pane = new JTabbedPane();
        pane.addTab("Car", new CarPanel());
        pane.addTab("Balls", new BallsPanel());
        pane.addTab("Any other Shapes", new ShapesPanel());
        add(pane);

        pack();
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Homework2();
    }
}

class CarPanel extends JPanel implements ActionListener {
    Timer t;
    int x = 0, y = 70;

    public CarPanel() {
        t = new Timer(200, this);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x1 = x;
        int y1 = y;
        int[] a = {x1, x1 + 180, x1 + 180, x1};
        int[] b = {y1, y1, y1 + 30, y1 + 30};
        g.fillPolygon(a, b, 4);
        int[] a1 = {x1 + 30, x1 + 60, x1 + 120, x1 + 150};
        int[] b1 = {y1, y1 - 30, y1 - 30, y1};
        g.setColor(Color.YELLOW);
        g.fillPolygon(a1, b1, 4);
        g.setColor(Color.BLACK);
        g.fillOval(x1 + 30, y1 + 30, 40, 40);
        g.setColor(new Color(255, 252, 221));
        g.fillOval(x1 + 35, y1 + 35, 30, 30);
        g.setColor(Color.BLACK);
        g.fillOval(x1 + 120, y1 + 30, 40, 40);
        g.setColor(new Color(255, 252, 221));
        g.fillOval(x1 + 125, y1 + 35, 30, 30);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        x += 5;
        if (x > getWidth())
            x = 0;
        repaint();
    }
}

class BallsPanel extends JPanel implements ActionListener {
    JTextField ballsTextField;
    JLabel ballsLabel;
    JPanel panel;
    int n;
    Timer t;

    public BallsPanel() {
        panel = new JPanel();
        add(panel);

        ballsTextField = new JTextField(8);
        ballsLabel = new JLabel("No of Balls ");
        panel.add(ballsLabel);
        panel.add(ballsTextField);

        t = new Timer(700, this);
        t.start();
    }

    private int getNumberOfBalls() {
        try {
            return Integer.parseInt(ballsTextField.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        n = getNumberOfBalls();

        for (int x = 0; x < n; x++) {
            g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256)));
            g.fillOval((int) (Math.random() * getWidth()), (int) (Math.random() * getHeight()), 30, 30);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}

class ShapesPanel extends JPanel implements ActionListener {

    public ShapesPanel() {
        Timer t = new Timer(700, this);
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.ORANGE);
        g.fillOval(150, 200, 200, 200);
        g.setColor(Color.WHITE);
        g.fillOval(200, 250, 30, 30);
        g.setColor(Color.BLACK);
        g.fillOval(208, 250, 15, 15);
        g.setColor(Color.WHITE);
        g.fillOval(270, 250, 30, 30);
        g.setColor(Color.BLACK);
        g.fillOval(278, 250, 15, 15);
        g.fillRect(210, 350, 70, 8);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
