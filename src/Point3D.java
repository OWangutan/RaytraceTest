public class Point3D{
    private int x;
    private int y;
    private int z;
    public Point3D(int x ,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void setPosition(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double[] getXYZ() {
        double[] pos = {x,y,z};
        return pos;
    }
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public int getz(){
        return z;
    }
}