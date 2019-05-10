


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/form")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

    
    
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		  //String name = request.getParameter("userName");
		  //String email = request.getParameter("email");
		  //String ip = request.getRemoteAddr();
		 // String button1 = request.getParameter("button1");
		  
		  
	        // create gpio controller
	        final GpioController gpio = GpioFactory.getInstance();

	        // provision gpio pin #01 & #03 as an output pins and blink
	        final GpioPinDigitalOutput led1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01);
		  
	        
	        if(led1.isHigh())
	        {
	        	led1.low();
	        }
	        
	        else
	        {
	        	led1.high();
	        }
	        

		  
		  
		  response.getWriter().println("<html>");
		  response.getWriter().println("<head>");
		  response.getWriter().println("<title>This is the response </title>");
		  response.getWriter().println("</head>");
		  response.getWriter().println("<body>");
//		  
		  response.getWriter().println("button pressed");
//		  response.getWriter().println("Your name is: " + name);
//		  response.getWriter().println("Your email is: " + email);
//		  response.getWriter().println("Your address is: " + ip);
		  
//		  if(button1.equals("ToggleLED"))
//		  {
//			  response.getWriter().println("LED TOGGLE");
//		  }
		  
		  response.getWriter().println("</body>");
		  response.getWriter().println("</html>");
		  
		  
		  
		  

		  
		  gpio.shutdown();
		  gpio.unprovisionPin(led1);
	  }
    
    
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
