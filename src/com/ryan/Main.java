package com.ryan;

/*
NOTES

Camera class is probably redundant, it's literally just an origin point for all of the
rays in a perspective view
 */

public class Main {

    public static void main(String[] args)
    {
        int width = 4;
        int height = 4;

        // ideally, I want the centre of the ViewPort to be 0,0,0 but this is a little bit of a finicky sol
        // while subtracted width/2 and height/2 from 0 for our x,y origin points works, if we have an even
        // number for either of them we end up getting a slightly-offset-from-0 0 0 centre point. It's fine.
        // Just me being picky, but could cause issues in the future (?)
        PerspectiveViewPort vp =  new PerspectiveViewPort(width,height, new Vector3D(0-width/2, 0-height/2, 0));
        vp.zOffsetEye(5);

        //console display
        vp.consoleDisplay();
    }
}
