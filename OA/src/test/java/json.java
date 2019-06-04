import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.*;

import static com.wuzl.utils.StringUtils.get_json;

public class json {
    @Test
    public void getjson() {

        JSONObject js = new JSONObject(new LinkedHashMap());
        js.put("code", 200);
        js.put("msg", "ok");
        js.put("count", 20);
        js.put("data", "");


        String s = JSON.toJSONString(js);
        System.out.println(s);

    }
}
