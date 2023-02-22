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
        //make 2D array of pixels
        Color[][] pixels = new Color[getWidth()][getHeight()];
        //finds the distance where the origin have to be so all the rays are one pixel apart at the panel.
        double panelDistance = getWidth()/2 * Math.sin(Math.toRadians(90 - fov/2))/Math.sin(Math.toRadians(fov/2));
        //makes point of origin 
        //Point3D origin = new (position)
      
        for(int r = 0; r < getWidth(); r++){
            for(int c = 0; c < getHeight(); c++){
             // Ray ray = new Ray(position, ;

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
                pixels[r][c] = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
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

/* notes
    weighted average: R(t) = (1-t)C + tP

    I = R(t)

    line Equation: Δyx - Δxy + bΔx = 0 == ax +by + c = 0

    panel Equation: ax + by +cz + d = 0
 */