/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nusantarafood;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import net.coobird.thumbnailator.Thumbnails;

/**
 *
 * @author User
 */
public class RequestImage {
    public static BufferedImage requesting(String resource, int x, int y){
        BufferedImage thumbnail = null;
//        Image img = null;
        try {
            File f = new File(resource);
            thumbnail = Thumbnails.of(f).size(x, y).asBufferedImage();
//            BufferedImage thumbnail = Thumbnails.of(f).size(x, y).asBufferedImage();
//            img = thumbnail;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//        return img;
        return thumbnail;
    }
}
