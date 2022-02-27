package com.ryan;

import java.lang.constant.Constable;
import java.util.ArrayList;

public class ViewPort
{
    private int width;
    private int height;
    private ArrayList<ArrayList<Vector3D>> pixels;

    public ViewPort()
    {
        this.pixels = null;
    }

    // Construct a new screen with a vector to assign as the centre point of the screen.
    public ViewPort(int width, int height, Vector3D centrePoint)
    {
        this.pixels = new ArrayList<>();
        this.width = width;
        this.height = height;

        for (int x = 0; x < width; x++)
        {
            pixels.add(new ArrayList<Vector3D>());
            for(int y = 0; y < height; y++)
            {
                pixels.get(x).add(new Vector3D());
            }
        }
    }
}
