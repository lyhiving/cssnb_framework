import java.sql.Timestamp;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;


public class TestDate {

	private static SerializeConfig mapping = new SerializeConfig();
    static {
        mapping.put(Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        mapping.put(Timestamp.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts);
		System.out.println(JSON.toJSONString(ts));
		System.out.println(JSON.toJSONString(ts,mapping));
		System.out.println(JSON.toJSONString(ts,mapping));
		System.out.println(JSON.toJSONStringWithDateFormat(ts,"yyyy-MM-dd"));
	}

}
