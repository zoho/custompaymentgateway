package ZohoPay;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/paymentpage/*")
public class ZohoPayPaymentPageServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		this.doPost(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		String requri = req.getRequestURI();
		String[] uri = requri.split("/");
		String refId = uri[uri.length - 1];
		Map<String, String> refMap = DataStorage.PAYMENT_REQUEST_REFERENCE_MAP.get(refId);
		String entityNumber = refMap.get("entity_number");
		String amount = refMap.get("amount");
		req.setAttribute("invoiceNumber",entityNumber);
		req.setAttribute("amount",amount);
		req.setAttribute("reference_id", refId);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/paypage.jsp");
		dispatcher.forward(req, res);
	}
}
