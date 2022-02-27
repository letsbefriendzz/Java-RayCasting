package com.ryan;

import java.util.ArrayList;

public class Camera
{
    // the eye; fixed location in 3D space where rays are generated from
    // for each ray generated from a parallel camera, e is the origin point.
    private Vector3D e;
    // the target; the coordinates that the ray will trace to
    private Vector3D t;

    public Camera()
    {
        e = new Vector3D();
        t = null;
    }

    public void setE(Vector3D e)
    {
        this.e = e;
    }

    public void setT(Vector3D t)
    {
        this.t = t;
    }
}
