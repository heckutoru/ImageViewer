/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

import imageviewer.control.*;
import imageviewer.persistence.*;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        execute();
    }

    private static void execute() {
        ImageLoader imageLoader = new FileImageLoader(("C:\\Users\\hecku\\Pictures"));
        mainFrame mainframe = new mainFrame();
        mainframe.add(new NextImageCommand(mainframe.getImageDispaly()));
        mainframe.add(new PrevImageCommand(mainframe.getImageDispaly()));
        mainframe.getImageDispaly().display(imageLoader.load());
    }
    
}
