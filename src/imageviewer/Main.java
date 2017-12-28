
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
        mainFrame mainframe0 = new mainFrame();
        mainframe0.add(new NextImageCommand(mainframe0.getImageDispaly()));
        mainframe0.add(new PrevImageCommand(mainframe0.getImageDispaly()));
        mainframe0.getImageDispaly().display(imageLoader.load());
    }
    
}