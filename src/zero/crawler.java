package zero;

public interface crawler {

	/*
	 * Decides if more than one thread has to be used depengding on need
	 */
	int singleCrawl 	= 	1;
    int optimalCrawl 	= 	5;
    int multiCrawl 		= 	10;

    /*
     * Maximum depth to crawl for a given domain in a particular crawl - period
     */
    int maxdepthDomainCrawl		=	1;
    int maxdepthURLFinderCrawl	=	4;
    int maxdepthURLCrawl		=	2;
    
    
}
