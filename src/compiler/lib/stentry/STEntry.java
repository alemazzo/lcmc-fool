package compiler.lib.stentry;

import compiler.lib.BaseASTVisitor;
import compiler.lib.BaseEASTVisitor;
import compiler.lib.node.TypeNode;
import compiler.lib.visit.Visitable;

public class STEntry implements Visitable {
    public final TypeNode type;
    public final int nl;
    public final int offset;

    public STEntry(int n, TypeNode t, int o) {
        nl = n;
        type = t;
        offset = o;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return ((BaseEASTVisitor<S, E>) visitor).visitSTentry(this);
    }
}
