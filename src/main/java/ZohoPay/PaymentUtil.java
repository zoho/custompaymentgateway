package ZohoPay;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

public class PaymentUtil
{

	
	public static String sortAndGetSign(Map<String, String> params, String signKey) throws Exception
	{
		Map <String, Object> sortedParam = new TreeMap<>(params);
		StringBuilder sb = new StringBuilder();
		for(Map.Entry <String, Object> paramEntry : sortedParam.entrySet())
		{
			sb.append(paramEntry.getKey()).append(paramEntry.getValue().toString());
		}
		return sign(signKey, sb.toString());
	}

	private static String sign(String key, String message) throws Exception
	{

		SecretKeySpec keySpec = new SecretKeySpec(
			key.getBytes(),
			"HmacSHA256"); // No I18N

		Mac mac = Mac.getInstance("HmacSHA256");
		mac.init(keySpec);
		byte[] rawHmac = mac.doFinal(message.getBytes());
		return new String(encodeHex(rawHmac, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'}));
	}

	private static char[] encodeHex(byte[] data, char[] toDigits) {
		int l = data.length;
		char[] out = new char[l << 1];
		int i = 0;

		for(int var5 = 0; i < l; ++i) {
			out[var5++] = toDigits[(240 & data[i]) >>> 4];
			out[var5++] = toDigits[15 & data[i]];
		}

		return out;
	}

	public static boolean verifySignature(String receivedSignature, Map<String, String> paramterMap) throws Exception
	{
		String userID = paramterMap.get("account_id");
		if(!DataStorage.userVsPasswordMap.containsKey(userID))
		{
			throw new Exception("Invalid Account ID");
		}
		String actualsignature = sortAndGetSign(paramterMap, DataStorage.userVsPasswordMap.get(userID));
		return receivedSignature.equals(actualsignature);
	}


	public static Map <String, String> getRequestParams(HttpServletRequest request, Enumeration<String> parameterMap)
	{
		Map <String, String> params = new HashMap<>();
		while(parameterMap.hasMoreElements())
		{
			String param = parameterMap.nextElement();
			params.put(param, request.getParameter(param));
		}
		return params;
	}

	public static String getSignature(Map<String, String> paramMap, String userID) throws Exception
	{
		String signKey = DataStorage.userVsPasswordMap.get(userID);
		return sortAndGetSign(paramMap, signKey);
	}
}
