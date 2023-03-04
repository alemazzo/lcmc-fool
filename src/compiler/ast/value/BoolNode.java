package compiler.ast.value;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;

public static class BoolNode extends Node {
    final Boolean val;

    BoolNode(boolean n) {
        val = n;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
