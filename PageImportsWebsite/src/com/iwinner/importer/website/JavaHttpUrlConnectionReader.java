package com.iwinner.importer.website;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 
 * A complete Java class that shows how to open a URL, then read data (text)
 * from that URL, HttpURLConnection class (in combination with an
 * InputStreamReader and BufferedReader).
 * 
 * @author alvin alexander, devdaily.com.
 * 
 */
public class JavaHttpUrlConnectionReader {
	public static void main(String[] args) throws Exception {
		new JavaHttpUrlConnectionReader();
	}

	public JavaHttpUrlConnectionReader() {
		try {
			File inputFile=new File("E:\\Etu\\input\\websites.txt");
			FileReader fileRe=new FileReader(inputFile);
			BufferedReader br=new BufferedReader(fileRe);
			String s;
			int x=0;
			while((s=br.readLine())!=null){
				String newURL=s.trim();
				x++;
				System.out.println("Increment Value is "+x);
			/*
			String myUrl = s;
			int x=myUrl.indexOf(".");
			System.out.println(x);
			String newString=myUrl.substring(x+1, myUrl.length());
			//System.out.println(newString);
			int newStringX=newString.indexOf(".");

			String fileName=myUrl.substring(x+1, x+newStringX+1);
		//	String text=myUrl.substring(x+1, newStringX);
			//System.out.println("FileName "+text);
		// if your url can contain weird characters you will want to
			// encode it here, something like this:
			// myUrl = URLEncoder.encode(myUrl, "UTF-8");

*/			String results = doHttpUrlConnectionAction(newURL);
			//System.out.println(results);
			Timestamp timestamp=new Timestamp(new Date().getTime());
			System.out.println(timestamp.getTime());
			File file = new File("E:\\Etu\\"+timestamp.getTime()+"_.html");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(results);
			bw.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// deal with the exception in your "controller"
		}
	}

	/**
	 * Returns the output from the given URL.
	 * 
	 * I tried to hide some of the ugliness of the exception-handling in this
	 * method, and just return a high level Exception from here. Modify this
	 * behavior as desired.
	 * 
	 * @param desiredUrl
	 * @return
	 * @throws Exception
	 */
	private String doHttpUrlConnectionAction(String desiredUrl)
			throws Exception {
		URL url = null;
		BufferedReader reader = null;
		StringBuilder stringBuilder;

		try {
			// create the HttpURLConnection
			url = new URL(desiredUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			// just want to do an HTTP GET here
			connection.setRequestMethod("GET");

			// uncomment this if you want to write output to this url
			// connection.setDoOutput(true);

			// give it 15 seconds to respond
			connection.setReadTimeout(15 * 1000);
			connection.connect();

			// read the output from the server
			reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			stringBuilder = new StringBuilder();

			String line = null;
			while ((line = reader.readLine()) != null) {
				stringBuilder.append(line + "\n");
			}
			return stringBuilder.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			// close the reader; this can throw an exception too, so
			// wrap it in another try/catch block.
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}
	}
}