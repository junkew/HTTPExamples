package org.apache.http.examples.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class QuickDefaultHttpClient {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
	//	Deprecated: HttpClient client = new DefaultHttpClient();
	//	MinimalHttpClient httpclient = new HttpClientBuilder().build();
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		//HttpPost httpPostRequest = new HttpPost();
		 
		HttpGet request = new HttpGet("http://www.vogella.com");
		// Prepare a request object
	//	HttpGet httpget = new HttpGet("http://www.vogella.com/");
		HttpResponse response = httpClient.execute(request);

		// Get the response
		BufferedReader rd = new BufferedReader
		    (new InputStreamReader(
		    response.getEntity().getContent()));

		String line = "";
		while ((line = rd.readLine()) != null) {
		    //textView.append(line);
			System.out.println(line);
		}
	}

}
