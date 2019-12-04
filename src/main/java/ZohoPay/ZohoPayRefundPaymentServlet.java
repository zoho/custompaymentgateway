package ZohoPay;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/refundPayment") //No I18N
public class ZohoPayRefundPaymentServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		JSONObject responseJSON = new JSONObject();
		PrintWriter writer = res.getWriter();
		try
		{
			Enumeration<String> parameterNames = req.getParameterNames();
			Map<String, String> paramMap = PaymentUtil.getRequestParams(req, parameterNames);
			String gatewayReferenceID = paramMap.get("gateway_reference_id");//No I18N
			String booksReferenceID = DataStorage.paymentRecordedRefMap.get(gatewayReferenceID);
			Map<String, String> booksRequestJSON = DataStorage.paymentRequestRefMap.get(booksReferenceID);
			String accountID = booksRequestJSON.get("account_id");//No I18N
			String signature = paramMap.remove("signature");//No I18N
			String actualSignature = PaymentUtil.getSignature(paramMap, accountID);
			if(!actualSignature.equals(signature))
			{
				throw new Exception("Signature Mismatch");//No I18N
			}
			BigDecimal amount = new BigDecimal(paramMap.get("amount"));
			BigDecimal paidAmount = new BigDecimal(booksRequestJSON.get("amount"));
			if(paidAmount.compareTo(amount) < 0)
			{
				throw new Exception("Invalid amount");//No I18N
			}
			DataStorage.paymentRefundedRefMap.put(gatewayReferenceID, String.valueOf(amount));
			responseJSON.put("message", "Refund Recorded Successfully");//No I18N
			res.setContentType("application/json");//No I18N
			res.setStatus(201);
			writer.write(responseJSON.toString());
		}
		catch(Exception e)
		{
			res.setStatus(403);
			writer.write("{\"zcm_errorcode\":101, \"message\" : \"Failure in recording refund due to" + e +"\" }");//No I18N
		}
	}

}
