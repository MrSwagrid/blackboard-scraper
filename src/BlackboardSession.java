import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class BlackboardSession {
	
	public BlackboardSession(String username, String password) {
		
		String mainPage = loadPage("https://lms.curtin.edu.au/webapps/portal/execute/tabs/tabAction?tab_tab_group_id=_84_1");
		System.out.println(mainPage);
	}
	
	private static String loadPage(String url) {
		
		try {
			
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			CloseableHttpResponse response = httpclient.execute(httpGet);
			InputStream stream = response.getEntity().getContent();
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(stream).useDelimiter("\\A");
			return sc.hasNext() ? sc.next() : "";
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}