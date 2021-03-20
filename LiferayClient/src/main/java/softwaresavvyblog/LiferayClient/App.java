package softwaresavvyblog.LiferayClient;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.BasicHttpContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

			HttpHost targetHost = new HttpHost("localhost", 7080, "http");

			BasicHttpContext ctx = new BasicHttpContext();
			
			
			HttpGet httpGet = new HttpGet("http://localhost:7080/api/jsonws/webservices.employee/get-employees");
			
			Base64 b = new Base64();
			
			String encoding = b.encodeAsString(new String("your email:your pwd").getBytes());
			httpGet.setHeader("Authorization", "Basic " + encoding);

			HttpResponse resp = null;
			System.out.println("httpclient : " + httpClient);
			resp = httpClient.execute(targetHost, httpGet, ctx);

			resp.getEntity().writeTo(System.out);
			
			
			URIBuilder builder = new URIBuilder("http://localhost:7080/api/jsonws/webservices.employee/add-employee");
			builder.setParameter("empName", "Ravinder").setParameter("action", "finish");

			
			
			HttpPost httPost = new HttpPost(builder.toString());
			httPost.setHeader("Authorization", "Basic " + encoding);
			
			HttpResponse resp1 = null;
			System.out.println("httpclient : " + httpClient);
			resp1 = httpClient.execute(targetHost, httPost, ctx);

			resp1.getEntity().writeTo(System.out);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
