package opt;

import shared.Instance;

/**
 * A randomized hill climbing algorithm
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public class RandomizedHillClimbing extends OptimizationAlgorithm {
    
    /**
     * The current optimization data
     */
    private Instance cur;
    
    /**
     * The current value of the data
     */
    private double curVal;

    private int totalValueEvaluations;

    private int totalValueEvaluationsToFindOptimalValue;

    private long beginTime;

    private long timeTakenToFindBestValue;

    /**
     * Make a new randomized hill climbing
     */
    public RandomizedHillClimbing(HillClimbingProblem hcp) {
        super(hcp);
        this.beginTime = System.currentTimeMillis();
        cur = hcp.random();
        curVal = hcp.value(cur);
    }

    /**
     * @see shared.Trainer#train()
     */
    public double train() {
        HillClimbingProblem hcp = (HillClimbingProblem) getOptimizationProblem();
        Instance neigh = hcp.neighbor(cur);
        totalValueEvaluations++;
        double neighVal = hcp.value(neigh);
        if (neighVal > curVal) {
            timeTakenToFindBestValue = System.currentTimeMillis() - beginTime;
            totalValueEvaluationsToFindOptimalValue = totalValueEvaluations;
            curVal = neighVal;
            cur = neigh;
        }
        return curVal;
    }

    public long getTimeTakenToFindBestValue() {
        return timeTakenToFindBestValue;
    }

    public int getTotalValueEvaluationsToFindOptimalValue() {
        return totalValueEvaluationsToFindOptimalValue;
    }

    /**
     * @see opt.OptimizationAlgorithm#getOptimalData()
     */
    public Instance getOptimal() {
        return cur;
    }

}
