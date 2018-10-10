import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Operation of the button

public class ButtonActionListener implements ActionListener {

    private Container container;
    private GameButton[] buttons;
    private GameButton currentButton;
    private ComputerPlayer computerPlayer;
    private WinCombinations winCombinations;
    private DefeatCombinations defeatCombinations;
    private Win win;
    private Random random;

    ButtonActionListener(GameButton[] buttons, Container container){

        this.container = container;

        this.buttons = new GameButton[buttons.length];
        for (int i = 0; i < buttons.length; i++) {
            this.buttons[i] = buttons[i];
        }

        computerPlayer = new ComputerPlayer();
        winCombinations = new WinCombinations();
        defeatCombinations = new DefeatCombinations();
        win = new Win();

        random = new Random();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // initialize currentButton with the pressed button
        currentButton = (GameButton) e.getSource();
        if ( (currentButton.getText().equals("")) ) {
            currentButton.setText("x");
            currentButton.setClickedPlayer(true);

            win.setX(currentButton.getButtonNumber());

            /*System.out.println("Clicked cells");
            for (int i = 0; i < win.getClickedCells().length; i++) {
                System.out.println(win.getClickedCells()[i]);
            }
            System.out.println();*/

            if (win.checkWin()==true){
                JOptionPane.showMessageDialog(container,"You are the winner");

                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
               System.exit(0);
            }

            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }

            winCombinations.findWinCombinations(currentButton.getButtonNumber());
            winCombinations.getCombinations();

            defeatCombinations.findDangerCells(win.getClickedCells());
            int index0;
            if (defeatCombinations.getDangerCell() != -1)
            {
                index0 = defeatCombinations.getDangerCell();
                System.out.println("index of danger cell is " + defeatCombinations.getDangerCell());
            }
            else {
                index0 = computerPlayer.setChosenCell(computerPlayer.getFinalCombination(winCombinations.getCombinations()),win.getClickedCells());
            }

            System.out.println();
            System.out.println("Danger cell for computer (if not -1) " + defeatCombinations.getDangerCell());
            System.out.println("The final combination is " + computerPlayer.getFinalCombination(winCombinations.getCombinations()));
            System.out.println();

            System.out.println("Chosen button is " + index0);

            buttons[index0].setText("0");
            win.set0(index0);

            if (win.checkDefeat()==true){
                JOptionPane.showMessageDialog(container,"You are the loser");
                try {
                    Thread.currentThread().sleep(5000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }
            System.out.println();



            /*int index = computerPlayer.setChosenCell(computerPlayer.getFinalCombination());
            System.out.println(index);
            buttons[index].setText("0");
            buttons[index].setClickedComputer(true);
            System.out.println();

            for (int i = 0; i < buttons.length; i++) {
                System.out.print(buttons[i].isClicked() + "  ");
                if (i==2 || i==5)
                {
                    System.out.println();
                }
            }
            System.out.println();*/
        }
    }
}
