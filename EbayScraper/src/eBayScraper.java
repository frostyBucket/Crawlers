import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class eBayScraper {
    public static void main(String[] args) throws IOException {
        String url = "https://ebay.com/deals/tech";
        ArrayList<String> lines= new ArrayList<>();
        try {
            Document document = Jsoup.connect(url).get();
            Elements products = document.getElementsByClass("dne-itemtile-title ellipse-2");
            Elements prices = document.getElementsByClass("first");

            for(int i = 0; i < products.size(); i++){
                System.out.println("Product: "+products.get(i).text());
                lines.add(products.get(i).text());
                lines.add(prices.get(i+1).text());
                System.out.println("Price: "+prices.get(i+1).text());

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //Path file = Paths.get("src/middleman.txt");
        try(PrintWriter writer = new PrintWriter("src/middleman.txt")){
            for(String line:lines){
                writer.println(line);
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }

    }
}