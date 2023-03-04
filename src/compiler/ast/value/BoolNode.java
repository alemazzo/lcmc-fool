package compiler.ast.value;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.Node;

public class BoolNode extends Node {
    public final Boolean val;

    public BoolNode(final boolean n) {
        val = n;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
