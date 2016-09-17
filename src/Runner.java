import image_data.ImageContainer;
import image_data.ImageCreator;
import image_data.ImageFormat;
import io.ImageFileManager;
import postscript.ImageToPostscriptConverter;
import transformation.point.PointTransformationManager;

import java.awt.*;
import java.io.IOException;

public class Runner {
    private static String path = "img/lena.bmp";

    public static void main(String[] args) {
        PointTransformationManager pointTranManager=new PointTransformationManager();
        ImageContainer pointImage;
        System.out.println("IO Start");
        try {

            //create image
            ImageCreator imageCreator = new ImageCreator();
            ImageContainer ic2;
            ic2 = imageCreator.createEmptyPNG("img/empty", 1000, 1000);
            ImageFileManager.saveForDisk(ic2);
            ic2 = imageCreator.createEmptyBMP("img/empty", 1000, 1000);
            ImageFileManager.saveForDisk(ic2);
            ImageContainer imageContainer = ImageFileManager.loadFromDisk(path);
            pointImage=pointTranManager.negative(imageContainer);
            pointImage.setFilePath(pointImage.getFilePath()+"_negative");
            ImageFileManager.saveForDisk(pointImage);
            imageContainer = ImageFileManager.loadFromDisk(path);
            pointImage=pointTranManager.greyScale(imageContainer);
            pointImage.setFilePath(pointImage.getFilePath()+"_grayScale");
            ImageFileManager.saveForDisk(pointImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
