package compiler.ast.type;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.TypeNode;

public class IntTypeNode extends TypeNode {

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }

}
