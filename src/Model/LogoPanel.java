package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Michał on 17.03.2016.
 */
public class LogoPanel extends JPanel {

    private BufferedImage logoImage;

    public LogoPanel(){

        setPreferredSize(new Dimension(30,30));

        File logoFile = new File("logoRent.png");

        try{
            logoImage = ImageIO.read(logoFile);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g){

        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(logoImage,0,0,this);


    }
}
