package com.ryan;
import com.ryan.shapes.Shape;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Scene
{
    ArrayList<Shape> shapes;

    public Scene()
    {
        shapes = new ArrayList<>();
    }

    public boolean addShape(Shape s)
    {
        this.shapes.add(s);
        return true;
    }

    public ArrayList<Shape> getShapes()
    {
        return shapes;
    }
}
