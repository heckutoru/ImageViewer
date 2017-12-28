/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer.persistence;

import imageviewer.model.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class FileImageLoader implements ImageLoader{

    private String[] extensions = new String[] {"jpg","png","bmp"};
    private final File[] files;

    public FileImageLoader(String folder) {
        this.files = new File(folder).listFiles(withImageExtension());
    }
    
    @Override
    public Image load() {
        return imageAt(0);
    }
    
    private Image imageAt(int index){
        return new Image() {
            @Override
            public byte[] bitmap() {
                try {
                    FileInputStream is = new FileInputStream(files[index]);
                    return read(is);
                } catch (IOException ex) {
                    return new byte[0];
                }
            }

            private byte[] read(FileInputStream is) throws IOException {
                byte[] buffer = new byte[4096];
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                while(true){
                    int length = is.read(buffer);
                    if(length < 0){
                        break;
                    }
                    os.write(buffer,0, length);
                }
                return os.toByteArray();
            }
            
            @Override
            public Image next() {
                return (index == files.length-1) ? imageAt(0) : imageAt(index+1);
            }

            @Override
            public Image prev() {
                return (index == 0) ? imageAt(files.length-1) : imageAt(index-1);
            }
        };
    }

    private FilenameFilter withImageExtension() {
        return new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                for (String extension : extensions) {
                    if(name.endsWith(extension)){
                        return true;
                    }
                }
                return false;
            }
        };
    }

}
