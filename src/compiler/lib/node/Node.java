package compiler.lib.node;

import compiler.ast.BaseASTVisitor;
import compiler.lib.visit.Visitable;

/**
 * A node in the AST.
 */
public abstract class Node implements Visitable {

    private int line = -1;  // line -1 means unset

    public int getLine() {
        return line;
    }

    public void setLine(final int l) {
        line = l;
    }

    abstract public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E;

}

	  