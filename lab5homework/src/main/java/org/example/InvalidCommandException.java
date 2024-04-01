package org.example;

/**
 * Exception thrown when an invalid command is encountered.
 */
class InvalidCommandException extends Exception {
    /**
     * Constructs an InvalidCommandException with the specified detail message.
     *
     * @param message The detail message.
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}
