package compiler.ast.language;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.TypeNode;

public class ParNode extends DecNode {
    public final String id;

    public ParNode(String i, TypeNode t) {
        id = i;
        type = t;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
