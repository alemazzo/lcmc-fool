package compiler.east;

import compiler.ast.BaseASTVisitor;
import compiler.lib.exc.UnimplementedException;

public class BaseEASTVisitor<S, E extends Exception> extends BaseASTVisitor<S, E> {

    protected BaseEASTVisitor() {
    }

    protected BaseEASTVisitor(boolean ie) {
        super(ie);
    }

    protected BaseEASTVisitor(boolean ie, boolean p) {
        super(ie, p);
    }

    protected void printSTEntry(String s) {
        System.out.println(indent + "STEntry: " + s);
    }

    public S visitSTEntry(final STEntry s) throws E {
        throw new UnimplementedException();
    }
    
}
