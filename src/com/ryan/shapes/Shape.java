package com.ryan.shapes;

import com.ryan.Ray;
import com.ryan.Vector3D;

public class Shape
{
    public static String SPHERE = "Sphere";
    public static String SQUARE = "Square";
    public static String CUBE   = "Cube";
    public static String NULL   = "NULL";
    protected String type;

    public Shape()
    {
        this.type = Shape.NULL;
    }

    public boolean rayIntersect(Ray ray, double mag)
    {
        return false;
    }
}
