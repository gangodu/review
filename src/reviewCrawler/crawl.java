package reviewCrawler;

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

public class crawl extends WebCrawler {
	
	private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|gif|jpg" + "|png|mp3|mp3|zip|gz))$");
	
	public crawl() {
		// TODO Auto-generated constructor stub
	}

/*	public class store {
		DB db = new DB();
	 
		public void main(String[] args) throws SQLException, IOException {
			db.runmySql("TRUNCATE Record;");
			processPage("http://www.mit.edu");
		}
	 
		public void processPage(String URL) throws SQLException, IOException{
			//check if the given URL is already in database
			String sql = "select * from Record where URL = '"+URL+"'";
			ResultSet rs = db.runSql(sql);
			if(rs.next()){
	 
			}else{
				//store the URL to database to avoid parsing again
				sql = "INSERT INTO  `Crawler`.`Record` " + "(`URL`) VALUES " + "(?);";
				PreparedStatement stmt = db.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				stmt.setString(1, URL);
				stmt.execute();
	 

			}
		}
	}
	*/
	/**
     * This method receives two parameters. The first parameter is the page
     * in which we have discovered this new url and the second parameter is
     * the new url. You should implement this function to specify whether
     * the given url should be crawled or not (based on your crawling logic).
     * In this example, we are instructing the crawler to ignore urls that
     * have css, js, git, ... extensions and to only accept urls that start
     * with "http://www.ics.uci.edu/". In this case, we didn't need the
     * referringPage parameter to make the decision.
     */
     @Override
     public boolean shouldVisit(Page sourcePage, WebURL url) {
         String href = url.getURL().toLowerCase();
         return !FILTERS.matcher(href).matches();
            //    && href.startsWith("http://shareportt.com/");
     }

     /**
      * This function is called when a page is fetched and ready
      * to be processed by your program.
      */
     @Override
     public void visit(Page page) {
         String url = page.getWebURL().getURL();
         System.out.println("URL: " + url);

         if (page.getParseData() instanceof HtmlParseData) {
             HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
             String text = htmlParseData.getText();
             String html = htmlParseData.getHtml();
             Set<WebURL> links = htmlParseData.getOutgoingUrls();
         
         
        	 File file = new File("data/store/crawled/crawl.txt");
        	 FileOutputStream fos =null;
        	 try {
        		 fos = new FileOutputStream(file);
        	 }
        	 catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
        	 }
        	 for(int i=0;i<=links.size();i++){
        	 PrintStream ps = new PrintStream(fos);
        	 System.setOut(ps);
        	 System.out.println("- - - - - - - - - - - Links found \n: "+links);
        	 }
            
/*
 *  		 System.out.println("Text length: " + text.length());
             System.out.println("Html length: " + html.length());
             System.out.println("Depth length" + getMyId());
             System.out.println("Number of outgoing links: " + links.size());
             System.out.println("URLs found: " + page.getWebURL().getURL());
             
             if(links.iterator().next() != null)
             {
            	 System.out.println("Title Found: "+ links); 	 System.out.println("Links Iterator: --------------------------------------------- \n\n"+links.iterator().);
            	 System.out.println("Parallel Stream: ---------------------------------------------\n\n"+links.parallelStream().toString());
            	 System.out.println("Stream: --------------------------------------------------\n\n"+links.stream().toString());
            	 System.out.println("Spliterator: ----------------------------------------------\n\n"+links.spliterator().toString());
            	 
             } */
         }
    }
}

