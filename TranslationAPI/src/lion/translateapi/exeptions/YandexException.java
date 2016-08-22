package lion.translateapi.exeptions;

import java.io.IOException;

public abstract class YandexException extends IOException {
    private static final long serialVersionUID = 1L;

    public YandexException() {
    }

    public abstract int getErrorCode();

    public abstract String getErrorMsg();

    public String getMessage() {
        return this.getErrorCode() + ": " + this.getErrorMsg();
    }
}