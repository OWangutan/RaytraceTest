import javax.swing.*;
import java.awt.*;
import java.util.*;
class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(320,240);




        //testing
        ArrayList<Object3D> scene = new ArrayList<Object3D>();
        Point3D p1 = new Point3D(50,20,1000);
        Point3D p2 = new Point3D(-30,36,1000);
        Point3D p3 = new Point3D(40,-40,1000);
        Triangle test = new Triangle(p1,p2,p3);
        System.out.println(test);
        scene.add(test);

        //p1 = origin
        //p2 = point being rotated
        //System.out.println(p1 + " origin");
        // System.out.println(p2 + " point rotated");
        //System.out.println(Rotate.rotatePoints(p1,p2,45) + " rotate");

        Point3D cameraPosition = new Point3D(0,0,0);
        Camera panel = new Camera(cameraPosition,scene);
        frame.add(panel);
        frame.setVisible(true);
    }
}