/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renerskuska;
import java.awt.Graphics;

/**
 *
 * @author Ivan
 */

public class Line extends GraphicObject
{
    private Point end;

    public Line(Point start)
    {
        super(start);
        this.end = new Point(start.getX(), start.getY());
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.drawLine(start.getX(), start.getY(), end.getX(), end.getY());
    }

    @Override
    public void setOffsetX(int pointX) {
        end.setX(pointX);
    }

    @Override
    public void setOffsetY(int pointY) {
        end.setY(pointY);
    }
    
}

