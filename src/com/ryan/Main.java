package com.ryan;

import com.ryan.components.Matrix33;
import com.ryan.display.Display;
import com.ryan.environment.resources.lights.Light;
import com.ryan.environment.resources.lights.PointLight;
import com.ryan.environment.resources.shapes.Shape;
import com.ryan.render_engine.RasterOptions;
import com.ryan.components.Vector3D;
import com.ryan.environment.Scene;
import com.ryan.environment.resources.shapes.Sphere;
import com.ryan.render_engine.Renderer;
import com.ryan.render_engine.ViewPort;

import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;

public class Main
{
    public static void main(String[] args)
    {
        int width   = 1280;
        int height  = 720;

        Vector3D camera     = new Vector3D(0,0,0);

        Scene s             = new Scene();
        RasterOptions rp    = new RasterOptions(width,height);
        ViewPort vp         = new ViewPort();
        Display d           = new Display(rp);

        // add shapes
        s.addShape( new Sphere( new Vector3D( 0, -2, 4 ),0.2 ) );

        s.addShape( new Sphere( new Vector3D( 2, 0, 6 ), 1, RasterOptions.Colors.Vaporwave.YELLOW ) );

        s.addShape( new Sphere( new Vector3D( -8, 4, 18 ), 2, RasterOptions.Colors.Vaporwave.PURPLE ) );

        s.addShape( new Sphere( new Vector3D( -16, -6, 14 ), 0.4, RasterOptions.Colors.Vaporwave.BLUE ) );

        // add a light
        s.addLight( new Light());

        while(true)
        {
            BufferedImage img = Renderer.renderScene(s, vp.generateRays(rp, camera) , rp);
            camera = camera.add(new Vector3D(0,0,0.01));
            camera = Matrix33.xRotationMatrix(0.1).multiply( camera );
            camera = Matrix33.yRotationMatrix(0.1).multiply( camera );
            d.setFrame(img);
        }
    }
}

