package compiler.ast.language;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.Node;

public class ProgNode extends Node {
    public final Node exp;

    public ProgNode(Node e) {
        exp = e;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }

}
