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
class ChoiceList extends Choice
{
    ChoiceList()
    {
        String[] colors = {"Red", "Green", "Black", "Blue", "Yellow"};
        for (String color : colors)
        {
            this.add(color);
        }
    }
}
