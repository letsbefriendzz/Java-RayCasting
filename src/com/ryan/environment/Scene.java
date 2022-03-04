package com.ryan.environment;
import com.ryan.environment.shapes.Shape;

import java.util.ArrayList;

public class Scene
{
    ArrayList<Shape> shapes;

    public Scene()
    {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape s)
    {
        this.shapes.add(s);
    }

    public ArrayList<Shape> getShapes()
    {
        return shapes;
    }
}
