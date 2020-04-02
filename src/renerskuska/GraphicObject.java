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
public abstract class GraphicObject
{
    
    protected Point start;
    protected Color color;

    public GraphicObject(Point start) {
        this.start = new Point(start.getX(), start.getY());
    }

    public void setBorderColor(Color color) {
        this.color = color;
    }
    
    abstract public void draw(Graphics g);
    abstract public void setOffsetX(int pointX);
    abstract public void setOffsetY(int pointY);
}
