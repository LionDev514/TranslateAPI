package lion.translateapi.errors;

public class YandexCharLimitExceededException extends YandexException {
    private static final long serialVersionUID = 1L;

    public YandexCharLimitExceededException() {
    }

    public int getErrorCode() {
        return 404;
    }

    public String getErrorMsg() {
        return "You have reached the daily limit for the volume of translated text (including calls of the detect method).";
    }
}
