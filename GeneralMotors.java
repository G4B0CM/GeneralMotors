import java.awt.*;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.swing.*;

public class GeneralMotors extends JFrame{
    public static String titulo = "";
    public static double price = 0;
    public static String[] tabla;

    public GeneralMotors(String html){
        tabla  = new String[16];
        webScraping(html);
    }
    public void webScraping(String html) {
        int i=0;
        try {
            Document doc = Jsoup.connect(html).get();
            titulo = doc.getElementsByClass("car-specifics__name").text();
            Elements precio = doc.getElementsByClass("car-specifics__price");
            this.price = Double.parseDouble(precio.first().getElementsByTag("strong").text()
                    .replace('u',' ').replace('$',' ')
                    .replace('s',' ').trim());
            Elements parrafos = doc.getElementsByClass("table");
            Elements subParrafo = parrafos.first().getElementsByTag("td");
            for (Element e : subParrafo) {
                tabla[i]= e.text();
                i++;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
