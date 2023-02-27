public class Rotate {      public Rotate() {      }    // origin (p,y)    // x′ = (x−p)cos(θ)−(y−q)sin(θ)+p,    // y′ = (x−p)sin(θ)+(y−q)cos(θ)+q.      //returns distance to new location     public static Point3D rotatePoints(Point3D origin, Point3D point, double degrees) {         double x = point.getx();         double y = point.gety();          double xO = origin.getx();         double yO = origin.gety();       }     public static Point3D getNewPoint(){        return new Point3D(1,1,1);     }
    public class Rotate {

        public Rotate() {

        }
        // origin (p,y)
        // x′ = (x−p)cos(θ)−(y−q)sin(θ)+p,
        // y′ = (x−p)sin(θ)+(y−q)cos(θ)+q.

        //returns distance to new location
        public static Point3D rotatePoints(Point3D origin, Point3D point, double degrees) {
            double x = point.getx();
            double y = point.gety();

            double xO = origin.getx();
            double yO = origin.gety();
            return new Point3D(1,1,1);

        }
        public static Point3D getNewPoint(){
            return new Point3D(1,1,1);

        }