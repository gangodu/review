package zero;

public interface CrawlerConstants {
    /*
     * Allow more than one thread has to be used depending on need
     */
    int singleCrawl = 1;
    int optimalCrawl = 5;
    int multiCrawl = 10;

    /*
     * Maximum depth to crawlerConfig for a given domain in a particular crawlerConfig - period
     */
    int maxdepthDomainCrawl = 1;
    int maxdepthURLFinderCrawl = 4;
    int maxdepthURLCrawl = 2;
}
