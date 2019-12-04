package ZohoPay;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.*;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createpaypage")
public class ZohoPayPaymentRequestServlet extends HttpServlet
{
	public static final Integer SUCCESS_CODE = 5010;
	public static final Integer HTTP_STATUS_FORBIDDEN = 403;
	public static final Integer HTTP_STATUS_INTERNAL_ERROR = 500;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		this.doPost(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter writer = res.getWriter();
		try
		{
			Map<String, String> paramMap =  PaymentUtil.getRequestParams(req, req.getParameterNames());
			String signature =  paramMap.remove("signature");
			boolean isVerified = PaymentUtil.verifySignature(signature, paramMap);
			if(!isVerified)
			{
			   res.setStatus(HTTP_STATUS_FORBIDDEN);
			   return;
			}
			String refID =  paramMap.get("reference_id");
			DataStorage.paymentRequestRefMap.put(refID, paramMap);
			String paymentpageURL = "/zhpay/paymentpage/"+ refID;//NO I18N
			res.setStatus(302);
			res.setHeader("Location", paymentpageURL);//No I18N
		}
		catch(Exception e)
		{
			res.setContentType("application/json");
			res.setStatus(HTTP_STATUS_INTERNAL_ERROR);
		}
	}


}
