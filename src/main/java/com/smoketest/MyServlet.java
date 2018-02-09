package com.smoketest;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

public class MyServlet extends HttpServlet {

 /**
   * @see javax.servlet.http.HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html");
    request.setAttribute("url", "https://cis1-xmldirect.ehi.com/services/OTA");

    PrintWriter out = response.getWriter();
    out.println("<html><head><title>OTA2007A Test Servlet</title></head>");
    out.println("<body><form method=post target=\"_blank\">");
    out.println("<h2>OTA2007A Test Servlet</h2>");
    out.println(
      "Note:  You <b>do not</b> need to add a SOAP envelope to your request.  This is done behind the scenes<br/><br/>");
    out.println("<select name=\"service\">");
    out.println("<option value=\"vehResService\">VehResService</option>");
    out.println("<option value=\"vehModifyService\">VehModifyService</option>");
    out.println("<option value=\"vehRetResService\">VehRetResService</option>");
    out.println("<option value=\"vehCancelService\">VehCancelService</option>");
    out.println("<option value=\"vehAvailRateService\">VehAvailRateService</option>");
    out.println("<option value=\"vehLocSearchService\">VehLocSearchService</option>");
    out.println("</select><br/>");
    out.println(
      "Use SOAP envelope from my request <input type=\"checkbox\" name=\"soapHeaderFlag\" value=\"true\"/><br/>");
    out.println("<textarea rows=\"40\" cols=\"125\" name=\"xmlRequest\">");
    out.println("</textarea>");
    out.println("<br/><input type=\"submit\" value=\"Submit Request\">");
    out.println("</form></body></html>");
    out.flush();
  }

  /**
   * @see javax.servlet.http.HttpServlet#doPost(HttpServletRequest, HttpServletResponse)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String inputMessage = request.getParameter("xmlRequest");
    String soapAction = request.getParameter("service");
    String soapHeaderFlag = request.getParameter("soapHeaderFlag");
    request.setAttribute("url", "https://cis1-xmldirect.ehi.com/services/OTA");
    	HttpPost post=null;
	BufferedReader br = null;
	String strResponse = "";
	CloseableHttpClient client = null;


try {

    // doGet(request, response);

    PrintWriter out = response.getWriter();

    out.write("<pre>");
    out.write("<b>REQUEST</b>\n");
    out.write(inputMessage);
    out.write("</pre>");



     client = HttpClients.createDefault();

    //client.setUrl((String) request.getAttribute("url"));
    //client.setSoapAction(soapAction);
   // client.setResponseNeeded(true);
   // client.setXmlMessage(inputMessage, Boolean.valueOf(soapHeaderFlag).booleanValue());
   URIBuilder builder = new URIBuilder("https://cis1-xmldirect.ehi.com/services/OTA");
   		  				builder.setParameter("http.socket.timeout", "45000");
   		  				builder.setParameter("http.connection.timeout", "45000");
		  				builder.setParameter("password", "pass");
		  				post = new HttpPost(builder.build());
								  				post.setHeader("Content-type", "text/xml; charset=ISO-8859-1");
								  				post.setHeader("SOAPAction", "VehAvailRateService");
		  				post.setHeader("X-OTA2012B", "true");

	HttpResponse httpResponse=null;
	httpResponse = client.execute(post);

   // AverageTimer timer = new AverageTimer(1, "Request");

   br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
   		  				String readLine;
   		  				while(((readLine = br.readLine()) != null)) {
   		  					strResponse=strResponse+readLine;
		  				}

    String outputMessage = strResponse;

   // out.println("<pre>\n<b>" + timer.toString() + "\n</b></pre>");
    out.println("<pre>\n<b>RESPONSE</b>");
    out.println(outputMessage);
    out.flush();

    } catch (Exception e) {
			  				strResponse = e.toString();
			  			//	result = HTTP_ERROR;
			  			} finally {
			  				// Release current connection to the connection pool once done
			  				if(post != null) {
			  					post.releaseConnection();
			  				}
			  				if(client != null) {
			  					try{
			  						client.close();
			  					}catch(IOException e){
			  					//	logger.warn("Exception closing the connection:",e);
			  					}
			  				}
			  				// Close BufferedReader
			  				if(br != null) {
			  					try {
			  						br.close();
			  					} catch (Exception fe) {
			  						//do nothing; we did our best to clean up
			  					}
							}
			  		//
			}

    return;
  }

}