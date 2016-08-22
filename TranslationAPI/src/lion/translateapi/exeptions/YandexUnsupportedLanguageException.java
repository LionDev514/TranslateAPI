package lion.translateapi.exeptions;

/**
 * Created by Angel on 17/08/2016.
 */
public class YandexUnsupportedLanguageException extends YandexException {
    private static final long serialVersionUID = 1L;

    public YandexUnsupportedLanguageException() {
    }

    public int getErrorCode() {
        return 501;
    }

    public String getErrorMsg() {
        return "The specified translation direction is not supported.";
    }
}
