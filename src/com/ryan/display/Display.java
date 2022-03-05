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
        frame.setVisible(true);
    }

    public void setFrame(BufferedImage img)
    {
        this.label.setIcon(new ImageIcon(img));
    }
}
