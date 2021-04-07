package cn.org.htz.qrweb.util;


import org.json.JSONObject;

/*
 * 通过ip判断是否是中国内地
 */
public class IpChina {
    private static final String ipUrl = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json";
    private static final String China = "\u4e2d\u56fd";
    private static final String Taiwan = "\u53f0\u6e7e";
    private static final String HongKong = "\u9999\u6e2f";
    private static final String Macao = "\u6fb3\u95e8";
    public static boolean ipIsChinaInland() {
        try {
            String json = getIpData();
            System.out.println("json="+json);
            JSONObject jsonObject = new JSONObject(json);
            String country = jsonObject.getString("country");
            String city = jsonObject.getString("province");
            if(country!=null && city!=null) {
                if(country.equals(China)) {
                    if(city.equals(Taiwan) || city.equals(HongKong) || city.equals(Macao)) {
                        // deal with non-china inland
                    } else {
                        // deal with china inland
                        return true;
                    }
                } else {
                    // deal with non-china inland
                }
            } else {
                // deal with non-china inland
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private static String getIpData() throws Exception {
        String result = HttpClient.doGet(ipUrl);
        return result;
    }
}
