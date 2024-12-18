package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("Positional Game");
        this.init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.configPanel = new ConfigPanel(this);
        this.controlPanel = new ControlPanel(this);
        this.canvas = new DrawingPanel(this);

        add(configPanel, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }

}
