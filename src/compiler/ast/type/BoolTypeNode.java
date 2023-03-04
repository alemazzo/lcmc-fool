package compiler.ast.type;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.TypeNode;

public class BoolTypeNode extends TypeNode {

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
