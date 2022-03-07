package com.ryan.render_engine;

import com.ryan.components.Ray;
import com.ryan.components.Vector3D;

import java.util.ArrayList;

public class ViewPort
{
    static final double zOffset = 1;
    private Vector3D eye;
    private Vector3D[] vertices = new Vector3D[4];

    /*
    it's rewind time!

    so, we want a new ViewPort. convention is that we have the camera origin at (0,0,0), and that we have the
    viewport offset from the camera by one z unit. The viewport is a constant size square that is 2x2. We take
    our raster coordinates and cast them onto this 2x2 square, rather than constructing a large array of coordinates
    directly from raster space.

    first, we remap our raster coordinates to ndc (normalized device coordinate) space, which is just a fancy way
    of saying we normalize the coordinates between 0 and 1. this can be achieved by dividing our respective x and y
    coordinate by the width and height.

    if our aspect ratio isn't 1:1, we have to accommodate my multiplying the pixel x coordinates by the aspect ratio.
     */
    public ViewPort()
    {
        // eye is default (0,0,0)
        this.eye = new Vector3D();
        /*
        this isn't even used lol
        for(int i = 0; i < this.vertices.length; i++)
        {
            if (i==0)
                vertices[i] = new Vector3D(-1,1,zOffset);
            else if (i==1)
                vertices[1] = new Vector3D(-1,-1,zOffset);
            else if (i==2)
                vertices[i] = new Vector3D(1,-1,zOffset);
            else if (i==3)
                vertices[i] = new Vector3D(1,1,zOffset);
        }
        */
    }

    /*
    Generates rays and normalizes the direction, assuming our camera is at (0,0,0) and we
    generate the ViewPort frame at z + zOffset = 1
     */
    public ArrayList<ArrayList<Ray>> generateRays(RasterOptions r, Vector3D transform_coordinates)
    {
        ArrayList<ArrayList<Ray>> rays = new ArrayList<>();

        double w = r.width;
        double h = r.height;
        double asp = w/h;

        for (int y = 0; y < r.height; y++)
        {
            rays.add(new ArrayList<>());

            for(int x = 0; x < r.width; x++)
            {
                // puts the coordinates into 0 -> 1 space
                double Px = (x + 0.5) / r.width;
                double Py = (y + 0.5) / r.height;

                // converts 0-1 space to -1 -> 1 space
                Px = (2*Px)-1;
                Py = (2*Py)-1;

                // stretches the x coordinates to the appropriate aspect ratio;
                // assumes a horizontal image, not a vertical image
                // vertical images are for losers
                Px = Px * asp; // accommodate for aspect ratio

                rays.get(y).add(new Ray(eye, new Vector3D(Px, Py, zOffset)).transform( transform_coordinates ));
            }
        }

        return rays;
    }

    public Vector3D getEye()
    {
        return eye;
    }

    public boolean transformEye( Vector3D t )
    {
        this.eye = this.eye.add(t);
        return true;
    }
}