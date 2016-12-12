/**
 *
 */
package reviewManager;

import org.jsoup.nodes.Document;

import java.io.IOException;

import static org.jsoup.Jsoup.connect;

/**
 * @author gangodup
 */
public class domainFinder {
	
	/**
	 *
	 */
	public domainFinder ( ) {
		
		//get useful information
		Document doc = null;
		try {
			doc = connect ( "http://www.mit.edu/" ).get ();
		} catch ( IOException e ) {
			e.printStackTrace ();
		}
		
//		if ( ( ( Object ) doc ).text ().contains ( "research" ) ) {
//			System.out.println ( URL );
//		}
		
		//get all links and recursively call the processPage method
//		Elements questions = ( ( Object ) doc ).select ( "a[href]" );
//		for ( Element link : questions ) {
//			if ( link.attr ( "href" ).contains ( "mit.edu" ) )
//				processPage ( link.attr ( "abs:href" ) );
//		}
	}
	
}
