import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Main {

    public static void main(String[] args) throws Exception {
        for (int i = 400; i <= 400; i++) {
            String currentURL = "http://www.studentlibrary.ru/cgi-bin/mb4?hide_Cookie=yes&usr_data=gd-image(doc,ISBN9785437200490-SCN0011,0$number.pdf,-1,,00000000,39013353e215348c7b7f531501)";
            String replaceURL = currentURL.replace("$number", Integer.toString(i));
            loadOneFile(replaceURL, i);
            System.out.println(i + "document has been loaded");
            if (i % 10 == 0)
                Thread.sleep(2000);
        }
    }

    public static void loadOneFile(String urlToLoad, int i) throws Exception {
        URL loadBookUrl = new URL(urlToLoad);
        ReadableByteChannel rbc = Channels.newChannel(loadBookUrl
                .openStream());
        FileOutputStream fos = new FileOutputStream("result/" + i + ".pdf");

        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        System.out.println(urlToLoad);
        fos.close();
        rbc.close();
    }
}