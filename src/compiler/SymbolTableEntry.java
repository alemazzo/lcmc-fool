package compiler;

import compiler.lib.BaseASTVisitor;
import compiler.lib.BaseEASTVisitor;
import compiler.lib.node.TypeNode;
import compiler.lib.visit.Visitable;

public class SymbolTableEntry implements Visitable {
    final int nl;
    final TypeNode type;
    final int offset;

    public SymbolTableEntry(int n, TypeNode t, int o) {
        nl = n;
        type = t;
        offset = o;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return ((BaseEASTVisitor<S, E>) visitor).visitSTentry(this);
    }
}
