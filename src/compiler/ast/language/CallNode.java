package compiler.ast.language;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;
import compiler.lib.stentry.STEntry;

import java.util.Collections;
import java.util.List;

public class CallNode extends Node {
    public final String id;
    public final List<Node> arglist;
    public STEntry entry;
    public int nl;

    public CallNode(String i, List<Node> p) {
        id = i;
        arglist = Collections.unmodifiableList(p);
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}