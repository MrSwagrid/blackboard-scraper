import java.net.MalformedURLException;
import java.net.URL;

public class Webpage {
	
	public Webpage(String webpage) {
		loadPage(webpage);
	}
	
	private void loadPage(String webpage) {
		try {
			URL url = new URL(webpage);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}