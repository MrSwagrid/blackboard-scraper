import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTP {
	
	public static String loadPage(String webpage) {
		
		try {
			
			//Send request.
			
			URL url = new URL(webpage);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			out.close();
			
			//Get response.
			
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String response = "", line;
			
			while((line = reader.readLine()) != null) {
				response += line + '\n';
			}
			
			reader.close();
			return response.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}