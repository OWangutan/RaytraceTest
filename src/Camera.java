import javax.swing.*;
import java.awt.*;
public class Camera extends JPanel{
    private Point3D position;
    private double pitch;
    private double yaw;
    private double roll;
    private double fov = 70;
    //constructers
    public Camera(Point3D position){
        setBackground(Color.BLUE);
        this.position = position;
    }
    // here is the rendering

    private Color[][] render(){
        Color[][] pixels = new Color[getWidth()][getHeight()];
        double panelDistance = getWidth()/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2));

        for(int r = 0; r < getWidth(); r++){
            for(int c = 0; c < getHeight(); c++){


            }
        }
        return pixels;
    }

    //printing
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        Color[][] pixels = new Color[getWidth()][getHeight()];
        for(int r = 0; r < getWidth(); r++){
            for(int c = 0; c < getHeight(); c++){
                pixels[r][c] = new Color((int)(Math.random()*256),0,0);
                if(pixels[r][c] != null) {
                    g.setColor(pixels[r][c]);
                    g.drawLine(r,c,r,c);
                }
            }
        }


        try {
            Thread.sleep(10);
        } catch(Exception e) {
            System.out.println(e);
        }
        repaint();
    }
}