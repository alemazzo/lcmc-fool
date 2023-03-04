package compiler.ast.operator;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;

public class EqualNode extends Node {
    final Node left;
    final Node right;

    EqualNode(Node l, Node r) {
        left = l;
        right = r;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
