public class Triangle extends Object3D{
    private Point3D point1;
    private Point3D point2;
    private Point3D point3;

    // Plane equation: ax + by + cz + d = 0
    //R(t) = (1-t)C + tP
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    public Triangle(Point3D point1, Point3D point2, Point3D point3){
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
        Vector3D line = new Vector3D(point1, point2);
        Point3D normal = line.crossProduct(point3);
        System.out.println(normal);
        a = normal.getx();
        b = normal.gety();
        c = normal.getz();
        d = -(normal.getx() * point1.getx()) - (normal.gety() * point1.gety()) - (normal.getz() * point1.getz());
    }

    public boolean hit(Ray ray){
        double xR = ray.getDirection().getx();
        double yR = ray.getDirection().gety();
        double zR = ray.getDirection().getz();
        double t = (a*xR + b*yR + c*zR)/-d;
        double xI = (xR - ray.getOrigin().getx())*t;
        double yI = (yR - ray.getOrigin().gety())*t;
        double zI = (zR - ray.getOrigin().getz())*t;
        double[][] gaussian = new double[][]{   {point1.getx(),point2.getx(),point3.getx(),xI},
                                                {point1.gety(),point2.gety(),point3.gety(),yI},
                                                {point1.getz(),point2.getz(),point3.getz(),zI}};
        boolean[][] rowEchelon = new boolean[][] {  {false,true,true,true},
                                                    {true,false,true,true},
                                                    {true,true,false,true}};
        int c = 0;
        for(int r = 0; r < gaussian.length;r++){
            if (gaussian[r][r] != 1){
                double temp = gaussian[r][r];
                for(int i = 0; i < gaussian[0].length;i++){
                    gaussian[r][i] = gaussian[r][i]/temp;
                }
            }
            for (int y = 0; y < gaussian.length;y++){
                if(gaussian[y][c] != 0 && rowEchelon[y][c]){
                    double opposite = -gaussian[y][c];
                    double[] temp = new double[]{gaussian[r][0]*opposite,gaussian[r][1]*opposite,gaussian[r][2]*opposite,gaussian[r][3]*opposite};
                    for(int i = 0; i < gaussian[0].length; i++){
                        gaussian[y][i] = gaussian[y][i] + temp[i];
                    }
                }
            }
            c++;
        }
        for(int i = 0;i < gaussian.length;i++){
            if(gaussian[i][3] < 0){
                return false;
            }
        }
        return true;
    }

    public Point3D getPoint1() {
        return point1;
    }

    public Point3D getPoint2() {
        return point2;
    }

    public Point3D getPoint3() {
        return point3;
    }

    public void setPoint1(Point3D point1) {
        this.point1 = point1;
    }

    public void setPoint2(Point3D point2) {
        this.point2 = point2;
    }

    public void setPoint3(Point3D point3) {
        this.point3 = point3;
    }

    public String toString(){
        return "Points: " + point1 + "," + point2 + "," + point3 + "\nequation: " + a + "x+" + b + "y+" + c + "z+" + d + "=0";
    }

}