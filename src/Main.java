import javax.swing.*;
import java.awt.*;
import java.util.*;
class Main {
    public static void main(String[] args) {





        //testing
        ArrayList<Object3D> scene = new ArrayList<Object3D>();
        Point3D p1 = new Point3D(-5,-50,4);
        Point3D p2 = new Point3D(6,-60,1);
        Point3D p3 = new Point3D(4,-40,5);
        Triangle test = new Triangle(p1,p2,p3);
        scene.add(test);

        //p1 = origin
        //p2 = point being rotated
        //System.out.println(p1 + " origin");
        // System.out.println(p2 + " point rotated");
        //System.out.println(Rotate.rotatePoints(p1,p2,45) + " rotate");
        JFrame frame = new JFrame();
        frame.setSize(320,240);
        Point3D cameraPosition = new Point3D(0,0,0);
        Camera panel = new Camera(cameraPosition,scene);
        frame.add(panel);
        frame.setVisible(true);

        int clock = 0;
        boolean running = true;
        while (running){
            test.setPoint1(new Point3D(-5,-50,test.getPointA().getz() * -1));
            try {
                Thread.sleep(100);
            } catch(Exception e) {
                System.out.println(e);
            }
            if (clock == 1000){
                running = false;
            }
        }
    }
}