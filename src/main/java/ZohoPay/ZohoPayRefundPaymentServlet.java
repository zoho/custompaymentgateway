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

@WebServlet("/refundPayment")
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
			String gatewayReferenceID = paramMap.get("gateway_reference_id");
			String booksReferenceID = DataStorage.PAYMENT_RECORDED_REF_MAP.get(gatewayReferenceID);
			Map<String, String> booksRequestJSON = DataStorage.PAYMENT_REQUEST_REFERENCE_MAP.get(booksReferenceID);
			String accountID = booksRequestJSON.get("account_id");
			String signature = paramMap.remove("signature");
			String actualSignature = PaymentUtil.getSignature(paramMap, accountID);
			if(!actualSignature.equals(signature))
			{
				throw new Exception("Signature Mismatch");
			}
			BigDecimal amount = new BigDecimal(paramMap.get("amount"));
			BigDecimal paidAmount = new BigDecimal(booksRequestJSON.get("amount"));
			if(paidAmount.compareTo(amount) < 0)
			{
				throw new Exception("Invalid amount");
			}
			DataStorage.PAYMENT_REFUNDED_REF_MAP.put(gatewayReferenceID, String.valueOf(amount));
			responseJSON.put("message", "Refund Recorded Successfully");
			res.setContentType("application/json");
			res.setStatus(201);
			writer.write(responseJSON.toString());
		}
		catch(Exception e)
		{
			res.setStatus(403);
			e.printStackTrace();
			writer.write("{\"zcm_errorcode\":101, \"message\" : \"Failure in recording refund due to" + e +"\" }");
		}
	}

}
