package compiler.ast.language;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.Node;

public class PrintNode extends Node {

    public final Node exp;

    public PrintNode(final Node e) {
        exp = e;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
