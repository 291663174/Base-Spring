package wuhen.spring.tx_xml;

// TODO: 2020/7/20 解决购买异常类
public class BookStockException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public BookStockException() {
        super();
    }

    public BookStockException(String message) {
        super(message);
    }

    public BookStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookStockException(Throwable cause) {
        super(cause);
    }

    public BookStockException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
