package compiler.ast.language;

import compiler.SymbolTableEntry;
import compiler.lib.BaseASTVisitor;
import compiler.lib.node.Node;

import java.util.Collections;
import java.util.List;

public class CallNode extends Node {
    final String id;
    final List<Node> arglist;
    SymbolTableEntry entry;
    int nl;

    CallNode(String i, List<Node> p) {
        id = i;
        arglist = Collections.unmodifiableList(p);
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}
