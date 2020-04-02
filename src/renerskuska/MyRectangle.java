/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renerskuska;

import java.awt.*;
/**
 *
 * @author Ivan
 */
public class MyRectangle extends Shape
{

    private int a;
    private int b;

    public MyRectangle(Point start)
    {
        super(start);
    }

    @Override
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(start.getX(), start.getY(), a, b);
    }

    @Override
    public void fill(Graphics g)
    {
        g.setColor(fillColor);
        g.fillRect(start.getX(), start.getY(), a, b);
    }


    public void setA(int a)
    {
        this.a = a;
    }


    public void setB(int b)
    {
        this.b = b;
    }


    @Override
    public void setOffsetX(int pointX)
    {
        if(pointX < start.getX())
        {
            setA(start.getX() - pointX);
            start.setX(pointX);
        }
        else
        {
            setA(pointX - start.getX());
        }

    }

    @Override
    public void setOffsetY(int pointY)
    {
        if(pointY < start.getY())
        {
            setB(start.getY() - pointY);
            start.setY(pointY);
        }
        else
        {
          setB(pointY - start.getY());
        }

    }

    protected int getA()
    {
        return this.a;
    }

    protected int getB()
    {
        return this.b;
    }
}

