package compiler.lib.visit;

/**
 * Interface for AST visitors.
 */
public interface Visitor<S, E extends Exception> {

    /**
     * Visit a visitable node.
     *
     * @param v - the visitable to visit
     * @return the result of the visit
     * @throws E - if the visitor throws an exception
     */
    S visit(Visitable v) throws E;

    /**
     * Visit a visitable node with a mark.
     *
     * @param v - the visitable to visit
     * @param mark - a string to mark the visit
     * @return the result of the visit
     * @throws E - if the visitor throws an exception
     */
    S visit(Visitable v, String mark) throws E;

}
