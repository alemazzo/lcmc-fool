package compiler.lib.exc;

import compiler.lib.FOOL;

import java.io.Serial;

/**
 * An exception thrown when a type error is found.
 */
public class TypeException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public String text;

    public TypeException(String t, int line) {
        FOOL.typeErrors++;
        text = t + " at line " + line;
    }

}
