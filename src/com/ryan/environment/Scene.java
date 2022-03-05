package com.ryan.environment;
import com.ryan.environment.resources.lights.Light;
import com.ryan.environment.resources.shapes.Shape;

import java.util.ArrayList;

public class Scene
{
    public ArrayList<Shape> shapes;
    public ArrayList<Light> lights;

    public Scene()
    {
        shapes = new ArrayList<>();
        lights = new ArrayList<>();
    }

    public void addShape(Shape s)
    {
        this.shapes.add(s);
    }

    public void addLight(Light l) { this.lights.add(l); }
}
