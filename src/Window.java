import javax.swing.*;
import java.awt.*;

public class Window {
    public KeyboardListener keyboardListener = new KeyboardListener();
    public JFrame window = new JFrame("Canvas Example");
    public GameCanvas gameCanvas = new GameCanvas();
    public JButton restartButton = new JButton();

    public Window() {
        // creating a frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 550);
        window.setVisible(true);
        window.setLayout(null);

        setElements();
        addElements();
    }

    public void setElements() {

        // Setting buttons
        restartButton.setBounds(30, 280, 90, 40);
        restartButton.setText("Restart");
        restartButton.setActionCommand("restart");
    }

    public void addElements() {
        // Adding canvas to frame
        gameCanvas.addKeyListener(keyboardListener);
        window.add(gameCanvas);
        window.getContentPane().add(restartButton, BorderLayout.CENTER);
    }

}
