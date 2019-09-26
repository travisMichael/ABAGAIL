package opt.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dist.DiscreteDependencyTree;
import dist.DiscreteUniformDistribution;
import dist.Distribution;

import opt.DiscreteChangeOneNeighbor;
import opt.EvaluationFunction;
import opt.GenericHillClimbingProblem;
import opt.HillClimbingProblem;
import opt.NeighborFunction;
import opt.RandomizedHillClimbing;
import opt.SimulatedAnnealing;
import opt.example.*;
import opt.ga.*;
import opt.prob.GenericProbabilisticOptimizationProblem;
import opt.prob.MIMIC;
import opt.prob.ProbabilisticOptimizationProblem;
import shared.FixedIterationTrainer;

/**
 * A test using the flip flop evaluation function
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public class FlipFlopTest {
    /** The n value */
    private static final int N = 500;
    
    public static void main(String[] args) {
        int[] ranges = new int[N];
        Arrays.fill(ranges, 2);
        EvaluationFunction ef = new FlipFlopEvaluationFunction();
        Distribution odd = new DiscreteUniformDistribution(ranges);
        NeighborFunction nf = new DiscreteChangeOneNeighbor(ranges);
        MutationFunction mf = new DiscreteChangeOneMutation(ranges);
        CrossoverFunction cf = new SingleCrossOver();
        Distribution df = new DiscreteDependencyTree(.1, ranges); 
        HillClimbingProblem hcp = new GenericHillClimbingProblem(ef, odd, nf);
        GeneticAlgorithmProblem gap = new GenericGeneticAlgorithmProblem(ef, odd, mf, cf);
        ProbabilisticOptimizationProblem pop = new GenericProbabilisticOptimizationProblem(ef, odd, df);

        runMultipleTests();
        
//        RandomizedHillClimbing rhc = new RandomizedHillClimbing(hcp);
//        FixedIterationTrainer fit = new FixedIterationTrainer(rhc, 200000);
//        fit.train();
//        System.out.println(ef.value(rhc.getOptimal()));
//
//        SimulatedAnnealing sa = new SimulatedAnnealing(100, .95, hcp);
//        fit = new FixedIterationTrainer(sa, 200000);
//        fit.train();
//        System.out.println(ef.value(sa.getOptimal()));
//
//        StandardGeneticAlgorithm ga = new StandardGeneticAlgorithm(200, 100, 20, gap);
//        fit = new FixedIterationTrainer(ga, 1000);
//        fit.train();
//        System.out.println(ef.value(ga.getOptimal()));
//
//        MIMIC mimic = new MIMIC(200, 5, pop);
//        fit = new FixedIterationTrainer(mimic, 1000);
//        fit.train();
//        System.out.println(ef.value(mimic.getOptimal()));
    }

    private static void runMultipleTests() {
        int n_1 = 100;
        int n_2 = 200;
        int n_3 = 300;
        int n_4 = 400;
        int n_5 = 500;

        List<Integer> problemSizeList = new ArrayList<>();
        problemSizeList.add(n_1);
        problemSizeList.add(n_2);
        problemSizeList.add(n_3);
        problemSizeList.add(n_4);
        problemSizeList.add(n_5);

        int[] ranges = new int[n_1];
        Arrays.fill(ranges, 2);
        EvaluationFunction ef_1 = new FlipFlopEvaluationFunction();
        Distribution odd_1 = new DiscreteUniformDistribution(ranges);
        NeighborFunction nf_1 = new DiscreteChangeOneNeighbor(ranges);
        MutationFunction mf_1 = new DiscreteChangeOneMutation(ranges);
        CrossoverFunction cf_single_1 = new SingleCrossOver();
        CrossoverFunction cf_double_1 = new TwoPointCrossOver();
        CrossoverFunction cf_uniform_1 = new UniformCrossOver();
        Distribution df_1 = new DiscreteDependencyTree(.1, ranges);
        HillClimbingProblem hcp_1 = new GenericHillClimbingProblem(ef_1, odd_1, nf_1);
        GeneticAlgorithmProblem gap_single_1 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_single_1);
        GeneticAlgorithmProblem gap_double_1 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_double_1);
        GeneticAlgorithmProblem gap_uniform_1 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_uniform_1);
        ProbabilisticOptimizationProblem pop_1 = new GenericProbabilisticOptimizationProblem(ef_1, odd_1, df_1);

        ranges = new int[n_2];
        Arrays.fill(ranges, 2);
        EvaluationFunction ef_2 = new FlipFlopEvaluationFunction();
        Distribution odd_2 = new DiscreteUniformDistribution(ranges);
        NeighborFunction nf_2 = new DiscreteChangeOneNeighbor(ranges);
        MutationFunction mf_2 = new DiscreteChangeOneMutation(ranges);
        CrossoverFunction cf_2 = new SingleCrossOver();
        CrossoverFunction cf_double_2 = new TwoPointCrossOver();
        CrossoverFunction cf_uniform_2 = new UniformCrossOver();
        Distribution df_2 = new DiscreteDependencyTree(.1, ranges);
        HillClimbingProblem hcp_2 = new GenericHillClimbingProblem(ef_2, odd_2, nf_2);
        GeneticAlgorithmProblem gap_2 = new GenericGeneticAlgorithmProblem(ef_2, odd_2, mf_2, cf_2);
        GeneticAlgorithmProblem gap_double_2 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_double_1);
        GeneticAlgorithmProblem gap_uniform_2 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_uniform_1);
        ProbabilisticOptimizationProblem pop_2 = new GenericProbabilisticOptimizationProblem(ef_2, odd_2, df_2);

        ranges = new int[n_3];
        Arrays.fill(ranges, 2);
        EvaluationFunction ef_3 = new FlipFlopEvaluationFunction();
        Distribution odd_3 = new DiscreteUniformDistribution(ranges);
        NeighborFunction nf_3 = new DiscreteChangeOneNeighbor(ranges);
        MutationFunction mf_3 = new DiscreteChangeOneMutation(ranges);
        CrossoverFunction cf_3 = new SingleCrossOver();
        CrossoverFunction cf_double_3 = new TwoPointCrossOver();
        CrossoverFunction cf_uniform_3 = new UniformCrossOver();
        Distribution df_3 = new DiscreteDependencyTree(.1, ranges);
        HillClimbingProblem hcp_3 = new GenericHillClimbingProblem(ef_3, odd_3, nf_3);
        GeneticAlgorithmProblem gap_3 = new GenericGeneticAlgorithmProblem(ef_3, odd_3, mf_3, cf_3);
        GeneticAlgorithmProblem gap_double_3 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_double_1);
        GeneticAlgorithmProblem gap_uniform_3 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_uniform_1);
        ProbabilisticOptimizationProblem pop_3 = new GenericProbabilisticOptimizationProblem(ef_3, odd_3, df_3);

        ranges = new int[n_4];
        Arrays.fill(ranges, 2);
        EvaluationFunction ef_4 = new FlipFlopEvaluationFunction();
        Distribution odd_4 = new DiscreteUniformDistribution(ranges);
        NeighborFunction nf_4 = new DiscreteChangeOneNeighbor(ranges);
        MutationFunction mf_4 = new DiscreteChangeOneMutation(ranges);
        CrossoverFunction cf_4 = new SingleCrossOver();
        CrossoverFunction cf_double_4 = new TwoPointCrossOver();
        CrossoverFunction cf_uniform_4 = new UniformCrossOver();
        Distribution df_4 = new DiscreteDependencyTree(.1, ranges);
        HillClimbingProblem hcp_4 = new GenericHillClimbingProblem(ef_4, odd_4, nf_4);
        GeneticAlgorithmProblem gap_4 = new GenericGeneticAlgorithmProblem(ef_4, odd_4, mf_4, cf_4);
        GeneticAlgorithmProblem gap_double_4 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_double_1);
        GeneticAlgorithmProblem gap_uniform_4 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_uniform_1);
        ProbabilisticOptimizationProblem pop_4 = new GenericProbabilisticOptimizationProblem(ef_4, odd_4, df_4);

        ranges = new int[n_5];
        Arrays.fill(ranges, 2);
        EvaluationFunction ef_5 = new FlipFlopEvaluationFunction();
        Distribution odd_5 = new DiscreteUniformDistribution(ranges);
        NeighborFunction nf_5 = new DiscreteChangeOneNeighbor(ranges);
        MutationFunction mf_5 = new DiscreteChangeOneMutation(ranges);
        CrossoverFunction cf_5 = new SingleCrossOver();
        CrossoverFunction cf_double_5 = new TwoPointCrossOver();
        CrossoverFunction cf_uniform_5 = new UniformCrossOver();
        Distribution df_5 = new DiscreteDependencyTree(.1, ranges);
        HillClimbingProblem hcp_5 = new GenericHillClimbingProblem(ef_5, odd_5, nf_5);
        GeneticAlgorithmProblem gap_5 = new GenericGeneticAlgorithmProblem(ef_5, odd_5, mf_5, cf_5);
        GeneticAlgorithmProblem gap_double_5 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_double_5);
        GeneticAlgorithmProblem gap_uniform_5 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_uniform_5);
        ProbabilisticOptimizationProblem pop_5 = new GenericProbabilisticOptimizationProblem(ef_5, odd_5, df_5);

        // sa lists
        List<HillClimbingProblem> saProblemList = new ArrayList<>();
        saProblemList.add(hcp_1);
        saProblemList.add(hcp_2);
        saProblemList.add(hcp_3);
        saProblemList.add(hcp_4);
        saProblemList.add(hcp_5);

        List<EvaluationFunction> evaluationFunctionList = new ArrayList<>();
        evaluationFunctionList.add(ef_1);
        evaluationFunctionList.add(ef_2);
        evaluationFunctionList.add(ef_3);
        evaluationFunctionList.add(ef_4);
        evaluationFunctionList.add(ef_5);

        List<Double> tList = new ArrayList<>();
        tList.add(1E5);
        tList.add(1E5);
        tList.add(1E5);
        tList.add(1E5);

        List<Double> coolingList = new ArrayList<>();
        coolingList.add(0.99);
        coolingList.add(0.8);
        coolingList.add(0.6);
        coolingList.add(0.4);

        // ga parameters
        List<GeneticAlgorithmProblem> gaSingleProblemList = new ArrayList<>();
        List<GeneticAlgorithmProblem> gaDoubleProblemList = new ArrayList<>();
        List<GeneticAlgorithmProblem> gaUniformProblemList = new ArrayList<>();
        gaSingleProblemList.add(gap_single_1);
        gaSingleProblemList.add(gap_2);
        gaSingleProblemList.add(gap_3);
        gaSingleProblemList.add(gap_4);
        gaSingleProblemList.add(gap_5);
        gaDoubleProblemList.add(gap_double_1);
        gaDoubleProblemList.add(gap_double_2);
        gaDoubleProblemList.add(gap_double_3);
        gaDoubleProblemList.add(gap_double_4);
        gaDoubleProblemList.add(gap_double_5);
        gaUniformProblemList.add(gap_uniform_1);
        gaUniformProblemList.add(gap_uniform_2);
        gaUniformProblemList.add(gap_uniform_3);
        gaUniformProblemList.add(gap_uniform_4);
        gaUniformProblemList.add(gap_uniform_5);
        List<Integer> populationList = new ArrayList<>();
        populationList.add(500);
        populationList.add(1000);
        populationList.add(2000);
        populationList.add(5000);
        populationList.add(10000);
        List<Integer> toMateList = new ArrayList<>();
        toMateList.add(300);
        toMateList.add(600);
        toMateList.add(1200);
        toMateList.add(3000);
        toMateList.add(6000);
        List<Integer> mutationList = new ArrayList<>();
        mutationList.add(50);
        mutationList.add(100);
        mutationList.add(250);
        mutationList.add(500);
        mutationList.add(1000);

        // mimic parameters
        List<ProbabilisticOptimizationProblem> mimicProblemList = new ArrayList<>();
        mimicProblemList.add(pop_1);
        mimicProblemList.add(pop_2);
        mimicProblemList.add(pop_3);
        mimicProblemList.add(pop_4);
        mimicProblemList.add(pop_5);

        List<Integer> samplesList = new ArrayList<>();
        samplesList.add(100);
        samplesList.add(200);
        samplesList.add(300);
        samplesList.add(400);
        samplesList.add(500);
        List<Integer> toKeepList = new ArrayList<>();
        toKeepList.add(5);
        toKeepList.add(10);
        toKeepList.add(15);
        toKeepList.add(20);
        toKeepList.add(25);

        String directory = "FlipFlop";

//        TestUtility.testRHCWithDifferentProblemSizes(
//                problemSizeList,
//                saProblemList,
//                evaluationFunctionList,
//                directory
//        );
//
//        TestUtility.testSimulatedAnnealingWithDifferentProblemSizes(
//                problemSizeList,
//                saProblemList,
//                evaluationFunctionList,
//                tList,
//                coolingList,
//                directory
//        );

//        TestUtility.testGeneticAlgorithmWithDifferentProblemSizes(
//                problemSizeList,
//                gaSingleProblemList,
//                evaluationFunctionList,
//                populationList,
//                toMateList,
//                mutationList,
//                "single_cross_over",
//                directory
//        );
//
//        TestUtility.testGeneticAlgorithmWithDifferentProblemSizes(
//                problemSizeList,
//                gaDoubleProblemList,
//                evaluationFunctionList,
//                populationList,
//                toMateList,
//                mutationList,
//                "two_point_cross_over",
//                directory
//        );
//
        TestUtility.testGeneticAlgorithmWithDifferentProblemSizes(
                problemSizeList,
                gaUniformProblemList,
                evaluationFunctionList,
                populationList,
                toMateList,
                mutationList,
                "uniform_cross_over",
                directory,
                false
        );

        TestUtility.testMIMICWithDifferentProblemSizes(
                problemSizeList,
                mimicProblemList,
                evaluationFunctionList,
                samplesList,
                toKeepList,
                directory,
                false
        );
    }
}
