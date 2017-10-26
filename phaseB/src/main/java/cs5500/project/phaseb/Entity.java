package cs5500.project.phaseb;

/**
 * Interface that provides visitor method for all the Entities of the system
 */
public interface Entity {
    /**
     * Accepts and forwards the visitor to associated entities
     * @param visitor
     */
    public void accept(EntityVisitor visitor);
}