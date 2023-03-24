package proverb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.*;

import org.json.JSONObject;

public class Proverbs {

	public static JSONObject getProverbs(String category) {
		JSONObject jsonObject = new JSONObject();
		String url = "https://api.api-ninjas.com/v1/quotes?category=" + category;
		String proverb = "";
		try {
		URL newUrl = new URL(url);
		HttpURLConnection con = (HttpURLConnection) newUrl.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("X-Api-Key", "xMFOcE7VvGvebLRLRS5hLg==CzKuHTGIsiMSZegB");
		
		System.out.println(con.getResponseMessage());
		System.out.println(con.getResponseCode());
		
		if(con.getResponseCode() == 200) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringBuilder builder = new StringBuilder();
		
		String p = "";
		
		while((p = buffer.readLine()) != null) {
			System.out.println(p);
			builder.append(p);
			builder.append("\n");
		}
		buffer.close();
		con.disconnect();
		
		proverb = builder.toString();
		String[] details = proverb.split(", ");
		String[] quote = details[0].split(": ");
		String[] author = details[1].split(": ");
        jsonObject.put("quote", quote[1]);
		jsonObject.put("statusCode", 200);
		jsonObject.put("proverb", proverb);
		}
		else {
			jsonObject = getProverbs(category);
		}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return jsonObject;
}
}
