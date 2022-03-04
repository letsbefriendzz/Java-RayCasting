package com.ryan.environment.resources;

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
    public double interval;

    public HitDetection(Shape s, double i)
    {
        this.shape = s;
        this.interval = i;
    }
}
