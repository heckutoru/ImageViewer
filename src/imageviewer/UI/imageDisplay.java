package imageviewer.UI;


import imageviewer.model.Image;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public interface imageDisplay {
    
    void display(Image currentImage);
    Image currentImage();
    
}
