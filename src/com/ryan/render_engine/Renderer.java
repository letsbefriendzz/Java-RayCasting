package com.ryan.render_engine;

import com.ryan.components.Ray;
import com.ryan.components.Vector3D;
import com.ryan.environment.Scene;
import com.ryan.environment.resources.HitDetection;
import com.ryan.environment.resources.shapes.Sphere;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Renderer
{
    public static void setPixel(BufferedImage img, int rgb, int x, int y)
    {
        img.setRGB(x, y, rgb);
    }

    public static BufferedImage renderScene(Scene scene, ArrayList<ArrayList<Ray>> rays, RasterOptions raster)
    {
        /* input validation */
        if(rays.size() != raster.height || rays.get(0).size() != raster.width)
        {
            System.out.println("Invalid Ray list : RasterOptions combo");
            return null;
        }

        int height = rays.size();
        int width = rays.get(0).size();

        BufferedImage img = new BufferedImage(raster.width, raster.height, BufferedImage.TYPE_INT_RGB);

        // iterate over xy coordinates of image
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                // create HitDetection for closest detected object
                HitDetection closestObject = null;
                // iterate over the scene shapes
                for (int i = 0; i < scene.shapes.size(); i++)
                {
                    // attempt to create a HitDetection for that object -- if it returns null, do nothing
                    HitDetection hd = scene.shapes.get(i).rayIntersect( rays.get(y).get(x), raster.renderScale);
                    if ( hd != null )
                    {
                        // what the fuck is this shit
                        if(closestObject == null)
                            closestObject = hd;
                        else if (closestObject.t1 > hd.t1)
                            closestObject = hd;
                    }
                }

                // set default colour (that is, skybox) to black
                int colour = RasterOptions.Colors.BLACK;
                // if there is a ray-object intersection, shade that bitch
                if(closestObject != null)
                {
                    // <test>

                    // </test>

                    for (int l = 0; l < scene.lights.size(); l++)
                    {
                        colour = scene.lights.get(l).shade( closestObject );
                    }
                }
                setPixel(img, colour, x, y);
            }
        }

        return img;
    }

    public static BufferedImage inflateImage(BufferedImage img, int magnitude)
    {
        BufferedImage rtrn_img = new BufferedImage( img.getWidth() * magnitude, img.getHeight() * magnitude, BufferedImage.TYPE_INT_RGB );

        for(int y = 0; y < rtrn_img.getHeight(); y++)
        {
            for(int x = 0; x < rtrn_img.getWidth(); x++)
            {
                setPixel( rtrn_img, img.getRGB(x/magnitude,y/magnitude), x, y );
            }
        }

        return rtrn_img;
    }
}
