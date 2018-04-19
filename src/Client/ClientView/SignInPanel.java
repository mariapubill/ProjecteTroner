package Client.ClientView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class SignInPanel extends JPanel{
    private JButton jbSignIn;
    private JButton jbMute;
    private Image icon;
    private Image muteIcon;

    private Image muteImg;

    private Image img;


    public SignInPanel(){
        this.setLayout(new GridLayout(4,6));
        this.setOpaque(false);
        jbSignIn = new JButton();
        jbMute = new JButton();

        try {
            img = new ImageIcon("data/1.png").getImage();
            icon = img.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            jbSignIn.setIcon(new ImageIcon(icon));
            jbSignIn.setOpaque(false);
            jbSignIn.setContentAreaFilled(false);
            jbSignIn.setBorderPainted(false);
            jbSignIn.setFocusPainted(false);
            jbSignIn.setFocusPainted(false);
            jbSignIn.setSize(new Dimension(40,40));


            muteImg = new ImageIcon("data/mute.png").getImage();
            muteIcon = muteImg.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            jbMute.setIcon(new ImageIcon(muteIcon));
            jbMute.setOpaque(false);
            jbMute.setContentAreaFilled(false);
            jbMute.setBorderPainted(false);
            jbMute.setFocusPainted(false);
            jbMute.setFocusPainted(false);
            jbMute.setSize(new Dimension(40,40));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        int i = 4;
        int j = 6;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i,j));

        for(int m = 0; m < i; m++) {
            for(int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                panelHolder[m][n].setOpaque(false);
                add(panelHolder[m][n]);
            }
        }
        panelHolder[0][0].add(jbSignIn);
        panelHolder[0][5].add(jbMute);




    }

    public void registerControllerButton(ActionListener controller){
        jbSignIn.addActionListener(controller);
        jbSignIn.setActionCommand("Back");
        jbMute.addActionListener(controller);
        jbMute.setActionCommand("Mute");
    }

    public void registerControllerMouse(MouseListener controller){
        jbSignIn.addMouseListener(controller);
        jbMute.addMouseListener(controller);

    }

    public void augmentButtons(String button, int x){
        if(button.equals("Mute")){
            muteIcon = muteImg.getScaledInstance(x,x,Image.SCALE_DEFAULT);
            jbMute.setIcon(new ImageIcon(muteIcon));
        }
        if(button.equals("Back")){
            icon = img.getScaledInstance(x,x,Image.SCALE_DEFAULT);
            jbSignIn.setIcon(new ImageIcon(icon));

        }

    }


}
