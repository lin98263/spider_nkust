import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner;
public class nkust_spider {

    public static void main(String[] args) {

        String champion, lane;

        Scanner scanner = new Scanner(System.in);
        System.out.print("輸入欲查詢英雄:");
        champion = scanner.next();
        System.out.print("輸入欲查詢路線(top/jungle/mid/adc/support):");
        lane = scanner.next();

        try {
            Document doc = Jsoup.connect("https://www.op.gg/champion/" + champion + "/statistics/" + lane + "/build").get();
            String name  = doc.getElementsByClass("champion-stats-header-info__name").get(0).text();
            System.out.println(name);
            System.out.println("---------");

            String winrate = doc.getElementsByClass("champion-stats-trend-rate").get(0).text();
            System.out.println("勝率:" + winrate);

            String winraterank = doc.getElementsByClass("champion-stats-trend-rank").get(0).text();
            System.out.println("勝率排名:" + winraterank);
            System.out.println("---------");

            String pickrate = doc.getElementsByClass("champion-stats-trend-rate").get(1).text();
            System.out.println("選取率::" + pickrate);

            String pickraterank = doc.getElementsByClass("champion-stats-trend-rank").get(1).text();
            System.out.println("選取率排名:" + pickraterank);
            System.out.println("---------");

            String skills = doc.getElementsByClass("champion-stats__list__item").text();
            System.out.println("技能加點:" + skills);
            System.out.println("---------");

            Elements c = doc.select("tbody.tabItem.ChampionKeystoneRune-1 div.perk-page  div.perk-page__item.perk-page__item--active  div.perk-page__image >img");
            System.out.println("推薦符文:");
            for(int x = 0; x <= 5; x++) {
                Element d = c.get(x);
                System.out.println(d.attr("alt"));
                if (x != 5){
                    System.out.println("⇓");
                }
            }


        } catch (Exception e) {
            System.out.println("你是不是打錯字了?還是腦袋有問題?");
        }
    }
}
