package ZohoPay;
import java.util.HashMap;
import java.util.Map;

class PaymentReference
{
	static Map<String,Map<String, String>> paymentRequestRefMap = new HashMap<String, Map<String, String>>();
	static Map<String,String> paymentRecordedRefMap = new HashMap<>();
	static Map<String, String> paymentRefundedRefMap = new HashMap<>();
}
