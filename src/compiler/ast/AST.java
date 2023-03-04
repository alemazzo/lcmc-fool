package compiler.ast;

import compiler.SymbolTableEntry;
import compiler.lib.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.Node;
import compiler.lib.node.TypeNode;

import java.util.Collections;
import java.util.List;

public static class CallNode extends Node {
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

public static class IdNode extends Node {
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

public class AST {


}

public class ProgLetInNode extends Node {
    final List<DecNode> declist;
    final Node exp;

    ProgLetInNode(List<DecNode> d, Node e) {
        declist = Collections.unmodifiableList(d);
        exp = e;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}

public class ProgNode extends Node {
    final Node exp;

    ProgNode(Node e) {
        exp = e;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}

public class FunNode extends DecNode {
    final String id;
    final TypeNode retType;
    final List<ParNode> parlist;
    final List<DecNode> declist;
    final Node exp;

    FunNode(String i, TypeNode rt, List<ParNode> pl, List<DecNode> dl, Node e) {
        id = i;
        retType = rt;
        parlist = Collections.unmodifiableList(pl);
        declist = Collections.unmodifiableList(dl);
        exp = e;
    }

    //void setType(TypeNode t) {type = t;}

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}

public class ParNode extends DecNode {
    final String id;

    ParNode(String i, TypeNode t) {
        id = i;
        type = t;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}

public class PrintNode extends Node {
    final Node exp;

    PrintNode(Node e) {
        exp = e;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}

public class IfNode extends Node {
    final Node cond;
    final Node th;
    final Node el;

    IfNode(Node c, Node t, Node e) {
        cond = c;
        th = t;
        el = e;
    }

    @Override
    public <S, E extends Exception> S accept(BaseASTVisitor<S, E> visitor) throws E {
        return visitor.visitNode(this);
    }
}

