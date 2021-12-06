package naver.captcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Ex01_ApiCaptchakey {

	public static void main(String[] args) {
		
		String cliendId = "VkWVzD8tJb5bzb4Gqaxv";
		String clientSecret = "qBj4xgKxtO";
		
		String code = "0";	// 키 발급 "0", 이미지 비교 "1"
		String apiURL = "https://openapi.naver.com/v1/captcha/nkey?code=" + code;
		
		// 요청 해더(request header) : 아이디, 시크릿
		Map<String, String> requestHeaders = new HashMap<String, String>();
		requestHeaders.put("X-Naver-Client-Id", cliendId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		
		URL url = null;
		HttpURLConnection con = null;
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> entry : requestHeaders.entrySet()) {
				con.setRequestProperty(entry.getKey(), entry.getValue());
			}
			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // InputStream is = con.getInputStream();				
				InputStreamReader isr = new InputStreamReader(con.getInputStream());
				BufferedReader br = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					sb.append(line);
				}
				System.out.println("네이버로부터 반환 답은 데이터 : " + sb.toString());
				JSONObject obj = new JSONObject(sb.toString());
				String captchaKey = (String)obj.get("key");
				System.out.println(captchaKey);
			} else {			
				InputStreamReader isr = new InputStreamReader(con.getErrorStream());
				BufferedReader br = new BufferedReader(isr);
				StringBuilder sb = new StringBuilder();
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					sb.append(line);
				}
				System.out.println("네이버로부터 반환 답은 에러 : " + sb.toString());
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("ARI URL이 잘못되었습니다. : " + apiURL, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiURL, e);
		} finally {
			con.disconnect();
		}
		
	}

}
