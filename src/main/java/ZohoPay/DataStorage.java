package ZohoPay;
import java.util.HashMap;
import java.util.Map;

public class DataStorage
{
	public static Map<String,Map<String, String>> paymentRequestRefMap = new HashMap<String, Map<String, String>>();
	public static Map<String,String> paymentRecordedRefMap = new HashMap<>();
	public static Map<String, String> paymentRefundedRefMap = new HashMap<>();
	public static final Map<String, String> userVsPasswordMap = new HashMap<String, String>()
	{
		{
			put("8719992", "uRIj0837FYjk");
		}
	};
}
