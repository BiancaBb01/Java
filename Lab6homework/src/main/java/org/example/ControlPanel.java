package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * clasa care controleaza butoanele
  loading, saving, screenshotting the game and exiting
 */
public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton screenShootBtn = new JButton("Screenshot");
    JButton exitBtn = new JButton("Exit");

    /**
     *  initializeaza
     */
    public ControlPanel(MainFrame frame) {
        this.frame = frame;

        init();
    }


    private void init() {
        setLayout(new GridLayout(1,3));

        add(this.loadBtn);
        add(this.saveBtn);
        add(this.screenShootBtn);
        add(this.exitBtn);


        exitBtn.addActionListener(this::exitGame);
        saveBtn.addActionListener(this::saveGame);
        loadBtn.addActionListener(this::loadGame);
        screenShootBtn.addActionListener(this::screenShot);
    }

    private void screenShot(ActionEvent e) {
        this.frame.canvas.saveBoard();
    }


    private void loadGame(ActionEvent e) {
        try {
            Game loaded = GameUtil.load(Main.GAME_PATH + "/game.json");
            this.frame.configPanel.setGame(loaded);
            this.frame.configPanel.spinnerCol.setValue(loaded.getColumns());
            this.frame.configPanel.spinnerRow.setValue(loaded.getRows());
            this.frame.configPanel.loadGame();
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }


    private void saveGame(ActionEvent e) {
        try {
            GameUtil.save(this.frame.configPanel.getGame(), Main.GAME_PATH+ "/game.json");
        } catch (Exception exception) {
            System.err.println(exception.getMessage());
        }
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }
}
