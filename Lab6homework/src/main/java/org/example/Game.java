package org.example;

import java.awt.*;
import java.util.*;


public class Game {
    private int directions[] = {-1, 1, 1, -1 };
    private int rows, columns;
    private Graph sticksMap;
    private Player redPlayer, bluePlayer;
    private boolean playerAdded = false;
    private boolean isRed = true;


    public Game() {

    }

    public Game(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.sticksMap = new Graph(rows * columns);
    }

    public void initialize(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.initialize();
    }


    private boolean validateGeneration(int left, int right) {
        if(right < 0 || right > this.rows * this.columns)
            return false;
        if(this.sticksMap.pairExists(left, right))
            return false;

        if(right % this.rows == 0 && left == right - 1)
            return false;

        if(left % this.rows == 0 && left == right + 1)
            return false;
        return true;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void initialize() {
        // first we should update the directions vector
        directions[0] = -1 * this.rows;
        directions[2] = this.rows;

        int sticksCounter = 2 * this.rows * this.columns;
        this.sticksMap.reinitializeGraph();

        System.out.format("Sticks that will be added: %d\n", sticksCounter);
        int value = getRandomNumber(0, this.rows * this.columns - 1);
        this.sticksMap.createNode(value);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(value);

        int idx = 0;
        while (idx <= sticksCounter && !queue.isEmpty()) {
            int current = queue.poll();
            int added = 0;
            for(int i = 0; i < 4; ++i) {
                int newNode = current + this.directions[i];
                if(validateGeneration(current, newNode)) {
                    queue.add(newNode);
                    this.sticksMap.createNode(newNode);
                    this.sticksMap.createPair(newNode, current);
                    added++;
                }
            }
            idx += added;
        }

        System.out.println("Finished drawing");

    }


    public void addPlayer(Player p) throws InvalidGame {
        if(playerAdded == true) {
            throw new InvalidGame("You can have up to two players!");
        }
        if (this.redPlayer == null) {
            this.redPlayer = p;
        } else {
            this.bluePlayer = p;
            playerAdded = true;
        }
    }


    public void start() throws InvalidGame {
        if(playerAdded == false) {
            throw new InvalidGame("You must have two players added to this game");
        }
    }

    public boolean validate(int x, int y) {
        // reverse engineer the location
        int location = x / this.rows + y % this.rows;
        System.out.println(location);
        return true;
    }


    public Color colorOfCurrentPlayer() {
        if (isRed)
            return this.redPlayer.getColor();
        return this.bluePlayer.getColor();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Graph getSticksMap() {
        return sticksMap;
    }

    public void setSticksMap(Graph sticksMap) {
        this.sticksMap = sticksMap;
    }

    public boolean isPlayerAdded() {
        return playerAdded;
    }

    public void setPlayerAdded(boolean playerAdded) {
        this.playerAdded = playerAdded;
    }

    public Player getRedPlayer() {
        return redPlayer;
    }

    public void setRedPlayer(Player redPlayer) {
        this.redPlayer = redPlayer;
    }

    public Player getBluePlayer() {
        return bluePlayer;
    }

    public void setBluePlayer(Player bluePlayer) {
        this.bluePlayer = bluePlayer;
    }

    public boolean isRed() {
        return isRed;
    }

    public void setRed(boolean red) {
        isRed = red;
    }
}
