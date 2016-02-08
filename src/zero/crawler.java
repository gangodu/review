package zero;

public interface crawler {

	/*
	 * Decides if more than one thread has to be used depengding on need
	 */
    public static final int singleCrawl 	= 	1;
    public static final int optimalCrawl 	= 	5;
    public static final int multiCrawl 		= 	10;

    /*
     * Maximum depth to crawl for a given domain in a particular crawl - period
     */
    public static final int maxdepthDomainCrawl		=	1;
    public static final int maxdepthURLFinderCrawl	=	4;
    public static final int maxdepthURLCrawl		=	2;
    
    
}
