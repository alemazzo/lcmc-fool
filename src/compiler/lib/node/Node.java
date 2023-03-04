package compiler.lib.node;

import compiler.lib.BaseASTVisitor;

/**
 * A node in the AST.
 */
public abstract class Node {

    private int line = -1;  // line -1 means unset

    public int getLine() {
        return line;
    }

    public void setLine(int l) {
        line = l;
    }

    abstract public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E;

}

	  