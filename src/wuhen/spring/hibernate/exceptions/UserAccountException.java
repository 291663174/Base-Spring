package wuhen.spring.hibernate.exceptions;

// TODO: 2020/7/20 解决用户账户信息异常类
public class UserAccountException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public UserAccountException() {
        super();
    }

    public UserAccountException(String message) {
        super(message);
    }

    public UserAccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAccountException(Throwable cause) {
        super(cause);
    }

    public UserAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
