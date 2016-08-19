package lion.translateapi.errors;

public class YandexInvalidKeyException extends YandexException {
    private static final long serialVersionUID = 1L;

    public YandexInvalidKeyException() {
    }

    public int getErrorCode() {
        return 402;
    }

    public String getErrorMsg() {
        return "(Yandex error, is the API key correct?) Error: API Key blocked";
    }
}
