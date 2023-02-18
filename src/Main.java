import javax.swing.*;
import java.awt.*;
class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1280,720);
        Point3D cameraPosition = new Point3D(0,0,0);
        Camera panel = new Camera(cameraPosition);
        frame.add(panel);
        frame.setVisible(true);
    }
}