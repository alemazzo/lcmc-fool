package compiler.ast.type;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.TypeNode;

import java.util.Collections;
import java.util.List;

public class ArrowTypeNode extends TypeNode {
    final List<TypeNode> parlist;
    final TypeNode ret;

    ArrowTypeNode(List<TypeNode> p, TypeNode r) {
        parlist = Collections.unmodifiableList(p);
        ret = r;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
