package shared;

import opt.OptimizationAlgorithm;
import opt.ga.MaxKColorFitnessFunction;

/**
 * A convergence trainer trains a network
 * until convergence, using another trainer
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public class KColorTrainer implements Trainer {
    /** The default threshold */
    private static final double THRESHOLD = 1E-10;
    /** The maxium number of iterations */
    private static final int MAX_ITERATIONS = 500;

    /**
     * The trainer
     */
    private OptimizationAlgorithm trainer;

    /**
     * The threshold
     */
    private double threshold;

    /**
     * The number of iterations trained
     */
    private int iterations;

    /**
     * The maximum number of iterations to use
     */
    private int maxIterations;

    private MaxKColorFitnessFunction ef;

    /**
     * Create a new convergence trainer
     * @param trainer the thrainer to use
     * @param threshold the error threshold
     * @param maxIterations the maximum iterations
     */
    public KColorTrainer(OptimizationAlgorithm trainer, MaxKColorFitnessFunction ef, int maxIterations) {
        this.trainer = trainer;
        this.maxIterations = maxIterations;
        this.ef = ef;
    }


//    /**
//     * Create a new convergence trainer
//     * @param trainer the trainer to use
//     */
//    public KColorTrainer(OptimizationAlgorithm trainer) {
//        this(trainer, MAX_ITERATIONS);
//    }

    /**
     * @see Trainer#train()
     */
    public double train() {
        double lastError;
        double error = Double.MAX_VALUE;
        boolean conflict = true;
        do {
            iterations++;
            lastError = error;
            error = trainer.train();
            ef.value(trainer.getOptimal());
            conflict = ef.hasConflict();

        } while (iterations < maxIterations && conflict);
//        System.out.println("Iter: " + iterations);
//        System.out.println("c: " + conflict);
//        System.out.println(ef.foundConflict());
        return error;
    }

    /**
     * Get the number of iterations used
     * @return the number of iterations
     */
    public int getIterations() {
        return iterations;
    }


}
