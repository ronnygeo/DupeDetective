package cs5500.project.engine;

import cs5500.project.db.ReportItem;

import java.util.List;

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
	public List<ReportItem> executeStrategy(String code1, String code2){
			return pdStrategy.checkPlagiarism(code1, code2);
		}
}
