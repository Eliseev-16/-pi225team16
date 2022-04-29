package LR4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class Calc.
 */
@WebServlet(name="Calc", urlPatterns="/JavaCalc") //
public class Calc extends HttpServlet {

	/**
	 * Do post.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		 
		request.getRequestDispatcher("/Results.jsp").forward(request, response);
		
	}
	
	/**
	 * The Class RequestCalc.
	 */
	private static class RequestCalc {
		
		/** The first calc. */
		private final String first_calc;
		
		/** The second calc. */
		private final String second_calc;
		
		/** The third calc. */
		private final String third_calc;
		
		/** The four calc. */
		private final String four_calc;
						
		/**
		 * Instantiates a new request calc.
		 *
		 * @param first the first
		 * @param second the second
		 * @param third the third
		 * @param four the four
		 */
		private RequestCalc (String first, String second, String third, String four) {
			this.first_calc = first;
			this.second_calc = second;
			this.third_calc = third;
			this.four_calc = four;
			}
		
		/**
		 * From request parameters.
		 *
		 * @param request the request
		 * @return the request calc
		 */
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
			request.getParameter("first_side"),
			request.getParameter("second_side"), 
			request.getParameter("third_side"), 
			request.getParameter("fourth_side"));
			}
				
		/**
		 * Sets the as request attributes and calculate.
		 *
		 * @param request the new as request attributes and calculate
		 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			double first_try;
			double second_try;
			double third_try;
			double four_try;
			try { 
			first_try=Double.parseDouble(first_calc);
			second_try=Double.parseDouble(second_calc);
			third_try=Double.parseDouble(third_calc);
			four_try=Double.parseDouble(four_calc);
			}
			catch (NumberFormatException e) {
				first_try=0;
				second_try=0;
				third_try=0;
				four_try=0;
			}
			Calculate calculate = new Calculate();
			calculate.setSides(first_try, second_try, third_try, four_try);
			request.setAttribute("first_side", calculate.getFirst());
			request.setAttribute("second_side", calculate.getSecond());
			request.setAttribute("third_side", calculate.getThird());
			request.setAttribute("fourth_side", calculate.getFourth());
			request.setAttribute("result", calculate.getResult());
		}
	}
	
	
}