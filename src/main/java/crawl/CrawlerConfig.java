package crawl;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Set;
import java.util.regex.Pattern;

public class CrawlerConfig extends WebCrawler {

    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|mp3|zip|gz))$");

    /**
     * This method receives two parameters. The first parameter is the page
     * in which we have discovered this new url and the second parameter is
     * the new url. You should implement this function to specify whether
     * the given url should be crawled or not (based on your crawling logic).
     * In this example, we are instructing the constants to ignore urls that
     * have css, js, git, ... extensions and to only accept urls that start
     * with "http://www.github.com/". in this case, we didn't need the
     * referringPage parameter to make the decision.
     */
    @Override
    public boolean shouldVisit(Page sourcePage, WebURL url) {
        String href = url.getURL().toLowerCase();
        return !FILTERS.matcher(href).matches();
    }

    /**
     * This function is called when a page is fetched and ready to be processed by your program.
     */
    @Override
    public void visit(Page page) {
        if (page.getParseData() instanceof HtmlParseData) {
            File file;
            PrintStream ps;
            FileOutputStream fos = null;

            HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
            Set<WebURL> links = htmlParseData.getOutgoingUrls();
            file = new File("data/harvested/crawled/crawlURL.txt");
            try {
                fos = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                System.out.println("File IO Error" + e.getMessage());
            }
            ps = new PrintStream(fos);
            int i = 0;
            while (i <= links.size()) {
                System.setOut(ps);
                i++;
            }
            System.out.print("URLs: \n" + links);
            ps.close();
        }
    }
}
