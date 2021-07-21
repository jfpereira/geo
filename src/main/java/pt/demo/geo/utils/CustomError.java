package pt.demo.geo.utils;

/**
 * CustomError class to send error message to user api
 */
public class CustomError {
    private int code;
    private String error;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public CustomError(int code, String error) {
        this.code = code;
        this.error = error;
    }
}
