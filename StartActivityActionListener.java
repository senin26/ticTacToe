import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Operation of the start button

public class StartActivityActionListener implements ActionListener {

    private Container container;
    private JPanel jPanel;
    private JFrame jFrame;

    StartActivityActionListener(Container container)
    {
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Start") {
            JOptionPane.showMessageDialog(container,"Let's start the game!");
        }
    }
}
