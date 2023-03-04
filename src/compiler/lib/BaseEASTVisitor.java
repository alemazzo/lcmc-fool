package compiler.lib;

import compiler.SymbolTableEntry;
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

    protected void printSTentry(String s) {
        System.out.println(indent + "STentry: " + s);
    }

    public S visitSTentry(SymbolTableEntry s) throws E {
        throw new UnimplementedException();
    }
}
