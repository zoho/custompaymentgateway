package ZohoPay;
import java.util.HashMap;
import java.util.Map;

public class DataStorage
{
	public static Map<String,Map<String, String>> PAYMENT_REQUEST_REFERENCE_MAP = new HashMap<String, Map<String, String>>();
	public static Map<String,String> PAYMENT_RECORDED_REF_MAP = new HashMap<>();
	public static Map<String, String> PAYMENT_REFUNDED_REF_MAP = new HashMap<>();
	public static final Map<String, String> userVsPasswordMap = new HashMap<String, String>()
	{
		{
			put("8719992", "uRIj0837FYjk");
		}
	};
}
