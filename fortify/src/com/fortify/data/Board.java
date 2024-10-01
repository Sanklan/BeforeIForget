package com.fortify.data;

import java.util.Arrays;

public class Board {
    private int[][] cells;

    public Board(int[][] cells) {
        this.cells = cells;
        System.out.println("Board created \n" + this.toString());
    }

    public Board() {
        this.cells = new int[9][9];
        for(int[] row:cells) Arrays.fill(row, -1);
    }

    public void updateRow(int row, int[] value) {
        this.cells[row] = value;
    }

    public void updateCell(int row, int col, int value) {
        this.cells[row][col] = value;
    }

    public boolean isEmpty(int row, int col) {
        return this.cells[row][col] == -1;
    }

    public int getCell(int row, int col) {
        return this.cells[row][col];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cells.length; i++) {
            if (i % 3 == 0 && i != 0) {
                sb.append("- - - - - - - - - - - - -\n");
            }
            for (int j = 0; j < cells[0].length; j++) {
                if (j % 3 == 0 && j != 0) {
                    sb.append(" | ");
                }
                if (j == 8) {
                    sb.append(cells[i][j] + "\n");
                } else {
                    sb.append(cells[i][j] + " ");
                }
            }
        }

        return sb.toString();
    }
}
