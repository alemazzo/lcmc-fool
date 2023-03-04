package compiler.lib;

import compiler.ast.AST.*;
import compiler.ast.type.ArrowTypeNode;
import compiler.ast.type.BoolTypeNode;
import compiler.ast.type.IntTypeNode;
import compiler.lib.exc.IncompleteException;
import compiler.lib.exc.UnimplementedException;
import compiler.lib.node.Node;
import compiler.lib.visit.Visitable;
import compiler.lib.visit.Visitor;

import static compiler.lib.FOOLlib.extractNodeName;

public class BaseASTVisitor<S, E extends Exception> implements Visitor<S, E> {

    protected boolean print;    // enables printing
    protected String indent;
    private boolean incomplExc; // enables throwing IncomplException

    protected BaseASTVisitor() {
    }

    protected BaseASTVisitor(boolean ie) {
        incomplExc = ie;
    }

    protected BaseASTVisitor(boolean ie, boolean p) {
        incomplExc = ie;
        print = p;
    }

    protected void printNode(Node n) {
        System.out.println(indent + extractNodeName(n.getClass().getName()));
    }

    protected void printNode(Node n, String s) {
        System.out.println(indent + extractNodeName(n.getClass().getName()) + ": " + s);
    }

    @Override
    public S visit(Visitable v) throws E {
        return visit(v, "");                //performs unmarked visit
    }

    @Override
    public S visit(Visitable v, String mark) throws E {   //when printing marks this visit with string mark
        if (v == null)
            if (incomplExc) throw new IncompleteException();
            else
                return null;
        if (print) {
            String temp = indent;
            indent = (indent == null) ? "" : indent + "  ";
            indent += mark; //inserts mark
            try {
                S result = visitByAcc(v);
                return result;
            } finally {
                indent = temp;
            }
        } else
            return visitByAcc(v);
    }

    S visitByAcc(Visitable v) throws E {
        return v.accept(this);
    }

    public S visitNode(ProgLetInNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(ProgNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(FunNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(ParNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(VarNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(PrintNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(IfNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(EqualNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(TimesNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(PlusNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(CallNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(IdNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(BoolNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(IntNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(ArrowTypeNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(BoolTypeNode n) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(IntTypeNode n) throws E {
        throw new UnimplementedException();
    }

    // OPERATOR EXTENSION

//	public S visitNode(GreaterEqualNode n) throws E {throw new UnimplException();}
//	public S visitNode(LessEqualNode n) throws E {throw new UnimplException();}
//	public S visitNode(NotNode n) throws E {throw new UnimplException();}
//	public S visitNode(MinusNode n) throws E {throw new UnimplException();}
//	public S visitNode(OrNode n) throws E {throw new UnimplException();}
//	public S visitNode(DivNode n) throws E {throw new UnimplException();}
//	public S visitNode(AndNode n) throws E {throw new UnimplException();}

    // OBJECT-ORIENTED EXTENSION

//	public S visitNode(ClassNode n) throws E {throw new UnimplException();}
//	public S visitNode(FieldNode node) throws E {throw new UnimplException();}
//	public S visitNode(MethodNode n) throws E {throw new UnimplException();}
//	public S visitNode(ClassCallNode node) throws E {throw new UnimplException();}
//	public S visitNode(NewNode n) throws E {throw new UnimplException();}
//	public S visitNode(EmptyNode n) throws E {throw new UnimplException();}
//
//	public S visitNode(ClassTypeNode n) throws E {throw new UnimplException();}
//	public S visitNode(MethodTypeNode n) throws E {throw new UnimplException();}
//	public S visitNode(RefTypeNode n) throws E {throw new UnimplException();}
//	public S visitNode(EmptyTypeNode n) throws E {throw new UnimplException();}

}