
package com.raven.main;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;


public class RoundedBorder extends AbstractBorder {
    private int cornerRadius;

    public RoundedBorder(int cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2d = (Graphics2D) g.create();
        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(x, y, width - 1, height - 1, cornerRadius, cornerRadius);
        g2d.draw(roundedRectangle);
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(cornerRadius, cornerRadius, cornerRadius, cornerRadius);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.left = insets.top = insets.right = insets.bottom = cornerRadius;
        return insets;
    }
}