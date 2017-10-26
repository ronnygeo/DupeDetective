package phaseb;

/**
 * Interface provides accept() method for all the Entities of the system
 */
public interface Entity {
    /**
     * Accepts the EntityVisitor and passes the respective Entity
     *
     * @param entityVisitor
     */
    public void accept(EntityVisitor entityVisitor);
}