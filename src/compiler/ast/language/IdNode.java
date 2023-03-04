package compiler.ast.language;

import compiler.ast.BaseASTVisitor;
import compiler.east.STEntry;
import compiler.lib.node.Node;

public class IdNode extends Node {
    public final String id;
    public STEntry entry;
    public int nl;

    public IdNode(final String i) {
        id = i;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
