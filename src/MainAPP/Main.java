package MainAPP;
import MainAPP.GUI.Login_FRAME;
import javax.swing.JFrame;

public class Main extends javax.swing.JFrame {
    public static void main(String[] args) {
        ConnectDB con = new ConnectDB();
        ConnectDB.Connect();
        new Login_FRAME().setVisible(true);
//        Login_FRAME frame;
//        frame = (Login_FRAME) new JFrame();
//        frame.setVisible(true);
    }
}
