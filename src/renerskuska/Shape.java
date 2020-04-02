/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renerskuska;

import java.awt.Color;
import java.awt.Graphics;
/**
 *
 * @author Ivan
 */
public abstract class Shape extends GraphicObject
{
    
    Color fillColor;

    public Shape(Point start) {
        super(start);
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }
    
    abstract public void fill(Graphics g);
}
