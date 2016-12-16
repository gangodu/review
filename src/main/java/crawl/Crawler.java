package crawl;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import zero.CrawlerConstants;

public class Crawler {

    /*
    @param args Takes Top_Level_Domain as input
    @throws Exception Throws Non-Blocking IO Error if threads not available currently
    */
    public static void main(String[] args) throws Exception {

        // Input to crawled folder
        String crawling = "data/harvested/crawling";

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawling);

        // Instantiate the controller for this crawlerConfig.
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        /*
         * For each crawlerConfig, add seed urls manually to the controller.
         * This is the top-level domain first fetched; Crawler starts following links downloaded from the domain
         */
        controller.addSeed("http://www.apple.com");

        // Discover URLs for categories, increase DepthOfCrawl
        config.setMaxDepthOfCrawling(CrawlerConstants.maxdepthDomainCrawl);

        /*
         * This is the number of concurrent threads. Edit the threads in 'zero.constants' class
         */
        controller.startNonBlocking(CrawlerConfig.class, CrawlerConstants.multiCrawl);
    }
}
