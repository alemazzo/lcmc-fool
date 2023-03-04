package compiler.ast.value;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;

public class IntNode extends Node {
    final Integer val;

    IntNode(Integer n) {
        val = n;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }

}
