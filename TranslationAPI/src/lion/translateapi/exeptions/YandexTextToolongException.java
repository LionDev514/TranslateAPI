package lion.translateapi.exeptions;

public class YandexTextToolongException extends YandexException {
    private static final long serialVersionUID = 1L;

    public YandexTextToolongException() {
    }

    public int getErrorCode() {
        return 413;
    }

    public String getErrorMsg() {
        return "The text size exceeds the maximum.";
    }
}
