package lion.translateapi.errors;

public class YandexBlockedKeyException extends YandexException {
    private static final long serialVersionUID = 1L;

    public YandexBlockedKeyException() {
    }

    public int getErrorCode() {
        return 401;
    }

    public String getErrorMsg() {
        return "(Yandex error, is the API key correct?) Error: Invalid API Key";
    }
}
