package compiler.ast.language;

import compiler.ast.BaseASTVisitor;
import compiler.east.STEntry;
import compiler.lib.node.Node;

import java.util.Collections;
import java.util.List;

public class CallNode extends Node {
    
    public final String id;
    public final List<Node> arglist;
    public STEntry entry;
    public int nl;

    public CallNode(final String i, final List<Node> p) {
        id = i;
        arglist = Collections.unmodifiableList(p);
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
