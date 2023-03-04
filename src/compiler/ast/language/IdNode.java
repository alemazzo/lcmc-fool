package compiler.ast.language;

import compiler.SymbolTableEntry;
import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;

public class IdNode extends Node {
    final String id;
    SymbolTableEntry entry;
    int nl;

    IdNode(String i) {
        id = i;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
