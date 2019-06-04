import com.wuzl.bean.User;
import com.wuzl.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class limit {
    @Autowired
    private UserMapper us;
    @Test
    public void limit(){

        List<User> lu = us.findall(0,10);
       int i= lu.size();
       System.out.println(i);
    }
}
