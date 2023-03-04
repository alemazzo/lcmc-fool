package compiler.ast.language;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.Node;

import java.util.Collections;
import java.util.List;

public class ProgLetInNode extends Node {
    final List<DecNode> declist;
    final Node exp;

    ProgLetInNode(List<DecNode> d, Node e) {
        declist = Collections.unmodifiableList(d);
        exp = e;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
