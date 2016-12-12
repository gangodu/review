package reviewCrawler;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import zero.crawler;

public class store {

	public store() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Implements a class which specifies the
	 * seed files to crawl,
	 * location to store "uncleaned" crawled data and
	 * the number of concurrent threads
	 *
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		
		String seed = "data/seeder";
		String crawling = "data/store/crawling"; // Input to crawled folder
        String crawled = "data/store/crawled";  // Input to clean.java and cleaned folder
        
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawling);
        /*
         * Used to find categories of a particular domain
         * Can be modified to find urls be increasing the depth
         */
        config.setMaxDepthOfCrawling(crawler.maxdepthDomainCrawl);
        
        /*
         * Instantiate the controller for this crawl.
         */
        
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawl, add seed urls manually to the controller. These are the first
         * URLs that are fetched and then the crawler starts following links
         * which are found in these pages
         */
        controller.addSeed("http://www.ebay.com");
        
        //controller.addSeed("http://rrminerals.com");
        //controller.addSeed("http://shareportt.com/");

        /*
         * Start the crawl. This is a blocking operation, meaning that your code
         * will reach the line after this only when crawling is finished.
         */
        //controller.start(reviewCrawler.crawl.class, crawl.singleCrawl);
        controller.startNonBlocking(crawl.class, crawler.multiCrawl);
    }
}
