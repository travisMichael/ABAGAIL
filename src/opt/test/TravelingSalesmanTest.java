package opt.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import dist.DiscreteDependencyTree;
import dist.DiscretePermutationDistribution;
import dist.DiscreteUniformDistribution;
import dist.Distribution;

import opt.*;
import opt.example.*;
import opt.ga.CrossoverFunction;
import opt.ga.SwapMutation;
import opt.ga.GenericGeneticAlgorithmProblem;
import opt.ga.GeneticAlgorithmProblem;
import opt.ga.MutationFunction;
import opt.ga.StandardGeneticAlgorithm;
import opt.prob.GenericProbabilisticOptimizationProblem;
import opt.prob.MIMIC;
import opt.prob.ProbabilisticOptimizationProblem;
import shared.FixedIterationTrainer;

/**
 * 
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public class TravelingSalesmanTest {
    /** The n value */
    private static final int N = 40;
    /**
     * The test main
     * @param args ignored
     */
    public static void main(String[] args) {
        Random random = new Random();
        // create the random points
        double[][] points = new double[N][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = random.nextDouble();
            points[i][1] = random.nextDouble();   
        }
        // for rhc, sa, and ga we use a permutation based encoding
        TravelingSalesmanEvaluationFunction ef = new TravelingSalesmanRouteEvaluationFunction(points);
        Distribution odd = new DiscretePermutationDistribution(N);
        NeighborFunction nf = new SwapNeighbor();
        MutationFunction mf = new SwapMutation();
        CrossoverFunction cf = new TravelingSalesmanCrossOver(ef);
        HillClimbingProblem hcp = new GenericHillClimbingProblem(ef, odd, nf);
        GeneticAlgorithmProblem gap = new GenericGeneticAlgorithmProblem(ef, odd, mf, cf);

        runMultipleTests();
        
//        RandomizedHillClimbing rhc = new RandomizedHillClimbing(hcp);
//        FixedIterationTrainer fit = new FixedIterationTrainer(rhc, 200000);
//        fit.train();
//        System.out.println(ef.value(rhc.getOptimal()));
//
//        SimulatedAnnealing sa = new SimulatedAnnealing(1E12, .95, hcp);
//        fit = new FixedIterationTrainer(sa, 200000);
//        fit.train();
//        System.out.println(ef.value(sa.getOptimal()));
//
//        StandardGeneticAlgorithm ga = new StandardGeneticAlgorithm(200, 150, 20, gap);
//        fit = new FixedIterationTrainer(ga, 1000);
//        fit.train();
//        System.out.println(ef.value(ga.getOptimal()));
//
//        // for mimic we use a sort encoding
//        ef = new TravelingSalesmanSortEvaluationFunction(points);
//        int[] ranges = new int[N];
//        Arrays.fill(ranges, N);
//        odd = new  DiscreteUniformDistribution(ranges);
//        Distribution df = new DiscreteDependencyTree(.1, ranges);
//        ProbabilisticOptimizationProblem pop = new GenericProbabilisticOptimizationProblem(ef, odd, df);
        
//        MIMIC mimic = new MIMIC(200, 100, pop);
//        fit = new FixedIterationTrainer(mimic, 1000);
//        fit.train();
//        System.out.println(ef.value(mimic.getOptimal()));
        
    }

    private static void runMultipleTests() {
        int n_1 = 40;
        int n_2 = 60;
        int n_3 = 80;
        int n_4 = 100;
        int n_5 = 120;

        List<Integer> problemSizeList = new ArrayList<>();
        problemSizeList.add(n_1);
        problemSizeList.add(n_2);
        problemSizeList.add(n_3);
        problemSizeList.add(n_4);
        problemSizeList.add(n_5);

        Random random = new Random();
        // 1
        double[][] points = new double[n_1][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = random.nextDouble();
            points[i][1] = random.nextDouble();
        }
        TravelingSalesmanEvaluationFunction ef_1 = new TravelingSalesmanRouteEvaluationFunction(points);
        Distribution odd_1 = new DiscretePermutationDistribution(n_1);
        NeighborFunction nf_1 = new SwapNeighbor();
        HillClimbingProblem hcp_1 = new GenericHillClimbingProblem(ef_1, odd_1, nf_1);
        MutationFunction mf_1 = new SwapMutation();
        CrossoverFunction cf_1 = new TravelingSalesmanCrossOver(ef_1);
        GeneticAlgorithmProblem gap_1 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_1);

        int[] ranges = new int[n_1];
        Arrays.fill(ranges, n_1);
        Distribution df_1 = new DiscreteDependencyTree(.1, ranges);
        ProbabilisticOptimizationProblem pop_1 = new GenericProbabilisticOptimizationProblem(ef_1, odd_1, df_1);

        // 2
        points = new double[n_2][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = random.nextDouble();
            points[i][1] = random.nextDouble();
        }
        TravelingSalesmanEvaluationFunction ef_2 = new TravelingSalesmanRouteEvaluationFunction(points);
        Distribution odd_2 = new DiscretePermutationDistribution(n_2);
        NeighborFunction nf_2 = new SwapNeighbor();
        HillClimbingProblem hcp_2 = new GenericHillClimbingProblem(ef_2, odd_2, nf_2);
        MutationFunction mf_2 = new SwapMutation();
        CrossoverFunction cf_2 = new TravelingSalesmanCrossOver(ef_2);
        GeneticAlgorithmProblem gap_2 = new GenericGeneticAlgorithmProblem(ef_2, odd_2, mf_2, cf_2);

        ranges = new int[n_2];
        Arrays.fill(ranges, n_2);
        Distribution df_2 = new DiscreteDependencyTree(.1, ranges);
        ProbabilisticOptimizationProblem pop_2 = new GenericProbabilisticOptimizationProblem(ef_2, odd_2, df_2);

        // 3
        points = new double[n_3][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = random.nextDouble();
            points[i][1] = random.nextDouble();
        }
        TravelingSalesmanEvaluationFunction ef_3 = new TravelingSalesmanRouteEvaluationFunction(points);
        Distribution odd_3 = new DiscretePermutationDistribution(n_3);
        NeighborFunction nf_3 = new SwapNeighbor();
        HillClimbingProblem hcp_3 = new GenericHillClimbingProblem(ef_3, odd_3, nf_3);
        MutationFunction mf_3 = new SwapMutation();
        CrossoverFunction cf_3 = new TravelingSalesmanCrossOver(ef_3);
        GeneticAlgorithmProblem gap_3 = new GenericGeneticAlgorithmProblem(ef_3, odd_3, mf_3, cf_3);

        ranges = new int[n_3];
        Arrays.fill(ranges, n_3);
        Distribution df_3 = new DiscreteDependencyTree(.1, ranges);
        ProbabilisticOptimizationProblem pop_3 = new GenericProbabilisticOptimizationProblem(ef_3, odd_3, df_3);

        // 4
        points = new double[n_4][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = random.nextDouble();
            points[i][1] = random.nextDouble();
        }
        TravelingSalesmanEvaluationFunction ef_4 = new TravelingSalesmanRouteEvaluationFunction(points);
        Distribution odd_4 = new DiscretePermutationDistribution(n_4);
        NeighborFunction nf_4 = new SwapNeighbor();
        HillClimbingProblem hcp_4 = new GenericHillClimbingProblem(ef_4, odd_4, nf_4);
        MutationFunction mf_4 = new SwapMutation();
        CrossoverFunction cf_4 = new TravelingSalesmanCrossOver(ef_4);
        GeneticAlgorithmProblem gap_4 = new GenericGeneticAlgorithmProblem(ef_4, odd_4, mf_4, cf_4);

        ranges = new int[n_4];
        Arrays.fill(ranges, n_4);
        Distribution df_4 = new DiscreteDependencyTree(.1, ranges);
        ProbabilisticOptimizationProblem pop_4 = new GenericProbabilisticOptimizationProblem(ef_4, odd_4, df_4);

        // 5
        points = new double[n_5][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = random.nextDouble();
            points[i][1] = random.nextDouble();
        }
        TravelingSalesmanEvaluationFunction ef_5 = new TravelingSalesmanRouteEvaluationFunction(points);
        Distribution odd_5 = new DiscretePermutationDistribution(n_5);
        NeighborFunction nf_5 = new SwapNeighbor();
        HillClimbingProblem hcp_5 = new GenericHillClimbingProblem(ef_5, odd_5, nf_5);
        MutationFunction mf_5 = new SwapMutation();
        CrossoverFunction cf_5 = new TravelingSalesmanCrossOver(ef_5);
        GeneticAlgorithmProblem gap_5 = new GenericGeneticAlgorithmProblem(ef_5, odd_5, mf_5, cf_5);

        ranges = new int[n_5];
        Arrays.fill(ranges, n_5);
        Distribution df_5 = new DiscreteDependencyTree(.1, ranges);
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
        tList.add(1E12);
        tList.add(1E12);
        tList.add(1E12);
        tList.add(1E12);

        List<Double> coolingList = new ArrayList<>();
        coolingList.add(0.99);
        coolingList.add(0.9);
        coolingList.add(0.8);
        coolingList.add(0.7);

        // ga parameters
        List<GeneticAlgorithmProblem> gaProblemList = new ArrayList<>();
        gaProblemList.add(gap_1);
        gaProblemList.add(gap_2);
        gaProblemList.add(gap_3);
        gaProblemList.add(gap_4);
        gaProblemList.add(gap_5);
        List<Integer> populationList = new ArrayList<>();
        populationList.add(200);
        populationList.add(300);
        populationList.add(400);
        populationList.add(500);
        populationList.add(600);
        List<Integer> toMateList = new ArrayList<>();
        toMateList.add(150);
        toMateList.add(200);
        toMateList.add(250);
        toMateList.add(300);
        toMateList.add(350);
        List<Integer> mutationList = new ArrayList<>();
        mutationList.add(30);
        mutationList.add(50);
        mutationList.add(70);
        mutationList.add(90);
        mutationList.add(110);


        // mimic parameters
        List<ProbabilisticOptimizationProblem> mimicProblemList = new ArrayList<>();
        mimicProblemList.add(pop_1);
        mimicProblemList.add(pop_2);
        mimicProblemList.add(pop_3);
        mimicProblemList.add(pop_4);
        mimicProblemList.add(pop_5);

        List<Integer> samplesList = new ArrayList<>();
        samplesList.add(150);
        samplesList.add(200);
        samplesList.add(250);
        samplesList.add(300);
        samplesList.add(350);
        List<Integer> toKeepList = new ArrayList<>();
        toKeepList.add(80);
        toKeepList.add(100);
        toKeepList.add(120);
        toKeepList.add(160);
        toKeepList.add(200);

        String directory = "TravelingSalesman";

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
//
        TestUtility.testGeneticAlgorithmWithDifferentProblemSizes(
                problemSizeList,
                gaProblemList,
                evaluationFunctionList,
                populationList,
                toMateList,
                mutationList,
                "salesman_cross_over",
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
