package classes;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;

public class Htmltofile implements Downloader {

    public void downloadHtmlToFile(final String url, final String file) {
        try{
            new FileOutputStream(file).getChannel().transferFrom(Channels.newChannel(new URL(url).openStream()), 0, Long.MAX_VALUE);  
        }
            catch (IOException ie) {
                System.out.println("IOException raised");
            }
        }
    }