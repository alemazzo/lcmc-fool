package compiler.east;

import compiler.ast.BaseASTVisitor;
import compiler.lib.exc.UnimplementedException;

public class BaseEASTVisitor<S, E extends Exception> extends BaseASTVisitor<S, E> {

    protected BaseEASTVisitor() {
        super();
    }

    protected BaseEASTVisitor(final boolean incompleteExceptionEnabled) {
        super(incompleteExceptionEnabled);
    }

    protected BaseEASTVisitor(final boolean incompleteExceptionEnabled, final boolean printEnabled) {
        super(incompleteExceptionEnabled, printEnabled);
    }

    protected void printSTEntry(final String s) {
        System.out.println(indent + "STEntry: " + s);
    }

    public S visitSTEntry(final STEntry s) throws E {
        throw new UnimplementedException();
    }

}
