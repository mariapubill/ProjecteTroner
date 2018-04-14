package Client.ClientView;

import javax.swing.*;
import java.awt.*;

public class LoginPane extends JPanel{
    private JButton button = new JButton("I'm a button");

    public LoginPane(){
        setLayout(new GridBagLayout());
        setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 2;
        this.add(button, gbc);

    }
}
