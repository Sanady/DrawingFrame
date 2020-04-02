/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renerskuska;

import java.awt.*;
import java.awt.event.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
/**
 *
 * @author Ivan
 */
public class MyCanvas extends Canvas implements MouseListener, MouseMotionListener
{

    private Color objectColor = null;
    private Drawer drawer;
    private Set<GraphicObject> graphicObjects;

    public MyCanvas()
    {
        super();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        drawer = new Drawer();
        graphicObjects = new HashSet<>();

    }

    public void paint(Graphics g)
    {
        for (GraphicObject graphicObject : graphicObjects)
        {
            graphicObject.draw(g);
        }
    }


    public void setObjectColor(Color objectColor)
    {
        this.objectColor = objectColor;
    }


    public void clearObjects()
    {
        graphicObjects.clear();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e)
    {
        GraphicObject group = drawer.executeRelease();

        if(group != null)
        {
            group.setBorderColor(objectColor);
            this.repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e)
    {
        GraphicObject newObject = drawer.executeDrag(e);
        newObject.setBorderColor(objectColor);

        this.graphicObjects.add(newObject);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {}
    public Drawer getDrawer() { return drawer; }


}
