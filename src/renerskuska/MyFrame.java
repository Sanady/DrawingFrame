/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renerskuska;

import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Ivan
 */
public class MyFrame extends Frame implements ActionListener, ItemListener
{

    private DrawLineButton drawLineButton;
    private DrawRectangleButton drawRectangleButton;
    private ClickOnAnObjectButton clickOnAnObjectButton;
    private ClearCanvasButton clearCanvasButton;
    private MyCanvas myCanvas;
    private ChoiceList choiceList;

    MyFrame()
    {
        super("OOP Skuska");
        drawLineButton = new DrawLineButton();
        drawRectangleButton = new DrawRectangleButton();
        clickOnAnObjectButton = new ClickOnAnObjectButton();
        clearCanvasButton = new ClearCanvasButton();
        Panel buttonPanel = new Panel();
        Panel choiceListPanel = new Panel();
        Panel mainPanel = new Panel();
        mainPanel.setLayout(new GridLayout(1, 2));

        Label choiceLabel = new Label("Choose a color for your object: ");

        drawRectangleButton.addActionListener(this);
        drawLineButton.addActionListener(this);
        clickOnAnObjectButton.addActionListener(this);
        clearCanvasButton.addActionListener(this);

        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.add(drawLineButton);
        buttonPanel.add(drawRectangleButton);
        buttonPanel.add(clickOnAnObjectButton);
        buttonPanel.add(clearCanvasButton);


        choiceList = new ChoiceList();
        choiceList.addItemListener(this);
        choiceListPanel.add("North", choiceLabel);
        choiceListPanel.add(choiceList);

        myCanvas = new MyCanvas();

        addWindowListener(new Closer());
        setLayout(new BorderLayout());

        mainPanel.add(buttonPanel);
        mainPanel.add(choiceListPanel);

       add(mainPanel, BorderLayout.NORTH);
       add(myCanvas, BorderLayout.CENTER);

       setSize(800, 800);
       setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == drawRectangleButton)
        {
            myCanvas.getDrawer().types = ObjectTypes.RECTANGLE;
        }
        else if(e.getSource() == drawLineButton)
        {
            myCanvas.getDrawer().types = ObjectTypes.LINE;
        }
        else if(e.getSource() == clickOnAnObjectButton)
        {
            myCanvas.getDrawer().setDrawingMode(Mode.CLICKING);
        }
        else if(e.getSource() == clearCanvasButton)
        {
            myCanvas.setObjectColor(getBackground());
            myCanvas.getGraphics().clearRect(0, 0, getWidth(), getHeight());
            myCanvas.clearObjects();
            myCanvas.getDrawer().setDrawingMode(Mode.FREE);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource() == choiceList)
        {
            switch (choiceList.getSelectedIndex())
            {
                case 0:
                    myCanvas.setObjectColor(Color.red);
                    break;
                case 1:
                    myCanvas.setObjectColor(Color.green);
                    break;
                case 2:
                    myCanvas.setObjectColor(Color.black);
                    break;
                case 3:
                    myCanvas.setObjectColor(Color.blue);
                    break;
                case 4:
                    myCanvas.setObjectColor(Color.yellow);
                    break;
            }
        }

    }

}

