package compiler.ast.language;

import compiler.lib.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.Node;
import compiler.lib.node.TypeNode;

import java.util.Collections;
import java.util.List;

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
