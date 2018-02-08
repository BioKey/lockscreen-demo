import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.Robot;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main extends JPanel implements MouseMotionListener {
    public int height, width;
    public Robot robot;
    public JLabel label, label2 , label3, label4;
    public Main () throws Exception {
        robot = new Robot();
        height = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
        width = Toolkit.getDefaultToolkit().getScreenSize().width / 2;

        label = new JLabel("It is highly suspected that you are not authorised ");
        label.setForeground(Color.red);
        label.setFont(new Font("Verdana", 1, 45));
        label.setBorder(new EmptyBorder(100,0,0,0));

        label2 = new JLabel("to use this computer. ");
        label2.setForeground(Color.red);
        label2.setFont(new Font("Verdana", 1, 45));

        label3 = new JLabel("Please contact your administrator.");
        label3.setForeground(Color.red);
        label3.setFont(new Font("Verdana", 1, 45));
        label3.setBorder(new EmptyBorder(100,0,0,0));

        label4 = new JLabel("BioKey © Synergy Software Production");
        label4.setForeground(Color.red);
        label4.setFont(new Font("Verdana", 1, 25));
        label4.setBorder(new EmptyBorder(325,0,0,0));

        add(label);
        add(label2);
        add(label3);
        add(label4);

        this.addMouseMotionListener(this);
    }
    public void mouseMoved (MouseEvent e){
        System.out.println("Mouse Moved: " + e);
        robot.mouseMove(10000,-10000);
    }
    public void mouseDragged(MouseEvent e){
        System.out.println("Mouse Moved: " + e);
        robot.mouseMove(10000,-10000);
    }
    public void createAndShowGUI() throws Exception {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE ); // https://stackoverflow.com/questions/32077449/whats-the-point-of-setdefaultcloseoperationwindowconstants-exit-on-close
        frame.setContentPane(new Main());
        frame.setUndecorated(true);
        frame.pack();
        frame.setAlwaysOnTop(true); // Pushes it to the top
        frame.setResizable(false); // Can't change the size of it
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().width,Toolkit.getDefaultToolkit().getScreenSize().height); // Fullscreen based on screen size
        frame.setVisible(true);
    }
    public static void main(String[] args) throws Exception {
        Main h = new Main();
        h.createAndShowGUI();
        System.out.println("Hello, World!");
    }
}
