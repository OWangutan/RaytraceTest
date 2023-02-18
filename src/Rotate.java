public class Rotate {

    public Rotate() {

    }

    public static double rotatePoints(Point3D origin, Point3D point, double degrees) {
        double radius = Math.sqrt((point.getXYZ()[0]-origin.getXYZ()[0])+(point.getXYZ()[1]-origin.getXYZ()[1]));
        double distance = (2*radius)*(Math.sin(degrees/2));
        return distance;
    }
}
