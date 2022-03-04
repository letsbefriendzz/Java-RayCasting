package com.ryan.environment.resources.lights;

import com.ryan.components.Vector3D;

public class Light
{
    private Vector3D source;

    public Light()
    {
        source = new Vector3D();
    }

    public Light(Vector3D s)
    {
        this.source = s;
    }

    public Vector3D getSource()
    {
        return this.source;
    }

    public void setSource(Vector3D s)
    {
        this.source = s;
    }
}
