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

//            champion-stats-trend-rate

//            Element spells = doc.select("tbody:nth-child(3) > tr:nth-child(1) > td.champion-overview__data > ul > li:nth-child(1) > img").get(0);
//            System.out.println(spells);
//            System.out.println(spells.attr("title"));

//            Elements spells = doc.select("champion-stats__list__item");
//            System.out.println(spells);


//            Elements a = doc.select("tbody:nth-child(3) > tr:nth-child(1) > td.champion-overview__data > ul > li:nth-child(1) > img");
//            Element b = a.get(0);
//            System.out.println(b.attr("title"));

                }
            }
        }