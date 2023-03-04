package compiler.ast.value;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.Node;
import compiler.lib.node.TypeNode;

public class VarNode extends DecNode {

    public final String id;

    public final Node exp;

    public VarNode(final String i, final TypeNode t, final Node v) {
        id = i;
        type = t;
        exp = v;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
