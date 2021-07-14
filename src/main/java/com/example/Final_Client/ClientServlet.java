package com.example.Final_Client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ClientServlet", value = "/weather")
public class ClientServlet extends HttpServlet {
    private String message;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String location = request.getParameter("city");
        location = location.replace(" ", "%20");
        String result = ReadJSON.readHTTP("http://localhost:8080/Final_war_exploded/servlet?city=" + location);

        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        Weather weather = mapper.readValue(result, Weather.class);

        // Hello

        out.println("<html><body>");
        out.println("<h1>" + "This is the weather for " + request.getParameter("city") + "</h1>");
        out.println("<p>The weather is: " + weather.getMain());
        out.println("<br>Description: " + weather.getMainDesc());
        out.println("<br>Temperature right now: " + weather.getTemp());
        out.println("<br>Minimum temperature expected for today: " + weather.getTempMin());
        out.println("<br>Maximum temperature expected for today: " + weather.getTempMax());
        out.println("</body></html>");
    }

    public void destroy() {
    }
}