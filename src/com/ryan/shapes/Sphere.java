package com.ryan.shapes;
import com.ryan.Ray;
import com.ryan.Vector3D;

public class Sphere extends Shape
{
    // CENTRE POINT OF THE SPHERE
    private Vector3D c;
    // RADIUS OF THE SPHERE
    private double r;

    public Sphere()
    {
        c = new Vector3D();
        r = 5;
        this.type = Shape.SPHERE;
    }

    public Sphere(Vector3D c, double r)
    {
        this();
        this.c = c;
        this.r = r;
    }

    @Override
    public boolean rayIntersect(Ray ray, double render)
    {
        Vector3D d = ray.eval(render);
        Vector3D e = ray.getOrigin();
        Vector3D c = this.c;
        double R = this.r;

        // oh SHIT
        double dscrm = (Math.pow( d.dot(e.sub(c)), 2 ) - ( d.dot(d) * ( e.sub(c).dot( e.sub(c) ) ) - Math.pow(R, 2) ) );

        if(dscrm >= 0)
        {
            System.out.println(dscrm);
            return true;
        }
        else return false;
    }

    public Vector3D getC()
    {
        return c;
    }

    public double getR()
    {
        return r;
    }

    public void setC(Vector3D c)
    {
        this.c = c;
    }

    public void setR(double r)
    {
        this.r = r;
    }
}
