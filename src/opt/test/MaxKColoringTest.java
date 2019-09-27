package opt.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import opt.example.TravelingSalesmanCrossOver;
import opt.example.TravelingSalesmanEvaluationFunction;
import opt.example.TravelingSalesmanRouteEvaluationFunction;
import opt.ga.MaxKColorFitnessFunction;
import opt.ga.Vertex;

import dist.DiscreteDependencyTree;
import dist.DiscretePermutationDistribution;
import dist.DiscreteUniformDistribution;
import dist.Distribution;
import opt.DiscreteChangeOneNeighbor;
import opt.EvaluationFunction;
import opt.SwapNeighbor;
import opt.GenericHillClimbingProblem;
import opt.HillClimbingProblem;
import opt.NeighborFunction;
import opt.RandomizedHillClimbing;
import opt.SimulatedAnnealing;
import opt.ga.CrossoverFunction;
import opt.ga.DiscreteChangeOneMutation;
import opt.ga.SingleCrossOver;
import opt.ga.SwapMutation;
import opt.ga.GenericGeneticAlgorithmProblem;
import opt.ga.GeneticAlgorithmProblem;
import opt.ga.MutationFunction;
import opt.ga.StandardGeneticAlgorithm;
import opt.ga.UniformCrossOver;
import opt.prob.GenericProbabilisticOptimizationProblem;
import opt.prob.MIMIC;
import opt.prob.ProbabilisticOptimizationProblem;
import shared.ConvergenceTrainer;
import shared.FixedIterationTrainer;
import shared.KColorTrainer;

/**
 * 
 * @author kmandal
 * @version 1.0
 */
public class MaxKColoringTest {
    /** The n value */
    private static final int N = 50; // number of vertices
    private static final int L =12; // L adjacent nodes per vertex
    private static final int K = 50; // K possible colors
    /**
     * The test main
     * @param args ignored
     */
    public static void main(String[] args) {
        Random random = new Random(N*L);
        // create the random velocity
        Vertex[] vertices = new Vertex[N];
        for (int i = 0; i < N; i++) {
            Vertex vertex = new Vertex();
            vertices[i] = vertex;	
            vertex.setAdjMatrixSize(L);
            for(int j = 0; j <L; j++ ){
            	 vertex.getAadjacencyColorMatrix().add(random.nextInt(N*L));
            }
        }
        /*for (int i = 0; i < N; i++) {
            Vertex vertex = vertices[i];
            System.out.println(Arrays.toString(vertex.getAadjacencyColorMatrix().toArray()));
        }*/
        // for rhc, sa, and ga we use a permutation based encoding
        MaxKColorFitnessFunction ef = new MaxKColorFitnessFunction(vertices);
        Distribution odd = new DiscretePermutationDistribution(K);
        NeighborFunction nf = new SwapNeighbor();
        MutationFunction mf = new SwapMutation();
        CrossoverFunction cf = new SingleCrossOver();
        HillClimbingProblem hcp = new GenericHillClimbingProblem(ef, odd, nf);
        GeneticAlgorithmProblem gap = new GenericGeneticAlgorithmProblem(ef, odd, mf, cf);
        
        Distribution df = new DiscreteDependencyTree(.1); 
        ProbabilisticOptimizationProblem pop = new GenericProbabilisticOptimizationProblem(ef, odd, df);
        
        long starttime = System.currentTimeMillis();
//        RandomizedHillClimbing rhc = new RandomizedHillClimbing(hcp);
//        FixedIterationTrainer fit = new FixedIterationTrainer(rhc, 20000);
//        fit.train();
//        System.out.println("RHC: " + ef.value(rhc.getOptimal()));
//        System.out.println(ef.foundConflict());
//        System.out.println("Time : "+ (System.currentTimeMillis() - starttime));
//
//        System.out.println("============================");
////
//        starttime = System.currentTimeMillis();
//        SimulatedAnnealing sa = new SimulatedAnnealing(100, .1, hcp);
//        KColorTrainer fite = new KColorTrainer(sa, ef,50000);
//        fite.train();
//        System.out.println("SA: " + ef.value(sa.getOptimal()));
//        System.out.println(ef.foundConflict());
//        System.out.println("Time : "+ (System.currentTimeMillis() - starttime));
//
//        System.out.println("============================");
//
//        starttime = System.currentTimeMillis();
//        StandardGeneticAlgorithm ga = new StandardGeneticAlgorithm(500, 400, 10, gap);
//        KColorTrainer fitt = new KColorTrainer(ga, ef, 500);
//        fitt.train();
//        System.out.println("GA: " + ef.value(ga.getOptimal()));
//        System.out.println(ga.getTimeTakenToFindBestValue());
//        System.out.println(ga.getTotalValueEvaluationsToFindOptimalValue());
//        System.out.println(ef.foundConflict());
//        System.out.println("Time : "+ (System.currentTimeMillis() - starttime));
//
//        System.out.println("============================");
//
//        starttime = System.currentTimeMillis();
//        MIMIC mimic = new MIMIC(200, 20, pop);
//        KColorTrainer fitIt = new KColorTrainer(mimic,ef, 500);
//        fitIt.train();
//        System.out.println("MIMIC: " + ef.value(mimic.getOptimal()));
//        System.out.println(mimic.getTimeTakenToFindBestValue());
//        System.out.println(mimic.getTotalValueEvaluationsToFindOptimalValue());
//        System.out.println(ef.foundConflict());
//        System.out.println("Time : "+ (System.currentTimeMillis() - starttime));

        runMultipleTests();
        
    }

    private static void runMultipleTests() {
        int k_1 = 10;
        int k_2 = 20;
        int k_3 = 30;
        int k_4 = 40;
        int k_5 = 50;

        List<Integer> problemSizeList = new ArrayList<>();
        problemSizeList.add(k_1);
        problemSizeList.add(k_2);
        problemSizeList.add(k_3);
        problemSizeList.add(k_4);
        problemSizeList.add(k_5);

        Random random = new Random(N*L);
        // create the random velocity
        Vertex[] vertices = new Vertex[N];
        for (int i = 0; i < N; i++) {
            Vertex vertex = new Vertex();
            vertices[i] = vertex;
            vertex.setAdjMatrixSize(L);
            for(int j = 0; j <L; j++ ){
                vertex.getAadjacencyColorMatrix().add(random.nextInt(N*L));
            }
        }
        MaxKColorFitnessFunction ef_1 = new MaxKColorFitnessFunction(vertices);
        Distribution odd_1 = new DiscretePermutationDistribution(k_1);
        NeighborFunction nf_1 = new SwapNeighbor();
        MutationFunction mf_1 = new SwapMutation();
        CrossoverFunction cf_1 = new SingleCrossOver();
        HillClimbingProblem hcp_1 = new GenericHillClimbingProblem(ef_1, odd_1, nf_1);
        GeneticAlgorithmProblem gap_1 = new GenericGeneticAlgorithmProblem(ef_1, odd_1, mf_1, cf_1);

        Distribution df = new DiscreteDependencyTree(.1);
        ProbabilisticOptimizationProblem pop_1 = new GenericProbabilisticOptimizationProblem(ef_1, odd_1, df);

        // 2
        MaxKColorFitnessFunction ef_2 = new MaxKColorFitnessFunction(vertices);
        Distribution odd_2 = new DiscretePermutationDistribution(k_2);
        NeighborFunction nf_2 = new SwapNeighbor();
        MutationFunction mf_2 = new SwapMutation();
        CrossoverFunction cf_2 = new SingleCrossOver();
        HillClimbingProblem hcp_2 = new GenericHillClimbingProblem(ef_2, odd_2, nf_2);
        GeneticAlgorithmProblem gap_2 = new GenericGeneticAlgorithmProblem(ef_2, odd_2, mf_2, cf_2);

        ProbabilisticOptimizationProblem pop_2 = new GenericProbabilisticOptimizationProblem(ef_2, odd_2, df);

        // 3
        MaxKColorFitnessFunction ef_3 = new MaxKColorFitnessFunction(vertices);
        Distribution odd_3 = new DiscretePermutationDistribution(k_3);
        NeighborFunction nf_3 = new SwapNeighbor();
        MutationFunction mf_3 = new SwapMutation();
        CrossoverFunction cf_3 = new SingleCrossOver();
        HillClimbingProblem hcp_3 = new GenericHillClimbingProblem(ef_3, odd_3, nf_3);
        GeneticAlgorithmProblem gap_3 = new GenericGeneticAlgorithmProblem(ef_3, odd_3, mf_3, cf_3);

        ProbabilisticOptimizationProblem pop_3 = new GenericProbabilisticOptimizationProblem(ef_3, odd_3, df);

        // 4
        MaxKColorFitnessFunction ef_4 = new MaxKColorFitnessFunction(vertices);
        Distribution odd_4 = new DiscretePermutationDistribution(k_4);
        NeighborFunction nf_4 = new SwapNeighbor();
        MutationFunction mf_4 = new SwapMutation();
        CrossoverFunction cf_4 = new SingleCrossOver();
        HillClimbingProblem hcp_4 = new GenericHillClimbingProblem(ef_4, odd_4, nf_4);
        GeneticAlgorithmProblem gap_4 = new GenericGeneticAlgorithmProblem(ef_4, odd_4, mf_4, cf_4);

        ProbabilisticOptimizationProblem pop_4 = new GenericProbabilisticOptimizationProblem(ef_4, odd_4, df);

        // 5
        MaxKColorFitnessFunction ef_5 = new MaxKColorFitnessFunction(vertices);
        Distribution odd_5 = new DiscretePermutationDistribution(k_5);
        NeighborFunction nf_5 = new SwapNeighbor();
        MutationFunction mf_5 = new SwapMutation();
        CrossoverFunction cf_5 = new SingleCrossOver();
        HillClimbingProblem hcp_5 = new GenericHillClimbingProblem(ef_5, odd_5, nf_5);
        GeneticAlgorithmProblem gap_5 = new GenericGeneticAlgorithmProblem(ef_5, odd_5, mf_5, cf_5);

        ProbabilisticOptimizationProblem pop_5 = new GenericProbabilisticOptimizationProblem(ef_5, odd_5, df);


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
//        tList.add(1E12);
//        tList.add(1E12);
//        tList.add(1E12);

        List<Double> coolingList = new ArrayList<>();
        coolingList.add(0.99);
//        coolingList.add(0.9);
//        coolingList.add(0.8);
//        coolingList.add(0.7);

        // ga parameters
        List<GeneticAlgorithmProblem> gaProblemList = new ArrayList<>();
        gaProblemList.add(gap_1);
        gaProblemList.add(gap_2);
        gaProblemList.add(gap_3);
        gaProblemList.add(gap_4);
        gaProblemList.add(gap_5);
        List<Integer> populationList = new ArrayList<>();
        populationList.add(500);
//        populationList.add(300);
//        populationList.add(400);
//        populationList.add(500);
//        populationList.add(600);
        List<Integer> toMateList = new ArrayList<>();
        toMateList.add(400);
//        toMateList.add(200);
//        toMateList.add(250);
//        toMateList.add(300);
//        toMateList.add(350);
        List<Integer> mutationList = new ArrayList<>();
        mutationList.add(10);
//        mutationList.add(50);
//        mutationList.add(70);
//        mutationList.add(90);
//        mutationList.add(110);


        // mimic parameters
        List<ProbabilisticOptimizationProblem> mimicProblemList = new ArrayList<>();
        mimicProblemList.add(pop_1);
        mimicProblemList.add(pop_2);
        mimicProblemList.add(pop_3);
        mimicProblemList.add(pop_4);
        mimicProblemList.add(pop_5);

        List<Integer> samplesList = new ArrayList<>();
        samplesList.add(200);
//        samplesList.add(200);
//        samplesList.add(400);
//        samplesList.add(600);
//        samplesList.add(800);
        List<Integer> toKeepList = new ArrayList<>();
        toKeepList.add(20);
//        toKeepList.add(70);
//        toKeepList.add(90);
//        toKeepList.add(110);
//        toKeepList.add(130);

        String directory = "KColoring";

        TestUtility.testRHCWithDifferentProblemSizes(
                problemSizeList,
                saProblemList,
                evaluationFunctionList,
                directory
        );

        TestUtility.testSimulatedAnnealingWithDifferentProblemSizes(
                problemSizeList,
                saProblemList,
                evaluationFunctionList,
                tList,
                coolingList,
                directory
        );

        TestUtility.testGeneticAlgorithmWithDifferentProblemSizes(
                problemSizeList,
                gaProblemList,
                evaluationFunctionList,
                populationList,
                toMateList,
                mutationList,
                "single_cross_over",
                directory,
                true
        );

        TestUtility.testMIMICWithDifferentProblemSizes(
                problemSizeList,
                mimicProblemList,
                evaluationFunctionList,
                samplesList,
                toKeepList,
                directory,
                true
        );

    }
}
