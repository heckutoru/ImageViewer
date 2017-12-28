/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewer;

import imageviewer.UI.imageDisplay;
import imageviewer.UI.swing.swingImageDisplay;
import imageviewer.control.Command;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Héctor Déniz Álvarez (Heckutoru)
 */
public class mainFrame extends JFrame{

    private imageDisplay imageDisplay;
    private Map<String, Command> commands = new HashMap<>();
    
    public mainFrame() {
        this.setTitle("Image viewer");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(image());
        this.add(toolbar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    public void add(Command command){
        commands.put(command.name(), command);
    }

    private Component image() {
        swingImageDisplay display = new swingImageDisplay();
        imageDisplay = display;
        return new swingImageDisplay();
    }

    public imageDisplay getImageDispaly() {
        return imageDisplay;
    }

    private Component toolbar() {
        JPanel panel = new JPanel();
        panel.add(button("prev"));
        panel.add(button("next"));
        return panel;
    }

    private Component button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(execute(name));
        return button;
    }

    private ActionListener execute(String name) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(name).execute();
            }
        };
    }
    
}
