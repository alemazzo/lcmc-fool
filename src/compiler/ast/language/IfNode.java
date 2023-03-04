package compiler.ast.language;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;

public class IfNode extends Node {
    final Node cond;
    final Node th;
    final Node el;

    IfNode(Node c, Node t, Node e) {
        cond = c;
        th = t;
        el = e;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
