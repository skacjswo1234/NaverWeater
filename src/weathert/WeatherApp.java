package weathert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WeatherApp {

	public static void main(String[] args) throws IOException {
		
		// 논리적인 선이 만들어진다라고 생각하자 . 네이버 온도센서를 conn과 선으로 연결 한다고 생각하자.
		// 1. URL서버가 켜져있어야함.
		// USER가 사용할때는 BufferedWrite를 준다. Buffereduser는그러면 read로 읽는다.
		// conn은 바이트스트림이라고 생각하자.
		
		
		URL url;
		try {
			url = new URL("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=0&ie=utf8&query=%EB%82%A0%EC%94%A8");
			HttpsURLConnection conn =  (HttpsURLConnection) url.openConnection();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			
			StringBuilder sb = new StringBuilder();
			String input=null;
			while((input=br.readLine()) != null) {
				sb.append(input);
				
			}
			System.out.println(sb.toString());
			
			Document doc = Jsoup.parse(sb.toString());
			Elements ets = doc.select(".origin");
			System.out.println(ets.get(0).text());
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	
	}
	
}