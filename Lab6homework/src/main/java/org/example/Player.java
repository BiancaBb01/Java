package org.example;

import java.awt.*;
import java.io.Serializable;

public class Player {
    private Color color;
    private String ign;

    public Player() {

    }

    public Player(Color color, String ign) {
        this.color = color;
        this.ign = ign;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getIgn() {
        return ign;
    }

    public void setIgn(String ign) {
        this.ign = ign;
    }
}
