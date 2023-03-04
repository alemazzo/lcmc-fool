package compiler.lib.visit;

/**
 * Interface for AST visitors.
 */
public interface Visitor<S, E extends Exception> {

    /**
     * Visit a visitable node.
     *
     * @param visitable - the visitable to visit
     * @return the result of the visit
     * @throws E - if the visitor throws an exception
     */
    default S visit(final Visitable visitable) throws E {
        return visit(visitable, "");
    }

    /**
     * Visit a visitable node with a mark.
     *
     * @param visitable - the visitable to visit
     * @param mark      - a string to mark the visit
     * @return the result of the visit
     * @throws E - if the visitor throws an exception
     */
    S visit(final Visitable visitable, final String mark) throws E;

}
