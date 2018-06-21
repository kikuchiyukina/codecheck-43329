package codecheck;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.lang.StringBuilder;


public class App {
	public static void main(String[] args) {

		String val = new String(args);
		String urlString = "http://challenge-server.code-check.io/api/hash?q=";

		String url = urlString + val;

		HttpURLConnection  urlConn = null;
		InputStream in = null;
		BufferedReader reader = null;

		try {
			URL url1 = new URL(url);
			urlConn = (HttpURLConnection) url1.openConnection();
			urlConn.setRequestMethod("GET");
			urlConn.connect();
			int status = urlConn.getResponseCode();

			if (status == HttpURLConnection.HTTP_OK) {
				in = urlConn.getInputStream();
				reader = new BufferedReader(new InputStreamReader(in));

				StringBuilder output = new StringBuilder();
				String line;
				while ((line = reader.readLine()) != null) {
					output.append(line);
				}
				System.out.println(output.toString());
		      }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
				if (urlConn != null) {
					urlConn.disconnect();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			}
		}
