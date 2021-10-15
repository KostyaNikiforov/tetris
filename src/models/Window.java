package models;

import models.GameCanvas;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;

public class Window {
    public KeyboardListener keyboardListener = new KeyboardListener();
    public ButtonListener buttonListener = new ButtonListener();
    public JFrame window = new JFrame("TETRIS GAME");
    public GameCanvas gameCanvas = new GameCanvas();

    private ImageIcon icon = new ImageIcon("/home/archkonstantin/IdeaProjects/Tetris/res/images/icons/pause-icon.png");
    private JLabel gameLevelText = new JLabel("Level");
    private JLabel gameLevelValue= new JLabel("0");
    private JLabel gameScoreText = new JLabel("Score");
    private JLabel gameScoreValue = new JLabel("0");

    public JButton restartButton = new JButton();
    public JButton pauseButton = new JButton();

    public JPanel mainPanel = new JPanel();
    public JPanel leftPanel = new JPanel();
    public JPanel fieldPanel = new JPanel();

    public Window() {
        // creating a frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 500);
        window.setVisible(true);
        window.setLayout(null);

        setElements();
        addElements();
    }

    public void setElements() {


        //Setting panels
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setSize(400, 500);

        fieldPanel.setBackground(Color.GRAY);

        leftPanel.setBackground(Color.GRAY);
        leftPanel.setSize(100, 400);

        // Setting textLabel
        //gameLevelText.setBounds(400, 85, 100, 20);
        //gameLevelValue.setBounds(415, 110, 100, 20);
        //gameScoreText.setBounds(400 , 140, 100, 20);
        //gameScoreValue.setBounds(415, 165, 100, 20);

        // Setting buttons
        restartButton.setBounds(375, 280, 90, 40);
        restartButton.setText("Restart");
        restartButton.setActionCommand("restart");
        restartButton.addActionListener(buttonListener);

        pauseButton.setBounds(375, 200, 90, 40);
        pauseButton.setText("Pause");
        pauseButton.setActionCommand("pause");
        pauseButton.addActionListener(buttonListener);
    }

    public void addElements() {
        // Adding canvas to frame
        gameCanvas.addKeyListener(keyboardListener);
        fieldPanel.add(gameCanvas);

        leftPanel.add(gameLevelText, BorderLayout.CENTER);
        leftPanel.add(gameLevelValue, BorderLayout.CENTER);
        leftPanel.add(gameScoreText, BorderLayout.CENTER);
        leftPanel.add(gameScoreValue, BorderLayout.CENTER);

        leftPanel.add(restartButton);
        leftPanel.add(pauseButton);

        window.add(mainPanel);
        mainPanel.add(fieldPanel, BorderLayout.CENTER);
        mainPanel.add(leftPanel, BorderLayout.CENTER);

    }


    public void setGameLevel(int newLevel){
        this.gameLevelValue.setText(Integer.toString(newLevel));
    }

    public void setGameScore(int newScore){
        this.gameScoreValue.setText(Integer.toString(newScore));
    }
}
