/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renerskuska;

import java.awt.event.MouseEvent;
/**
 *
 * @author Ivan
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Drawer
{
    private GraphicObject createdObject;
    private Mode drawingMode;
    private Point startingPoint = null;
    protected ObjectTypes types;
    
    Drawer()
    {
        this.types = ObjectTypes.LINE;
        this.drawingMode = Mode.FREE;
    }
    
    protected GraphicObject executeDrag(MouseEvent e)
    {
        switch(drawingMode)
        {
            case FREE:
                startingPoint = new Point(e.getX(), e.getY());

                switch(types)
                {
                    case RECTANGLE:
                        createdObject = new MyRectangle(startingPoint);
                        break;
                    case LINE:
                        createdObject = new Line(startingPoint);
                        break;
                    default:
                        createdObject = new MyRectangle(startingPoint);
                        break;
                }

                drawingMode = Mode.SELECTED;
                break; 
                
            case SELECTED:
                
                createdObject.start.setX(startingPoint.getX());
                createdObject.start.setY(startingPoint.getY());
                
                
                updateGraphicsOffsets(new Point(e.getX(), e.getY()));
                break;

            case CLICKING:

        }

        return createdObject;

    }

    private void updateGraphicsOffsets(Point point)
    {
        createdObject.setOffsetX(point.getX());
        createdObject.setOffsetY(point.getY());
    }
    
    protected GraphicObject executeRelease()
    {
        this.startingPoint = null;
        this.drawingMode = Mode.FREE;
        return createdObject;
    }

    public ObjectTypes getTypes()
    {
        return types;
    }

    public void setTypes(ObjectTypes types)
    {
        this.types = types;
    }

    public Mode getDrawingMode()
    {
        return drawingMode;
    }

    public void setDrawingMode(Mode drawingMode)
    {
        this.drawingMode = drawingMode;
    }

}

