package compiler.ast.language;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.Node;

import java.util.Collections;
import java.util.List;

public class ProgLetInNode extends Node {
    public final List<DecNode> declist;
    public final Node exp;

    public ProgLetInNode(List<DecNode> d, Node e) {
        declist = Collections.unmodifiableList(d);
        exp = e;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
