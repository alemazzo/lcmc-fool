package compiler.lib.visit;

import compiler.ast.BaseASTVisitor;

/**
 * Interface for AST nodes that can be visited by a visitor.
 */
public interface Visitable {

    /**
     * Accept a visitor.
     *
     * @param visitor - the visitor
     * @return the result of the visit
     * @throws E - if the visitor throws an exception
     */
    <S, E extends Exception> S accept(final BaseASTVisitor<S, E> visitor) throws E;

}
