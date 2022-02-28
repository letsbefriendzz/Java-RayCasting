package com.ryan;

public class Main {

    public static void main(String[] args)
    {
        ViewPort vp =  new ViewPort(400,800, new Vector3D());
        Camera e = new Camera();
        e.setE(vp.getCentrePoint());
        e.consoleDisplay();
    }
}
