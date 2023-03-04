package compiler.ast.language;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;
import compiler.lib.stentry.STEntry;

public class IdNode extends Node {
    public final String id;
    public STEntry entry;
    public int nl;

    public IdNode(String i) {
        id = i;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
