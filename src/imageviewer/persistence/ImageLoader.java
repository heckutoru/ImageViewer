/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.persistence;

import imageviewer.model.Image;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public interface ImageLoader {
    Image load();
}
