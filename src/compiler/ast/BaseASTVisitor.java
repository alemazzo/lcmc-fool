package compiler.ast;

import compiler.ast.language.*;
import compiler.ast.operator.EqualNode;
import compiler.ast.operator.PlusNode;
import compiler.ast.operator.TimesNode;
import compiler.ast.type.ArrowTypeNode;
import compiler.ast.type.BoolTypeNode;
import compiler.ast.type.IntTypeNode;
import compiler.ast.value.BoolNode;
import compiler.ast.value.IntNode;
import compiler.ast.value.VarNode;
import compiler.lib.exc.IncompleteException;
import compiler.lib.exc.UnimplementedException;
import compiler.lib.node.Node;
import compiler.lib.visit.Visitable;
import compiler.lib.visit.Visitor;

import static compiler.lib.FOOL.extractNodeName;

public class BaseASTVisitor<S, E extends Exception> implements Visitor<S, E> {

    /**
     * enables printing
     */
    protected final boolean printEnabled;

    /**
     * enables throwing IncompleteException
     */
    private final boolean incompleteExceptionEnabled;

    protected String indent;

    protected BaseASTVisitor() {
        this(false, false);
    }

    protected BaseASTVisitor(final boolean incompleteExceptionEnabled) {
        this(incompleteExceptionEnabled, false);
    }

    protected BaseASTVisitor(final boolean incompleteExceptionEnabled, final boolean printEnabled) {
        this.incompleteExceptionEnabled = incompleteExceptionEnabled;
        this.printEnabled = printEnabled;
    }

    protected void printNode(final Node node) {
        System.out.println(indent + extractNodeName(node.getClass().getName()));
    }

    protected void printNode(final Node node, final String mark) {
        System.out.println(indent + extractNodeName(node.getClass().getName()) + ": " + mark);
    }

    @Override
    public S visit(final Visitable visitable) throws E {
        // performs unmarked visit
        return visit(visitable, "");
    }

    @Override
    public S visit(final Visitable visitable, final String mark) throws E {
        // when printing marks this visit with string mark
        if (visitable == null) {
            if (incompleteExceptionEnabled) throw new IncompleteException();
            else return null;
        }
        if (printEnabled) {
            String temp = indent;
            indent = (indent == null) ? "" : indent + "  ";
            indent += mark; // inserts mark
            try {
                return visitByAcc(visitable);
            } finally {
                indent = temp;
            }
        } else {
            return visitByAcc(visitable);
        }
    }

    private S visitByAcc(final Visitable visitable) throws E {
        return visitable.accept(this);
    }

    public S visitNode(final ProgLetInNode progLetInNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final ProgNode progNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final FunNode funNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final ParNode parNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final VarNode varNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final PrintNode printNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final IfNode ifNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final EqualNode equalNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final TimesNode timesNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final PlusNode plusNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final CallNode callNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final IdNode idNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final BoolNode boolNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final IntNode intNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final ArrowTypeNode arrowTypeNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final BoolTypeNode boolTypeNode) throws E {
        throw new UnimplementedException();
    }

    public S visitNode(final IntTypeNode intTypeNode) throws E {
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