package compiler.ast.language;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.Node;

public class IfNode extends Node {
    public final Node cond;
    public final Node th;
    public final Node el;

    public IfNode(final Node c, final Node t, final Node e) {
        cond = c;
        th = t;
        el = e;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
