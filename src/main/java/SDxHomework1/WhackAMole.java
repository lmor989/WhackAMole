package SDxHomework1;

public class WhackAMole {
    // object properties
    int score;
    int molesLeft;
    int attemptsLeft;
    char[][] moleGrid;

    // constructor
    public WhackAMole(int numAttempts, int gridDimension) {
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                moleGrid[i][j] = '*';
            }
        }
    }

    // method to place mole
    public boolean place(int x, int y) {
        if (this.moleGrid[x][y] == '*') {
            this.moleGrid[x][y] = 'M';
            this.molesLeft++;
            return true;
        } else {
            return false;
        }
    }

    // method to whack mole
    public void whack(int x, int y) {
        if (this.moleGrid[x][y] == 'M') {
            System.out.println("You've struck a mole!");
            this.score++;
            this.molesLeft--;
            this.moleGrid[x][y] = 'W';
        } else {
            System.out.println("No mole here, that sucks");
        }
        this.attemptsLeft--;

    }

    // method to print grid without seeing untouched moles
    public void printGridToUser() {
        for (int i = 0; i < this.moleGrid.length; i++) {
            System.out.println();
            for (int j = 0; j < this.moleGrid[i].length; j++) {
                if (this.moleGrid[i][j] == 'W') {
                    System.out.print("W ");
                } else {
                    System.out.print("* ");
                }
            }
        }
        System.out.println();
    }

    // method to see all moles
    public void printGrid() {
        for (int i = 0; i < this.moleGrid.length; i++) {
            System.out.println();
            for (int j = 0; j < this.moleGrid[i].length; j++) {
                System.out.print(this.moleGrid[i][j] + " ");
            }
        }
    }
}