package com.ryan.display;

import com.ryan.render_engine.RasterOptions;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Display
{
    public JFrame frame;
    private JLabel label;

    public Display(RasterOptions rp)
    {
        frame = new JFrame();
        frame.setSize(rp.width, rp.height);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        label = new JLabel();
        frame.getContentPane().add(label, BorderLayout.CENTER);
    }

    public void setFrame(BufferedImage img)
    {
        if(!this.frame.isVisible())
            frame.setVisible(true);
        this.label.setIcon(new ImageIcon(img));
    }

    public void close()
    {
        this.frame.dispose();
    }
}
