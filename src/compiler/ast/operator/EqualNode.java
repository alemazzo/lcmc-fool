package compiler.ast.operator;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.Node;

public class EqualNode extends Node {
    public final Node left;
    public final Node right;

    public EqualNode(final Node l, final Node r) {
        left = l;
        right = r;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
