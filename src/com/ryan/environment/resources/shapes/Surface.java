package com.ryan.environment.resources.shapes;

import com.ryan.components.Ray;
import com.ryan.components.Vector3D;
import com.ryan.environment.resources.HitDetection;

public class Surface extends Shape
{
    private Vector3D a;
    private Vector3D b;
    private Vector3D c;

    public Surface()
    {
        a = new Vector3D();
        b = new Vector3D();
        c = new Vector3D();
    }

    public Surface(Vector3D a, Vector3D b, Vector3D c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Vector3D getA()
    {
        return a;
    }

    public Vector3D getB()
    {
        return b;
    }

    public Vector3D getC()
    {
        return c;
    }

    public void setA(Vector3D a)
    {
        this.a = a;
    }

    public void setB(Vector3D b)
    {
        this.b = b;
    }

    public void setC(Vector3D c)
    {
        this.c = c;
    }

    //10.6
    @Override
    public HitDetection rayIntersect(Ray ray, double mag)
    {
        /*
        To determine a ray intersection with a triangle we have to...
            1. Determine if the ray intersects the plane that the triangle is on
            2. If it does, determine if the ray-plane intersection is within the triangle.

        given a ray p = e + t(d)
        and a plane (p - a) . n
         */
        return null;
    }
}
