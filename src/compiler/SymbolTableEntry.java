package compiler;

import compiler.lib.BaseASTVisitor;
import compiler.lib.BaseEASTVisitor;
import compiler.lib.node.TypeNode;

public class SymbolTableEntry {
    final int nl;
    final TypeNode type;
    final int offset;

    public SymbolTableEntry(int n, TypeNode t, int o) {
        nl = n;
        type = t;
        offset = o;
    }
    
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return ((BaseEASTVisitor<S, E>) visitor).visitSTentry(this);
    }
}
