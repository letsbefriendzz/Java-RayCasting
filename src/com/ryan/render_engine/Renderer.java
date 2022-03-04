package com.ryan.render_engine;

import com.ryan.components.Ray;
import com.ryan.environment.Scene;
import com.ryan.environment.resources.HitDetection;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer
{
    public static void setPixel(BufferedImage img, HitDetection hd, int x, int y)
    {
        if(hd != null)
            img.setRGB(x, y, hd.shape.getRgb());
        else
            img.setRGB(x,y, RasterOptions.Colors.BLACK);
    }

    public static BufferedImage renderScene(Scene scene, ArrayList<ArrayList<Ray>> rays, RasterOptions raster)
    {
        /*input validation*/
        if(rays.size() != raster.height || rays.get(0).size() != raster.width)
        {
            System.out.println("Invalid Ray list : RasterOptions combo");
            return null;
        }

        int height = rays.size();
        int width = rays.get(0).size();

        BufferedImage img = new BufferedImage(raster.width, raster.height, BufferedImage.TYPE_INT_RGB);

        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                //for each ray that we have, we're iterating through each object to check if the ray intersects
                //this is super inefficient but I don't care
                HitDetection closestObject = null;
                for (int i = 0; i < scene.shapes.size(); i++)
                {
                    HitDetection hd = scene.shapes.get(i).rayIntersect( rays.get(y).get(x), raster.renderDistance );
                    if ( hd != null)
                    {
                        if(closestObject == null)
                            closestObject = hd;
                        else if (closestObject.interval > hd.interval)
                            closestObject = hd;
                    }
                }

                setPixel(img, closestObject, x, y);
            }
        }

        return img;
    }
}
