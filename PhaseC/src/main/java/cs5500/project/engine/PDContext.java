package cs5500.project.engine;

/**
 * The context for the strategy pattern
 */
public class PDContext {
	private PDStrategy pdStrategy;

	/**
	 * @param strategy the strategy to be used
	 */
	public PDContext(PDStrategy strategy){
		this.pdStrategy = strategy;
	}

	/**
	 * The method that sets the strategy to be performed
	 * @param strategy A Strategy object that defines the strategy
	 */
	public void setStrategy(PDStrategy strategy) {
		this.pdStrategy = strategy;
	}

	/**
	 * Execute the operation with the strategy
	 */
	public void executeStrategy(){
			pdStrategy.checkPlagiarism();
		}
}
