package ZohoPay;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/makepayment")
public class ZohoPayProcessPaymentServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		this.doPost(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter writers = res.getWriter();
		try
		{
			Enumeration<String> parameterNames = req.getParameterNames();
			Map<String, String> paramMap = PaymentUtil.getRequestParams(req, parameterNames);
			String card =  paramMap.get("card_number");
			String refID = paramMap.get("reference_id");
			Map<String, String> refMap = DataStorage.paymentRequestRefMap.get(refID);
			String uniquePaymentID = String.valueOf(UUID.randomUUID());
			boolean isSuccess = ("4111111111111111").equals(card);
			String userID = refMap.get("account_id");
			Map<String, String> paramterMap = new HashMap<>();
			String redirectURL = refMap.get("payment_complete_url");
			String[] urlAndParams = redirectURL.split("\\?");
			String targetURL = urlAndParams[0];
			if(urlAndParams.length > 1)
			{
				String[] queryParams = urlAndParams[1].split("&");
				for(String param : queryParams)
				{
					String[] paramNameVSValue = param.split("=");
					paramterMap.put(paramNameVSValue[0], paramNameVSValue[1]);
				}
			}
			paramterMap.put("gateway_fee", "0.00");
			paramterMap.put("currency_code",  refMap.get("currency_code"));
			paramterMap.put("payment_mode", "card");
			paramterMap.put("gateway_referece_id", uniquePaymentID);
			paramterMap.put("amount", refMap.get("amount"));
			if(isSuccess)
			{
				paramterMap.put("transaction_status", "1");
			}
			else
			{
				paramterMap.put("transaction_status", "0");
				paramterMap.put("gateway_errorcode", "5012");
				paramterMap.put("zcm_errorcode", "105");
			}
			String signature = PaymentUtil.getSignature(paramterMap, userID);
			paramterMap.put("signature", signature);
			DataStorage.paymentRecordedRefMap.put(uniquePaymentID, refID);
			StringBuilder stringBuilder = new StringBuilder();
			for(Map.Entry<String, String> paramEntry : paramterMap.entrySet())
			{
				String value = paramEntry.getValue();
				if(value == null)
				{
					value = "";
				}
				stringBuilder.append(paramEntry.getKey()).append("=").append(URLEncoder.encode(value, "UTF-8")).append("&");
			}
			res.setContentType("application/json");
			String redirecturl = targetURL + "?" + stringBuilder.toString();
			res.sendRedirect(redirecturl);

		}
		catch(Exception e)
		{
			res.setContentType("application/json");
			e.printStackTrace(writers);
			writers.println(e);
			writers.println(e.getCause());
		}
	}


}
