package Client.ClientView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class LogInPanel extends JPanel {
    private JButton jbLogin;
    private Image img;
    private Image icon;

    public LogInPanel(){
        this.setOpaque(false);
        this.setLayout(new GridLayout(4,6));
        this.setOpaque(false);
        jbLogin = new JButton();
        try {
            img = new ImageIcon("data/1.png").getImage();
            icon = img.getScaledInstance(80,80,Image.SCALE_DEFAULT);
            //img.getScaledInstance(2,2,Image.SCALE_FAST);
            jbLogin.setIcon(new ImageIcon(icon));
            jbLogin.setOpaque(false);
            jbLogin.setContentAreaFilled(false);
            jbLogin.setBorderPainted(false);
            jbLogin.setFocusPainted(false);
            jbLogin.setFocusPainted(false);
            jbLogin.setSize(new Dimension(40,40));
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
        panelHolder[0][0].add(jbLogin);

    }
    public void registerControllerButton(ActionListener controller){
        jbLogin.addActionListener(controller);
        jbLogin.setActionCommand("Back");
    }

    public void registerControllerMouse(MouseListener controller){
        jbLogin.addMouseListener(controller);

    }

    public void augmentButtons(String button, int x){
        icon = img.getScaledInstance(x,x,Image.SCALE_DEFAULT);
        jbLogin.setIcon(new ImageIcon(icon));
    }


}
