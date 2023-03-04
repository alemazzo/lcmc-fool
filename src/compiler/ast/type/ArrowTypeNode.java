package compiler.ast.type;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.TypeNode;

import java.util.Collections;
import java.util.List;

public class ArrowTypeNode extends TypeNode {
    public final List<TypeNode> parlist;
    public final TypeNode ret;

    public ArrowTypeNode(final List<TypeNode> p, final TypeNode r) {
        parlist = Collections.unmodifiableList(p);
        ret = r;
    }

    @Override
    public <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
