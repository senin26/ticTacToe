import javax.swing.*;
import java.awt.*;

/*
* The Gameboard of the ticTacToe game
* */

public class GameBoard extends JFrame {
    private GameButton[] buttons = new GameButton[9];

    GameBoard()
    {
        super();
        setBounds(500,500,400,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        JButton startActivityBtn = new JButton("Start");
        startActivityBtn.setPreferredSize(new Dimension(150,20));
        constraints.gridx=0;
        constraints.gridy=0;
        panel.add(startActivityBtn,constraints);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new GameButton(i);
        }

        ButtonActionListener buttonActionListener  = new ButtonActionListener(buttons, this);
        StartActivityActionListener startActivityActionListener = new StartActivityActionListener(this);

        startActivityBtn.addActionListener(startActivityActionListener);

        // Handling with the buttonPanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.weightx = 0.5;

        for (int i = 0; i < buttons.length; i++) {
            if (i / 3 == 0) constraints.gridy = 0;
            else if (i / 3 == 1) constraints.gridy = 1;
            else if (i / 3 == 2) constraints.gridy = 2;

            buttons[i].addActionListener(buttonActionListener);
            buttons[i].setPreferredSize(new Dimension(50,50));
            buttonPanel.add(buttons[i], constraints);

            if (constraints.gridx != 2)
                constraints.gridx++;
            else constraints.gridx = 0;
        }

        // Adding of the buttonPanel to the main panel using constraints
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(buttonPanel,constraints);

        setContentPane(panel);
        setVisible(true);
        pack();
    }
}
