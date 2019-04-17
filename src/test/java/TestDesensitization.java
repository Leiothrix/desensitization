import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author adam
 * @date 2019/4/17 15:37
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */
public class TestDesensitization {

    private DesensitizationUtils desensitizationUtils = new DesensitizationUtils();

    @Test
    public void TestName(){
        assertEquals("周**", desensitizationUtils.name("周星驰"));
    }

    @Test
    public void TestIdCardNum(){
        assertEquals("110***********8678", desensitizationUtils.idCardNum("110101199601018678"));
    }

    @Test
    public void TestAddress(){
        assertEquals("深圳市南山区粤海街道*****", desensitizationUtils.address("深圳市南山区粤海街道高新南七道",5));
    }
    @Test
    public void TestMobilePhone(){
        assertEquals("138****2254", desensitizationUtils.mobilePhone("13879632254"));
    }
    @Test
    public void TestFixedPhone(){
        assertEquals("****891", desensitizationUtils.fixedPhone("4756891"));
    }
    @Test
    public void TestEmail(){
        assertEquals("a***@noreply.gmail.com", desensitizationUtils.email("adam@noreply.gmail.com"));
    }
    @Test
    public void TestBankCard(){
        assertEquals("************3241", desensitizationUtils.bankCard("4514784166353241"));
    }
    @Test
    public void TestPassword(){
        assertEquals("******", desensitizationUtils.password("KiX7E8XcNhAI$HYZ"));
    }

}
