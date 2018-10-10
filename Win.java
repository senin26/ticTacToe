// Identify win or defeat by handling the clicked cells

public class Win {

private boolean isWinner;
private boolean isLoser;
private char[] clickedCells;

Win()
{
    isWinner = false;
    isLoser = false;
    clickedCells = new char[9];
    for (int i = 0; i < 9; i++) {
        clickedCells[i] = '-';
    }
}

    public void setX(int numberX) {
        clickedCells[numberX] = 'x';
    }

    public void set0(int number0) {
        clickedCells[number0] = '0';
    }

    public char[] getClickedCells() {
        return clickedCells;
    }

    public boolean checkWin()
    {
        if (clickedCells[0]=='x' && clickedCells[1]=='x' && clickedCells[2]=='x' ) {
            return isWinner = true;
        }
        else if (clickedCells[3]=='x' && clickedCells[4]=='x' && clickedCells[5]=='x' ) {
            return isWinner = true;
        }
        else if (clickedCells[6]=='x' && clickedCells[7]=='x' && clickedCells[8]=='x' ) {
            return isWinner = true;
        }
        ////////////////////////
        else if (clickedCells[0]=='x' && clickedCells[3]=='x' && clickedCells[6]=='x' ) {
            return isWinner = true;
        }
        else if (clickedCells[1]=='x' && clickedCells[4]=='x' && clickedCells[7]=='x' ) {
            return isWinner = true;
        }
        else if (clickedCells[2]=='x' && clickedCells[5]=='x' && clickedCells[8]=='x' ) {
            return isWinner = true;
        }
        ////////////////////////
        else if (clickedCells[0]=='x' && clickedCells[4]=='x' && clickedCells[8]=='x' ) {
            return isWinner = true;
        }
        else if (clickedCells[2]=='x' && clickedCells[4]=='x' && clickedCells[6]=='x' ) {
            return isWinner = true;
        }
        return isWinner = false;
    }

    public boolean checkDefeat()
    {
        if (clickedCells[0]=='0' && clickedCells[1]=='0' && clickedCells[2]=='0' ) {
            return isLoser = true;
        }
        else if (clickedCells[3]=='0' && clickedCells[4]=='0' && clickedCells[5]=='0' ) {
            return isLoser = true;
        }
        else if (clickedCells[6]=='0' && clickedCells[7]=='0' && clickedCells[8]=='0' ) {
            return isLoser = true;
        }
        ////////////////////////
        else if (clickedCells[0]=='0' && clickedCells[3]=='0' && clickedCells[6]=='0' ) {
            return isLoser = true;
        }
        else if (clickedCells[1]=='0' && clickedCells[4]=='0' && clickedCells[7]=='0' ) {
            return isLoser = true;
        }
        else if (clickedCells[2]=='0' && clickedCells[5]=='0' && clickedCells[8]=='0' ) {
            return isLoser = true;
        }
        ////////////////////////
        else if (clickedCells[0]=='0' && clickedCells[4]=='0' && clickedCells[8]=='0' ) {
            return isLoser = true;
        }
        else if (clickedCells[2]=='0' && clickedCells[4]=='0' && clickedCells[6]=='0' ) {
            return isLoser = true;
        }
        return isLoser = false;
    }

}
