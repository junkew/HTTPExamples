package org.apache.http.examples.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class QuickMail {
	
    public static void main(String[] args) throws Exception {	
	    Content content = Request.Post("https://webmail.xs4all.nl").execute().returnContent();
	    		//.bodyForm(Form.form().add("username", "vip").add("password", "secret").build()).execute().returnContent();
	    System.out.println(content.asString());
	}
}

