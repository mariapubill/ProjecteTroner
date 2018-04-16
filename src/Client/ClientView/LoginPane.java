package Client.ClientView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class LoginPane extends JPanel{
    private JButton jbLogin = new JButton("LOG IN");
    private JButton jbSingin;

    public LoginPane(){
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File("data/font2.ttf"));
            GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
            genv.registerFont(font);
            font = font.deriveFont(30f);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        jbSingin = new JButton("SIGN IN");
        jbLogin.setFont(font);
        jbSingin.setFont(font);

        jbLogin.setContentAreaFilled(false);
        jbSingin.setContentAreaFilled(false);

        jbLogin.setFocusPainted(false);
        jbSingin.setFocusPainted(false);

        jbLogin.setBorder(BorderFactory.createEmptyBorder());
        jbSingin.setBorder(BorderFactory.createEmptyBorder());

        jbLogin.setOpaque(false);//enable this to create a button border
        jbSingin.setOpaque(false);//enable this to create a button border

        jbLogin.setForeground(new Color(157, 207, 222));
        jbSingin.setForeground(new Color(157, 207, 222));




        setLayout(new GridLayout());
        setOpaque(false);
        this.add(jbLogin);
        this.add(jbSingin);



    }

}


class CloseIcon implements Icon, MouseListener {
    public int width;
    public int height;
    boolean hovered;
//    public Image img1 = new ImageIcon(this.getClass().getResource("login.png")).getImage();
    public Image img1 = new ImageIcon("data/login.png").getImage();
    public Image img2 = new ImageIcon("data/sign.png").getImage();

    public CloseIcon() {
        width = img1.getWidth(null);
        height = img1.getHeight(null);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        if (hovered = true) {
            g.drawImage(img1, 0, 0, null);
        } else if (hovered = false) {
            g.drawImage(img2, 0, 0, null);
        }
    }


    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {

        return height;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}