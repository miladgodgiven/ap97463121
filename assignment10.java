import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class assignment10 {
    public static void main(String[] args) throws IOException {

        Scanner scan =new Scanner(System.in);

        System.out.println("ENTER LINK WITH THIS FORMAT ( _https://....) :");
        String url=scan.nextLine();

        System.out.println("ENTER LOCATION TO SAVE :");
        String location=scan.nextLine();

        System.out.println("ENTER NAME OF FILE :");
        String name=scan.nextLine();

        BufferedInputStream inputStream = new BufferedInputStream(new URL(url.substring(1)).openStream());
        FileOutputStream fileOS = new FileOutputStream(location+name+".html");
        byte data[] = new byte[1024];
        int byteContent;
        while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
            fileOS.write(data, 0, byteContent);
        }

        // handles IO exceptions
    }
}
