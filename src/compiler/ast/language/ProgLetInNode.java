package compiler.ast.language;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.Node;

import java.util.Collections;
import java.util.List;

public class ProgLetInNode extends Node {
    public final List<DecNode> declist;
    public final Node exp;

    public ProgLetInNode(final List<DecNode> d, final Node e) {
        declist = Collections.unmodifiableList(d);
        exp = e;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
