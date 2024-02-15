package cs1302.game;

import cs1302.gameutil.GamePhase;
import cs1302.gameutil.Token;
import cs1302.gameutil.TokenGrid;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class ConnectFour {

    //----------------------------------------------------------------------------------------------
    // 인스턴스 메소드들을 수정할 수는 있지만,
    // 인스턴스 메소드들을 추가할 수는 없습니다.
    //----------------------------------------------------------------------------------------------

    private int rows;        // number of grid rows
    private int cols;        // number of grid columns
    private Token[][] grid;  // 2D array of tokens in the grid
    private Token[] player;  // 1D array of player tokens (length 2)
    private int numDropped;  // number of tokens dropped so far
    private int lastDropRow; // row index of the most recent drop
    private int lastDropCol; // column index of the most recent drop
    private GamePhase phase; // current game phase

    public ConnectFour(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        this.grid = new Token[this.rows][this.cols];
        this.player = new Token[2];
        this.numDropped = 0;
        this.lastDropCol = -1;
        this.lastDropRow = -1;
        this.phase = GamePhase.NEW;
    } // ConnectFour

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }


    public boolean isInBounds(int row, int col) {
        if ((this.rows > row) && (row >= 0) && (this.cols > col) && (col >= 0)) return true;
        else return false;
    }

    public Token getTokenAt(int row, int col) {
        if ((row > (rows - 1)) || (row < 0) || (col > (cols - 1)) || (col < 0)) {
            throw new IndexOutOfBoundsException();
        }
        return grid[row][col];
    }

    public void setPlayerTokens(Token token0, Token token1) {
        this.player[0] = token0;
        this.player[1] = token1;

        if (token0 == token1) {
            throw new IllegalArgumentException();
        }
        if (getPhase() == GamePhase.NEW) {
            this.phase = GamePhase.READY;
        }
        if ((getPhase() == GamePhase.PLAYABLE) || (getPhase() == GamePhase.OVER)) {
            throw new IllegalStateException();
        }
    } // setPlayerTokens

    public Token getPlayerToken(int player) {
        if ((player != 0) && (player != 1)) {
            throw new IllegalArgumentException();
        }
        if (getPhase() == GamePhase.NEW) {
            throw new IllegalStateException();
        }
        return this.player[player];
    } // getPlayerToken

    public int getNumDropped() {
        if ((getPhase() == GamePhase.NEW) || (getPhase() == GamePhase.READY)) {
            throw new IllegalStateException();
        }
        return this.numDropped;
    } // getNumDropped

    public int getLastDropRow() {
        if ((getPhase() == GamePhase.NEW) || (getPhase() == GamePhase.READY)) {
            throw new IllegalStateException();
        }
        return this.lastDropRow;
    } // getLastDropRow

    public int getLastDropCol() {
        if ((getPhase() == GamePhase.NEW) || (getPhase() == GamePhase.READY)) {
            throw new IllegalStateException();
        }
        return this.lastDropCol;
    } // getLastDropCol

    public GamePhase getPhase() {
        return this.phase;
    } // getPhase

    public void dropToken(int player, int col) {
        if ((col < 0) || (this.cols - 1) < col) {
            throw new IndexOutOfBoundsException();
        }
        if ((player != 0) && (player != 1)) {
            throw new IllegalArgumentException();
        }

        int numberOfTokensInColumn = this.rows - 1;
        boolean tag = false;
        for (int rowNumber = this.rows - 1; rowNumber >= 0 && tag == false; rowNumber = rowNumber - 1) {
            if (this.grid[rowNumber][col] != null) {
                numberOfTokensInColumn--;
            } else tag = true;
        }

        this.grid[numberOfTokensInColumn][col] = this.player[player];
        this.numDropped++;
        this.lastDropRow = numberOfTokensInColumn;
        this.lastDropCol = col;

        if (getPhase() == GamePhase.READY) {
            this.phase = GamePhase.PLAYABLE;
        }
        if ((getPhase() != GamePhase.READY) && (getPhase() != GamePhase.PLAYABLE)) {
            throw new IllegalStateException();
        }

    } // dropToken


    /**
     * 다음 코드를 완성하세요.
     *
     * @return
     */
    public boolean isLastDropConnectFour() {
        boolean isGridFull = true;
        boolean didLastDropConnectFour = false;

        for (int row = 0; row < this.rows; row++) {
            for (int col = 0; col < this.cols; col++) {
                if (this.grid[row][col] == null) {
                    isGridFull = false;
                }
            }
        }

        // 4개연속 token 수직 방향 체크
        Token playerInCheck = grid[lastDropRow][lastDropCol];
        int vCnt = 0;
        int verti = this.lastDropRow + 3;

        if (verti < this.rows) {
            for (; verti >= lastDropRow; verti--) {
                if (grid[verti][lastDropCol] == playerInCheck) {
                    vCnt++;
                } else {
                    vCnt = 0;
                }
                if (vCnt == 4) {
                    didLastDropConnectFour = true;
                }
            }
        }

        // 4개연속 token 수평 방향 체크
        int[] moveX = {-3, -2, -1, 1, 2, 3, -3, -2, -1, 1, 2, 3};
        int hCnt = 0;
        for (int x : moveX) {
            int dx = lastDropCol + x;
            if (dx < 0 || dx >= this.cols) continue;

            if (grid[lastDropRow][dx] == playerInCheck) {
                ++hCnt;
                if (hCnt == 4) {
                    didLastDropConnectFour = true;
                    break;
                }
            } else {
                hCnt = 1;
            }
        }

        // 4개연속 token 사선 방향 체크
        int[] moveY = {-3, -2, -1, 1, 2, 3, 3, 2, 1, -1, -2, -3};
        int dCnt = 1;
        for (int i = 0; i < moveX.length; i++) {
            int dx = lastDropCol + moveX[i];
            int dy = lastDropRow + moveY[i];

            if (dy < 0 || dy >= this.rows || dx < 0 || dx >= this.cols)
                continue;
            if (grid[dy][dx] == playerInCheck) {
                ++dCnt;
                if (dCnt == 4) {
                    didLastDropConnectFour = true;
                    break;
                }
            } else {
                dCnt = 1;
            }
        }
        if ((isGridFull == true) || (didLastDropConnectFour == true)) {
            this.phase = GamePhase.OVER;
        }

        return didLastDropConnectFour;
    }

    public void printGrid() {
        TokenGrid.println(this.grid);
    } // printGrid

} // ConnectFour
