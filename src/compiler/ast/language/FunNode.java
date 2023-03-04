package compiler.ast.language;

import compiler.ast.BaseASTVisitor;
import compiler.lib.node.DecNode;
import compiler.lib.node.Node;
import compiler.lib.node.TypeNode;

import java.util.Collections;
import java.util.List;

public class FunNode extends DecNode {
    public final String id;
    public final List<ParNode> parlist;
    public final List<DecNode> declist;
    public final Node exp;
    public final TypeNode retType;

    public FunNode(String i, TypeNode rt, List<ParNode> pl, List<DecNode> dl, Node e) {
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
