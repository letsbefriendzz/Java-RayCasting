package com.ryan.shapes;

import com.ryan.Vector3D;

public class Surface
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
}
