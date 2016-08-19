package lion.translateapi.errors;

public class YandexUnknownException extends YandexException {
    private static final long serialVersionUID = 1L;
    private int code = -1;

    public YandexUnknownException() {
    }

    public YandexUnknownException(int code) {
        this.code = code;
    }

    public int getErrorCode() {
        return this.code;
    }

    public String getErrorMsg() {
        return "(Yandex error, is the API key correct?) Error: Unspecified error";
    }
}