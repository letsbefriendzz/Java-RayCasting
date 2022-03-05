package com.ryan.environment.resources.shapes;
import com.ryan.components.Ray;
import com.ryan.environment.resources.HitDetection;

/*
The parent class of all shapes that can be used in 3D space.
 */
public class Shape
{
    public static String SPHERE = "Sphere";
    public static String SQUARE = "Square";
    public static String CUBE   = "Cube";
    public static String NULL   = "NULL";
    public static String SURFACE    = "Surface";
    public static String TRIANGLE   = "Surface";

    protected String type;
    protected int rgb;

    public Shape()
    {
        this.type = Shape.NULL;
    }

    public HitDetection rayIntersect(Ray ray, double mag)
    {
        return null;
    }

    public void consoleDisplay()
    {
        System.out.println("Abstract Shape");
    }

    public int getRgb()
    {
        return this.rgb;
    }

    public void setRgb(int rgb)
    {
        this.rgb = rgb;
    }
}
