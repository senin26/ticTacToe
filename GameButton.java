import javax.swing.*;

// Operation while any cell of the gameboard is pressed

public class GameButton extends JButton {

    private int buttonNumber;
    private boolean isClickedPlayer;
    private boolean isClickedComputer;
    private boolean isClicked; // check whether the cell is clicked

    GameButton(int buttonNumber)
    {
        super();
        this.buttonNumber = buttonNumber;
        isClickedPlayer = false;
        isClickedComputer = false;
        isClicked = false;
    }

    public int getButtonNumber() {
        return buttonNumber;
    }

    public boolean isClickedPlayer() {
        return isClickedPlayer;
    }

    public void setClickedPlayer(boolean clicked) {
        isClickedPlayer = clicked;
    }

    public boolean isClickedComputer() {
        return isClickedComputer;
    }

    public void setClickedComputer(boolean clicked) {
        isClickedComputer = clicked;
    }

    public boolean isClicked(){
        this.isClicked = (isClickedComputer | isClickedPlayer);
        return isClicked;
    }
}
