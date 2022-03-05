package com.ryan.environment.resources;

import com.ryan.components.Vector3D;
import com.ryan.environment.resources.shapes.Shape;

/*
Represents a detection of a ray hitting an object. Contains the
interval (t) that when subbed into the ray P(t) will result in
the intersection of the ray and the object, and the shape instance
that returned true in its rayIntersection function.
 */
public class HitDetection
{
    public Shape shape;
    public double t1;
    public double t2;
    public Vector3D hit1;
    public Vector3D hit2;

    public HitDetection(Shape s, double t1, double t2, Vector3D h1, Vector3D h2)
    {
        this.shape = s;
        this.t1 = t1;
        this.t2 = t2;
        this.hit1 = h1;
        this.hit2 = h2;
    }

    public void consoleDisplay()
    {
        this.shape.consoleDisplay();
        System.out.println();
        System.out.println("t1:\t" + t1);
        System.out.println("t2:\t" + t2);
        this.hit1.consoleDisplay();
        System.out.println();
        if(hit2 != null)
        {
            this.hit2.consoleDisplay();
            System.out.println();
        }
    }
}
