package com.ryan.shapes;

import com.ryan.components.Ray;

public class Shape
{
    public static String SPHERE = "Sphere";
    public static String SQUARE = "Square";
    public static String CUBE   = "Cube";
    public static String NULL   = "NULL";

    public final static int RED       = (255<<16)|(0<<8)|(0);
    public final static int YELLOW    = (250<<16)|(253<<8)|(15);
    public final static int GREEN     = (0<<16)|(255<<8)|(0);
    public final static int BLUE      = (0<<16)|(0<<8)|(255);
    public final static int ORANGE    = (255<<16)|(140<<8)|(0);
    public final static int WHITE     = (255<<16)|(255<<8)|(255);
    public final static int BLACK     = (0<<16)|(0<<8)|(0);

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
