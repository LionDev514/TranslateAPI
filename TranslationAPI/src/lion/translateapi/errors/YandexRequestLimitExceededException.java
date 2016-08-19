package lion.translateapi.errors;

public class YandexRequestLimitExceededException extends YandexException {
    private static final long serialVersionUID = 1L;

    public YandexRequestLimitExceededException() {
    }

    public int getErrorCode() {
        return 403;
    }

    public String getErrorMsg() {
        return "(Yandex error, is the API key correct?) Error: You have reached the daily limit for requests (including calls of the detect method).";
    }
}
