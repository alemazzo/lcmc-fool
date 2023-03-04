package compiler.lib;

import compiler.lib.exc.UnimplementedException;
import compiler.lib.stentry.STEntry;

public class BaseEASTVisitor<S, E extends Exception> extends BaseASTVisitor<S, E> {

    protected BaseEASTVisitor() {
    }

    protected BaseEASTVisitor(boolean ie) {
        super(ie);
    }

    protected BaseEASTVisitor(boolean ie, boolean p) {
        super(ie, p);
    }

    protected void printSTentry(String s) {
        System.out.println(indent + "STentry: " + s);
    }

    public S visitSTentry(STEntry s) throws E {
        throw new UnimplementedException();
    }
}
