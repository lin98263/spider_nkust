import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class plus {
    public static void main(String[] args) {
        for(int x = 1; x<=157; x++) {
            try {
                Document doc = Jsoup.connect("https://www.op.gg/champion/").get();

                String name = doc.select("body > div.l-wrap.l-wrap--champion > div.l-container > div.l-champion-index > div.l-champion-index-content > div.l-champion-index-content--main > div.champion-index__champion-list > div:nth-child(" + x + " ) > a > div.champion-index__champion-item__name").text();
                System.out.println(name);
                String lane = doc.select("body > div.l-wrap.l-wrap--champion > div.l-container > div.l-champion-index > div.l-champion-index-content > div.l-champion-index-content--main > div.champion-index__champion-list > div:nth-child(" + x + ") > a > div.champion-index__champion-item__positions > div > span").text();
                System.out.println(lane);
                Elements a = doc.select("body > div.l-wrap.l-wrap--champion > div.l-container > div.l-champion-index > div.l-champion-index-content > div.l-champion-index-content--main > div.champion-index__champion-list > div:nth-child(" + x + ") > a");
                Element b = a.get(0);
                Document doc2 = Jsoup.connect(b.absUrl("href")).get();
                String winrate = doc2.getElementsByClass("champion-stats-trend-rate").get(0).text();
                System.out.println("勝率:" + winrate);
            } catch (Exception e) {
                System.out.println("RIP");
            }
        }
    }
}
//body > div.l-wrap.l-wrap--champion > div.l-container > div.l-champion-index > div.l-champion-index-content > div.l-champion-index-content--main > div.champion-index__champion-list > div:nth-child("+ x +") > a