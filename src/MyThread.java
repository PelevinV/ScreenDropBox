import com.dropbox.core.v2.DbxClientV2;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    private BufferedImage image;
    private DbxClientV2 client;

    public MyThread(BufferedImage image, DbxClientV2 client) {
        this.image = image;
        this.client = client;
    }
    @Override
    public void run() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "png", byteArrayOutputStream);
            InputStream inputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date now = new Date();
            String fileName = String.format(dateFormat.format(now));

            client.files().uploadBuilder("/"+fileName+".png")
                    .uploadAndFinish(inputStream);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}