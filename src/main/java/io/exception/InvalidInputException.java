package io.exception;

public class InvalidInputException extends Exception {

    private static final long serialVersionUID = 1L;
    private static final String errorMessage = "Please, provide a valid list of integers!";

    public InvalidInputException() {
        super(errorMessage);
    }

}
