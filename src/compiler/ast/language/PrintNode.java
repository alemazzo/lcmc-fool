package compiler.ast.language;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;

public class PrintNode extends Node {
    public final Node exp;

    public PrintNode(Node e) {
        exp = e;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
