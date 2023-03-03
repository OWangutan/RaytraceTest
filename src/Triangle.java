public class Triangle extends Object3D{
    private Point3D pointA;
    private Point3D pointB;
    private Point3D pointC;

    // Plane equation: ax + by + cz + d = 0
    //R(t) = (1-t)C + tP
    private double a;
    private double b;
    private double c;
    private double d;
    public Triangle(Point3D pointA, Point3D pointB, Point3D pointC){
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        updateEquation();
    }

    public boolean hit(Ray ray){
        double xR = ray.getDirection().getx();
        double yR = ray.getDirection().gety();
        double zR = ray.getDirection().getz();
        double t = (a*xR + b*yR + c*zR)/-d;
        double xI = (xR - ray.getOrigin().getx())*t;
        double yI = (yR - ray.getOrigin().gety())*t;
        double zI = (zR - ray.getOrigin().getz())*t;
        double[][] gaussian = new double[][]{   {pointA.getx(),pointB.getx(),pointC.getx(),xI},
                                                {pointA.gety(),pointB.gety(),pointC.gety(),yI},
                                                {pointA.getz(),pointB.getz(),pointC.getz(),zI}};
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
          //System.out.println(gaussian[i][3]);
            if(gaussian[i][3] < 0){
                return false;
            }
        }
        return true;
    }
   
  private void updateEquation(){
       Vector3D vectorAB = new Vector3D(pointA.getx() - pointB.getx(),pointA.gety() - pointB.gety(),pointA.getz() - pointB.getz());
        Vector3D vectorBC = new Vector3D(pointA.getx() - pointC.getx(),pointA.gety() - pointC.gety(),pointA.getz() - pointC.getz());
        Vector3D normal = new Vector3D(vectorAB.crossProduct(vectorBC));
        a = normal.getx();
        b = normal.gety();
        c = normal.getz();
        d = -(normal.getx() * pointA.getx()) - (normal.gety() * pointB.gety()) - (normal.getz() * pointC.getz());                   
    }
  
    public Point3D getPointA() {
        return pointA;
    }

    public Point3D getPointB() {
        return pointB;
    }

    public Point3D getPointC() {
        return pointC;
    }

    public void setPoint1(Point3D pointA) {
        this.pointA = pointA;
        updateEquation();
    }

    public void setPoint2(Point3D pointB) {
        this.pointB = pointB;
        updateEquation();
    }

    public void setPoint3(Point3D pointC) {
        this.pointC = pointC;
        updateEquation();
    }

    public String toString(){
        return "Points: " + pointA + "," + pointB + "," + pointC + "\nequation: " + a + "x+" + b + "y+" + c + "z+" + d + "=0";
    }

}