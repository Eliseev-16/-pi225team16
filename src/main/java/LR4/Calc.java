package LR4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/JavaCalc") //
public class Calc extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	
	private static class RequestCalc {
		private final String first_calc;
		private final String second_calc;
		private final String third_calc;
		private final String four_calc;
		private int result;
						
		private RequestCalc (String first, String second, String third, String four) {
			this.first_calc = first;
			this.second_calc = second;
			this.third_calc = third;
			this.four_calc = four;
			}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("first_side"),
			request.getParameter("second_side"), 
			request.getParameter("third_side"), 
			request.getParameter("fourth_side"));
			}
				
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("first_side", first_calc);
			request.setAttribute("second_side", second_calc);
			request.setAttribute("third_side", third_calc);
			request.setAttribute("fourth_side", four_calc);
			int first_try;
			int second_try;
			int third_try;
			int four_try;
			try { 
			first_try=Integer.parseInt(first_calc);
			second_try=Integer.parseInt(second_calc);
			third_try=Integer.parseInt(third_calc);
			four_try=Integer.parseInt(four_calc);
			}
			catch (NumberFormatException e) {
				first_try=0;
				second_try=0;
				third_try=0;
				four_try=0;
			}
			
			result= first_try + second_try + third_try + four_try;
			request.setAttribute("result", result);
		}
	}
	
	
}