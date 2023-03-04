package compiler.ast.value;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.Node;

public class IntNode extends Node {
    public final Integer val;

    public IntNode(Integer n) {
        val = n;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }

}
