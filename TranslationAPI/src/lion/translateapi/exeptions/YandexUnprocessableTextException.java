package lion.translateapi.exeptions;

public class YandexUnprocessableTextException extends YandexException {
    private static final long serialVersionUID = 1L;

    public YandexUnprocessableTextException() {
    }

    public int getErrorCode() {
        return 422;
    }

    public String getErrorMsg() {
        return "The text could not be translated.";
    }
}
