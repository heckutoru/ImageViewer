/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.model;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public interface Image {
    
    byte[] bitmap();
    Image next();
    Image prev();
}
