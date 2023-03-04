package compiler.ast.language;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.TypeNode;

public class ParNode extends DecNode {

    public final String id;

    public ParNode(final String i, final TypeNode t) {
        id = i;
        type = t;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
