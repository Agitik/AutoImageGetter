import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageGetter {
    private static int count;
    public static void main(String[] args) {
        while (true){
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = null;
            try {
                capture = new Robot().createScreenCapture(screenRect);
            } catch (AWTException e) {
                System.out.println("Ошибка в ходе исполнения метода");
            }
            try {
                ImageIO.write(capture, "png", new File("Screen" + count + ".png"));
            } catch (IOException e) {
                System.out.println("Не смог создать файл!");
            }
            System.out.println("Скриншот создан!");
            try {
                Thread.sleep(180000);
            } catch (InterruptedException e) {
                System.out.println("Ошибка в ходе ожидания программы");
            }
            count ++;
        }
    }
}
