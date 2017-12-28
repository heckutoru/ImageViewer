package imageviewer.UI.swing;

import imageviewer.model.*;
import javax.swing.JPanel;
import imageviewer.UI.imageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Graphics;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class swingImageDisplay  extends JPanel implements imageDisplay {
    
    private Image currentImage;

    public swingImageDisplay() {
        super(new BorderLayout());
    }
    
    @Override
    public void display(Image currentImage) {
        this.currentImage = currentImage;
        this.removeAll();
        this.add(imagePanel());
        this.updateUI();
    }

    private Component imagePanel() {
        return new JPanel(){
            @Override
            public void paint(Graphics g) {
                g.drawImage(bitmap(), 0, 0, this.getWidth(),this.getHeight(),null);
                
            }

            private java.awt.Image bitmap() {
                try {
                    return ImageIO.read(new ByteArrayInputStream(currentImage.bitmap()));
                } catch (IOException ex) {
                    return null;
                }
            }
        };
    }

    @Override
    public Image currentImage() {
        return currentImage;
    }
}
