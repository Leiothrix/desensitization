import org.apache.commons.lang3.StringUtils;

/**
 * @author adam
 * @date 2019/4/17 15:17
 * PS: You may say that I'm a dreamer.But I'm not the only one.
 */

public class DesensitizationUtils {
    /**
     * @param fullName 【姓名】只保留第一个字符，其他隐藏为2个星号，比如：李**
     * @return 脱敏后手机号码
     */
    public String name(String fullName) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, 1);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }

    /**
     * @param identityNumber 【身份证号】保留前三位和后四位，其他隐藏。共计18位或者15位，比如：360**********023X
     * @return 脱敏后身份证号
     */
    public String idCardNum(String identityNumber) {
        if (StringUtils.isBlank(identityNumber)) {
            return "";
        }
        return StringUtils.left(identityNumber, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(identityNumber, 4),
                StringUtils.length(identityNumber), "*"), "***"));
    }

    /**
     * @param address 【地址】不显示详细地址，比如：深圳市南山区粤海街道***
     * @param sensitiveSize 自定义敏感信息长度
     * @return 脱敏后地址
     */
    public String address(String address, int sensitiveSize) {
        if (StringUtils.isBlank(address)) {
            return "";
        }
        int length = StringUtils.length(address);
        return StringUtils.rightPad(StringUtils.left(address, length - sensitiveSize), length, "*");
    }

    /**
     * @param mobilePhoneNumber 【手机号码】前三位，后四位，其它隐藏，比如：138****6610
     * @return 脱敏后手机号码
     */
    public String mobilePhone(String mobilePhoneNumber) {
        if (StringUtils.isBlank(mobilePhoneNumber)) {
            return "";
        }
        return StringUtils.left(mobilePhoneNumber, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.
                right(mobilePhoneNumber, 4), StringUtils.length(mobilePhoneNumber), "*"), "***"));
    }

    /**
     * @param fixedTelephoneNumber 【固定电话】 保留后三位，其他隐藏，比如：****341
     * @return 脱敏后固定电话
     */
    public String fixedPhone(String fixedTelephoneNumber) {
        if (StringUtils.isBlank(fixedTelephoneNumber)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(fixedTelephoneNumber, 3), StringUtils.length(fixedTelephoneNumber), "*");
    }

    /**
     * @param emailAddress 【电子邮箱】 邮箱前缀仅显示第一个字母，前缀其他隐藏，用星号代替，@及后面的地址显示，比如：h**@163.com
     * @return 脱敏后电子邮箱
     */
    public String email(String emailAddress) {
        if (StringUtils.isBlank(emailAddress)) {
            return "";
        }
        int index = StringUtils.indexOf(emailAddress, "@");
        if (index <= 1){
            return emailAddress;
        }

        else {
            return StringUtils.rightPad(StringUtils.left(emailAddress, 1), index, "*").concat(StringUtils.mid(emailAddress, index, StringUtils.length(emailAddress)));
        }
    }

    /**
     * @param bankCardNumber 【银行卡号】保留后四位，比如：************1234
     * @return 脱敏后银行卡号
     */
    public String bankCard(String bankCardNumber) {
        if (StringUtils.isBlank(bankCardNumber)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(bankCardNumber, 4), StringUtils.length(bankCardNumber), "*");
    }

    /**
     * @param password 【密码】全部字符隐藏，且统一长度为6位，比如：******
     * @return 脱敏后密码
     */
    public String password(String password) {
        if (StringUtils.isBlank(password)) {
            return "";
        }
        String pwd = StringUtils.left(password, 0);
        return StringUtils.rightPad(pwd, 6, "*");
    }

}
