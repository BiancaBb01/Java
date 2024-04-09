package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerCol;
    JSpinner spinnerRow;
    Game game;
    JButton createGameButton = new JButton("Create");
    private int cols, rows;


    public ConfigPanel(MainFrame frame){
        this.frame = frame;
        this.cols = 10;
        this.rows = 10;
        this.game = new Game(this.rows, this.cols);

        // Adauga jucatorii
        try {
            Player red = new Player(Color.RED, "1");
            Player blue = new Player(Color.BLUE, "2");

            this.game.addPlayer(red);
            this.game.addPlayer(blue);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        init();
    }

    /**
     * initializeaza componentele interfetei
     */
    private void init() {
        label = new JLabel("Grid size: ");
        spinnerCol = new JSpinner(new SpinnerNumberModel(10,2,100,1));
        spinnerRow = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        add(label);
        add(spinnerCol);
        add(spinnerRow);
        add(createGameButton);
        this.game.initialize();

        createGameButton.addActionListener(this::createGame);
    }

    /**
     * incarca un joc dintr un fisier local
     */
    public void loadGame() {
        this.frame.canvas.redraw();
        this.frame.repaint();
    }

    /**
     * se initializeaza un nou joc cand butonul este apasat
     */
    public void createGame(ActionEvent e) {
        this.setCols(this.spinnerCol.getValue().hashCode());
        this.setRows(this.spinnerRow.getValue().hashCode());
        this.frame.canvas.redraw();
        this.frame.repaint();
        this.game.initialize(this.rows, this.cols);
    }

    /**
     * Get the columns
     */
    public int getCols() {
        return cols;
    }

    /**
     * Set the columns
     */
    public void setCols(int cols) {
        this.cols = cols;
    }

    /**
     * Get the rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Set the rows
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Get the game instance
     */
    public Game getGame() {
        return game;
    }

    /**
     * Set the game instance
     */
    public void setGame(Game game) {
        this.game = game;
    }
}
