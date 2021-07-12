package com.company;

public class Gamerack {

    String[][] gamerack = new String[6][7];

    public Gamerack() {
        for (int i = 0; i < gamerack.length; i++) {
            for (int j = 0; j < gamerack[i].length; j++) {
                gamerack[i][j] = " ";
            }
        }
        printRack();
    }
    public void printRack() {
        // bovenste rij met characters [a tm g]
        for (char ch = 'a'; ch < ('a' + gamerack[0].length); ch++) {
            System.out.print(" " + ch + " ");
        }

        //rijen en cijfers
        for (int i = gamerack.length - 1; i >= 0; i--) {
            for (int j = 0; j < gamerack[i].length; j++) {
                if (j == 0) {
                    System.out.print("\n| " + gamerack[i][j] + " | ");
                } else if (j == gamerack[i].length -1) {
                    System.out.print(gamerack[i][j] + " | " + (i +1));
                } else {
                    System.out.print(gamerack[i][j] + " | ");
                }
            }
        }

        //strepen onderaan
        System.out.print("\n");
                for (int i = 0; i < gamerack[0].length; i++) {
                    System.out.print("  - ");
        }

        // Nieuwe rij na printRack
        System.out.println("\n");
    }

    public void dropPiece(char column, String player) {
        String steen = player.substring(0, 1);
        int index = convertCharToIndex(column);
        for (int i = 0; i < gamerack.length; i++) {
            if (gamerack[i][index].equals(" ")) {
                gamerack[i][index] = steen;
                break;
            }
        }
    }

    private int convertCharToIndex(char column) {
        int index = 0;
        switch (column) {
            case 'a':
                index = 0;
                break;
            case 'b':
                index = 1;
                break;
            case 'c':
                index = 2;
                break;
            case 'd':
                index = 3;
                break;
            case 'e':
                index = 4;
                break;
            case 'f':
                index = 5;
                break;
            case 'g':
                index = 6;
                break;
        }
        return index;
    }
    public boolean checkColumnFull(char column) {
        int index = convertCharToIndex(column);
        boolean full = false;
        for (int i = 0; i < gamerack.length; i++) {
            if (gamerack[i][index].equals(" ")) {
                full = false;
            } else {
                full = true;
            }
        }
        return full;
    }
    public boolean verticalCheck(String player) {
        String steen = player.substring(0,1);

        int index = 0;

        while (index < gamerack[0].length) {
            for (int i = 0; i < gamerack.length -3; i++) {
                if (gamerack[i][index].equals(steen)
                        && gamerack[i + 1][index].equals(steen)
                        && gamerack[i + 2][index].equals(steen)
                        && gamerack[i + 3][index].equals(steen)) {
                    return true;
                }
            }
            index++;
        }
        return false;
    }

    public boolean horizontalCheck(String speler) {
        String steen = speler.substring(0, 1);

        for (String[] row : gamerack) {
            for (int j = 0; j < row.length - 3; j++) {
                if (row[j].equals(steen)
                && row[j + 1].equals(steen)
                && row[j + 2].equals(steen)
                && row[j + 3].equals(steen)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean diagonaleCheck(String player) {
        String steen = player.substring(0, 1);

        // links boven naar rechts onder
        for (int i = 0; i < gamerack.length - 3; i++) {
            for (int j = 0; j < gamerack[i].length - 3; j++) {
                if (gamerack[i][j].contains(steen)
                        && gamerack[i + 1][j + 1].contains(steen)
                        && gamerack[i + 2][j + 2].contains(steen)
                        && gamerack[i + 3][j + 3].contains(steen)) {
                    return true;
                }
            }
        }

        //links onder naar rechts boven
        for (int i = gamerack.length - 1; i > gamerack.length - 3; i--) {
            for (int j = 0; j < gamerack[i].length - 3; j++) {
                if (gamerack[i][j].contains(steen)
                        && gamerack[i - 1][j + 1].contains(steen)
                        && gamerack[i - 2][j + 2].contains(steen)
                        && gamerack[i - 3][j + 3].contains(steen)) {
                    return true;
                }
            }
        }

        //rechts boven naar links onder
        for (int i = 0; i < gamerack.length - 3; i++) {
            for (int j = gamerack[0].length - 1; j > gamerack[i].length - 3; j--) {
                if (gamerack[i][j].contains(steen)
                        && gamerack[i + 1][j - 1].contains(steen)
                        && gamerack[i + 2][j - 2].contains(steen)
                        && gamerack[i + 3][j - 3].contains(steen)) {
                    return true;
                }
            }
        }

        //rechts onder naar links boven
        for (int i = gamerack.length - 1; i > gamerack.length - 3; i--) {
            for (int j = gamerack[0].length - 1; j > gamerack[i].length - 3; j--) {
                if (gamerack[i][j].contains(steen)
                        && gamerack[i - 1][j - 1].contains(steen)
                        && gamerack[i - 2][j - 2].contains(steen)
                        && gamerack[i - 3][j - 3].contains(steen)) {
                    return true;
                }
            }
        }

        return false;
    }
}
