package com.ryan.shapes;
import com.ryan.Ray;
import com.ryan.Vector3D;

import java.lang.constant.Constable;

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
    public HitDetection rayIntersect(Ray ray, double render)
    {
        Vector3D d = ray.eval(render);
        Vector3D e = ray.getOrigin();
        Vector3D c = this.c;
        double R = this.r;

        // oh SHIT
        double dscrm = (Math.pow( d.dot(e.sub(c)), 2 ) - ( d.dot(d) * ( e.sub(c).dot( e.sub(c) ) ) - Math.pow(R, 2) ) );

        if(dscrm >= 0)
        {
            // this math may prove to be wrong later!
            double t1 = ( 0.0 - d.dot(e.sub(c)) + dscrm ) / d.dot(d);
            return new HitDetection( this, t1 );
        }

        return null;
    }

    @Override
    public void consoleDisplay()
    {
        System.out.println("Sphere");
        System.out.println("Radius:\t" + this.r);
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
