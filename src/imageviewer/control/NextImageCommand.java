/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.control;

import imageviewer.UI.imageDisplay;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class NextImageCommand implements Command{

    private final imageDisplay imageDisplay;

    public NextImageCommand(imageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public String name() {
        return "next";
    }

    @Override
    public void execute() {
        imageDisplay.display(imageDisplay.currentImage().next());
    }
    
}
