package compiler.ast.value;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.Node;
import compiler.lib.node.TypeNode;

public class VarNode extends DecNode {
    final String id;
    final Node exp;

    VarNode(String i, TypeNode t, Node v) {
        id = i;
        type = t;
        exp = v;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
