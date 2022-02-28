package com.ryan;

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
    public ViewPort(int width, int height, Vector3D startCoordinate)
    {
        this.pixels = new ArrayList<>();
        this.width = width;
        this.height = height;

        for (int x = 0; x < width; x++)
        {
            pixels.add(new ArrayList<Vector3D>());
            for(int y = 0; y < height; y++)
            {
                pixels.get(x).add(new Vector3D(startCoordinate.getX() + x, startCoordinate.getY() + y, startCoordinate.getZ()));
            }
        }
    }

    // kind of a muddy method of getting a centre point but it works
    // i'd want something more scalable but there are really only
    // four cases for this function, may as well hardcode them all /shrug
    public Vector3D getCentrePoint()
    {
        // if we have odd # of pixels, we can get a definite centre pixel
        if(Math.round(this.width/2) != this.width / 2.0 && Math.round(this.height/2) != this.height / 2.0)
        {
            return pixels.get(this.width/2).get(this.height/2);
        }
        // otherwise, we need to calculate the centre based on offset between pixel
        else if(Math.round(this.width/2) != this.width/2.0)
        {
            int x = this.width/2;
            int y = this.height/2;

            Vector3D mid1 = pixels.get(x).get(y-1);
            Vector3D mid2 = pixels.get(x).get(y);

            Vector3D avg = mid1.avg(mid2);

            return avg;
        }
        else if(Math.round(this.height/2) != this.height/2.0)
        {
            int x = this.width/2;
            int y = this.height/2;

            Vector3D mid1 = pixels.get(x-1).get(y);
            Vector3D mid2 = pixels.get(x).get(y);

            Vector3D avg = mid1.avg(mid2);

            return avg;
        }
        // both width and height are even numbers
        // take the average of two diagonally offset pixels from the four centre pixels
        // this results in the on-axis centre point, i.e. crosshair style centre
        else
        {
            int x = this.width/2;
            int y = this.height/2;

            Vector3D mid1 = pixels.get(x-1).get(y);
            Vector3D mid2 = pixels.get(x).get(y-1);

            Vector3D avg = mid1.avg(mid2);

            return avg;
        }
    }

    public void consoleDisplay()
    {
        for(int x = 0; x < width; x++)
        {
            for (int y = 0; y < height; y++)
            {
                pixels.get(x).get(y).consoleDisplay();
            }
            System.out.println();
        }
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public Vector3D getPixel(int x, int y)
    {
        return pixels.get(x).get(y);
    }
}
