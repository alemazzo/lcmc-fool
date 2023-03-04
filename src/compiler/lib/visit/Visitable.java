package compiler.lib.visit;

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
    <S, E extends Exception, V extends Visitor<S, E>> S accept(V visitor) throws E;

}
