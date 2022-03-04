package com.ryan.environment.resources.lights;

import com.ryan.components.Ray;
import com.ryan.components.Vector3D;

public class DirectionalLight extends Light
{
    private Vector3D direction;

    public DirectionalLight(Vector3D origin, Vector3D direction)
    {
        super(origin);
        this.direction = direction.getNormalized();
    }

    public Vector3D getDirection()
    {
        return this.direction;
    }

    public Ray getRay()
    {
        return new Ray( this.getSource(), this.getDirection() );
    }
}
