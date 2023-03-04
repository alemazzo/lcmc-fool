package compiler.ast.operator;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;

public class PlusNode extends Node {
    public final Node left;
    public final Node right;

    public PlusNode(Node l, Node r) {
        left = l;
        right = r;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
