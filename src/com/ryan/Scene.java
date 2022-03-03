package com.ryan;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Scene
{
    // object array

    public Scene()
    {

    }

    // takes a pair; rays and the rays respective raster options instance
    // MUST BE IDENTICAL OR IT SHITS ITSELF
    public void evaluateRays(ArrayList<ArrayList<Ray>> rays, RasterOptions r)
    {
        /*input validation*/
        if(rays.size() != r.height || rays.get(0).size() != r.width)
        {
            System.out.println("Invalid Ray list : RasterOptions combo");
            return;
        }

        BufferedImage image = new BufferedImage(r.width, r.height, BufferedImage.TYPE_INT_RGB);
        ArrayList<ArrayList<Pixel>> pixels = new ArrayList<>();
        //might throw an exception if client code is a biatch and passes an empty arraylist
        int height = rays.size();
        int width = rays.get(0).size();

        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                if(rayCollision(rays.get(y).get(x)))
                {
                    image.setRGB(x, y, 256 << 16);
                }
                else
                {
                    image.setRGB(x, y, 32);
                }
            }
        }

        try
        {
            File of = new File("C:\\_retemp\\output.bmp");
            ImageIO.write(image, "bmp", of);
        }
        catch (IOException e) { System.out.println("Error writing file");}
    }

    public boolean rayCollision(Ray ray)
    {
        return false;
    }
}
