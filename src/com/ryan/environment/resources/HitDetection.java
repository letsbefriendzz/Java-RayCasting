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
    public double t;
    public Vector3D normal;

    public HitDetection(Shape s, double t, Vector3D normal)
    {
        this.shape = s;
        this.t = t;
        this.normal = normal;
    }
}
