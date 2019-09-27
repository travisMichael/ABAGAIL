package opt.test;

import opt.EvaluationFunction;
import opt.HillClimbingProblem;
import opt.RandomizedHillClimbing;
import opt.SimulatedAnnealing;
import opt.ga.GeneticAlgorithmProblem;
import opt.ga.MaxKColorFitnessFunction;
import opt.ga.StandardGeneticAlgorithm;
import opt.prob.MIMIC;
import opt.prob.ProbabilisticOptimizationProblem;
import shared.FixedIterationTrainer;
import shared.KColorTrainer;
import shared.Trainer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TestUtility {

    public static void main(String[] args) {
        System.out.println(5 / (double)2);
    }

    public static void writeTestStatsToFile(StringBuilder stats, String directoryName, String fileName) {

        File directory = new File(directoryName);
        if (! directory.exists()){
            directory.mkdir();
            // If you require it to make the entire directory path including parents,
            // use directory.mkdirs(); here instead.
        }

        File file = new File(directoryName + "/" + fileName);
        try{
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(stats.toString());
            bw.close();
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }

    }

    private static void appendStats(
            StringBuilder stringBuilder,
            double totalOptimalValues,
            int totalFunctionEvaluations,
            long totalTimeTakenToRun,
            int trials) {
        stringBuilder.append(totalOptimalValues / trials);
        stringBuilder.append(" ");
        stringBuilder.append(totalFunctionEvaluations / trials);
        stringBuilder.append(" ");
        stringBuilder.append(totalTimeTakenToRun / (double)trials);
        stringBuilder.append("\n");
        System.out.println("functional evaluations: " + totalFunctionEvaluations);
    }

    public static void testRHCWithDifferentProblemSizes(
            List<Integer> problemSizeList,
            List<HillClimbingProblem> problemList,
            List<EvaluationFunction> evalFunctionList,
            String directoryName) {

        StringBuilder algorithmStats = new StringBuilder();

        for (int k = 0; k < problemSizeList.size(); k++) {
            algorithmStats.append(problemSizeList.get(k));
            algorithmStats.append("\n");
            HillClimbingProblem hcp = problemList.get(k);
            EvaluationFunction ef = evalFunctionList.get(k);

            // average the problem results 5 times
            // get max value, number of function evaluations, and time taken to run
            double totalOptimalValues = 0.0;
            int totalFunctionEvaluations = 0;
            long totalTimeTakenToRun = 0;
            int trials = 5;
            for (int j = 0; j < trials; j++) {
                RandomizedHillClimbing rhc = new RandomizedHillClimbing(hcp);
                FixedIterationTrainer fit = new FixedIterationTrainer(rhc, 200000);
                fit.train();
                // System.out.println(ef.value(rhc.getOptimal()));

                // long startTime = System.currentTimeMillis();
                fit.train();
                // long endTime = System.currentTimeMillis();
                totalOptimalValues += ef.value(rhc.getOptimal());
                totalFunctionEvaluations += rhc.getTotalValueEvaluationsToFindOptimalValue();
                totalTimeTakenToRun += rhc.getTimeTakenToFindBestValue();
            }
            appendStats(algorithmStats, totalOptimalValues, totalFunctionEvaluations, totalTimeTakenToRun, trials);

            // System.out.println(algorithmStats);
            writeTestStatsToFile(algorithmStats, directoryName, "RHC_Stats.txt");
        }
    }

    public static void testSimulatedAnnealingWithDifferentProblemSizes(
            List<Integer> problemSizeList,
            List<HillClimbingProblem> problemList,
            List<EvaluationFunction> evalFunctionList,
            List<Double> tList,
            List<Double> coolingList,
            String directoryName) {

        StringBuilder algorithmStats = new StringBuilder();

        for (int k = 0; k < problemSizeList.size(); k++) {
            algorithmStats.append(problemSizeList.get(k));
            algorithmStats.append(" ");
            algorithmStats.append(tList.size());
            algorithmStats.append("\n");
            HillClimbingProblem hcp = problemList.get(k);
            EvaluationFunction ef = evalFunctionList.get(k);

            for (int i = 0; i < tList.size(); i++) {
                Double t = tList.get(i);
                Double cooling = coolingList.get(i);

                algorithmStats.append(t);
                algorithmStats.append(" ");

                algorithmStats.append(cooling);
                algorithmStats.append(" ");

                // average the problem results 5 times
                // get max value, number of function evaluations, and time taken to run
                double totalOptimalValues = 0.0;
                int totalFunctionEvaluations = 0;
                long totalTimeTakenToRun = 0;
                int trials = 5;
                for (int j = 0; j < trials; j++) {
                    SimulatedAnnealing sa = new SimulatedAnnealing(t, cooling, hcp);
                    FixedIterationTrainer fit = new FixedIterationTrainer(sa, 200000);
                    // long startTime = System.currentTimeMillis();
                    fit.train();
                    // long endTime = System.currentTimeMillis();
                    totalOptimalValues += ef.value(sa.getOptimal());
                    totalFunctionEvaluations += sa.getTotalValueEvaluationsToFindOptimalValue();
                    totalTimeTakenToRun += sa.getTimeTakenToFindBestValue();
                }
                appendStats(algorithmStats, totalOptimalValues, totalFunctionEvaluations, totalTimeTakenToRun, trials);
            }
            System.out.println(algorithmStats);
            writeTestStatsToFile(algorithmStats, directoryName, "SA_Stats.txt");
        }
    }

    public static void testGeneticAlgorithmWithDifferentProblemSizes(
            List<Integer> problemSizeList,
            List<GeneticAlgorithmProblem> problemList,
            List<EvaluationFunction> evalFunctionList,
            List<Integer> populationList,
            List<Integer> toMateList,
            List<Integer> mutationList,
            String algorithmType,
            String directoryName,
            boolean isKColorProblem) {

        StringBuilder algorithmStats = new StringBuilder();

        for (int k = 0; k < problemSizeList.size(); k++) {
            algorithmStats.append(problemSizeList.get(k));
            algorithmStats.append(" ");
            algorithmStats.append(populationList.size());
            algorithmStats.append("\n");
            GeneticAlgorithmProblem gap = problemList.get(k);
            EvaluationFunction ef = evalFunctionList.get(k);

            for (int i = 0; i < populationList.size(); i++) {
                Integer population = populationList.get(i);
                Integer toMate = toMateList.get(i);
                Integer mutate = mutationList.get(i);

                algorithmStats.append(population);
                algorithmStats.append(" ");
                algorithmStats.append(toMate);
                algorithmStats.append(" ");
                algorithmStats.append(mutate);
                algorithmStats.append(" ");

                // average the problem results 5 times
                // get max value, number of function evaluations, and time taken to run
                double totalOptimalValues = 0.0;
                int totalFunctionEvaluations = 0;
                long totalTimeTakenToRun = 0;
                int trials = 5;
                if (isKColorProblem) {
                    trials = 10;
                }
                for (int j = 0; j < trials; j++) {
                    StandardGeneticAlgorithm ga = new StandardGeneticAlgorithm(population, toMate, mutate, gap);
                    Trainer fit;
                    if (isKColorProblem) {
                        fit = new KColorTrainer(ga,(MaxKColorFitnessFunction)ef, 1000);
                    } else {
                        fit = new FixedIterationTrainer(ga, 1000);
                    }

                    fit.train();
                    System.out.println(ef.value(ga.getOptimal()) + "  " + ga.getTotalValueEvaluationsToFindOptimalValue());

                    // long startTime = System.currentTimeMillis();
                    fit.train();
                    // long endTime = System.currentTimeMillis();
                    totalOptimalValues += ef.value(ga.getOptimal());
                    totalFunctionEvaluations += ga.getTotalValueEvaluationsToFindOptimalValue();
                    totalTimeTakenToRun += ga.getTimeTakenToFindBestValue();
                }
                appendStats(algorithmStats, totalOptimalValues, totalFunctionEvaluations, totalTimeTakenToRun, trials);
            }
            // System.out.println(algorithmStats);
            writeTestStatsToFile(algorithmStats, directoryName, "GA_Stats_" + algorithmType +".txt");
        }
    }

    public static void testMIMICWithDifferentProblemSizes(
            List<Integer> problemSizeList,
            List<ProbabilisticOptimizationProblem> problemList,
            List<EvaluationFunction> evalFunctionList,
            List<Integer> samplesList,
            List<Integer> toKeepList,
            String directoryName,
            boolean isKColorProblem) {

        StringBuilder algorithmStats = new StringBuilder();

        for (int k = 0; k < problemSizeList.size(); k++) {
            algorithmStats.append(problemSizeList.get(k));
            algorithmStats.append("\n");
            ProbabilisticOptimizationProblem pop = problemList.get(k);
            EvaluationFunction ef = evalFunctionList.get(k);

            // average the problem results 5 times
            // get max value, number of function evaluations, and time taken to run
            for (int i = 0; i < samplesList.size(); i++) {
                Integer samples = samplesList.get(i);
                Integer toKeep = toKeepList.get(i);

                algorithmStats.append(samples);
                algorithmStats.append(" ");
                algorithmStats.append(toKeep);
                algorithmStats.append(" ");

                // average the problem results 5 times
                // get max value, number of function evaluations, and time taken to run
                double totalOptimalValues = 0.0;
                int totalFunctionEvaluations = 0;
                long totalTimeTakenToRun = 0;
                int trials = 3;
                if (isKColorProblem) {
                    trials = 10;
                }
                for (int j = 0; j < trials; j++) {
                    //
                    MIMIC mimic = new MIMIC(samples, toKeep, pop);
                    Trainer fit;
                    if (isKColorProblem) {
                        fit = new KColorTrainer(mimic,(MaxKColorFitnessFunction)ef, 1000);
                    } else {
                        fit = new FixedIterationTrainer(mimic, 1000);
                    }
                    fit.train();
                    System.out.println(ef.value(mimic.getOptimal()) + "   " + mimic.getTotalValueEvaluationsToFindOptimalValue());

                    // long startTime = System.currentTimeMillis();
                    fit.train();
                    // long endTime = System.currentTimeMillis();
                    totalOptimalValues += ef.value(mimic.getOptimal());
                    totalFunctionEvaluations += mimic.getTotalValueEvaluationsToFindOptimalValue();
                    totalTimeTakenToRun += mimic.getTimeTakenToFindBestValue();
                }
                appendStats(algorithmStats, totalOptimalValues, totalFunctionEvaluations, totalTimeTakenToRun, trials);
            }
            // System.out.println(algorithmStats);
            writeTestStatsToFile(algorithmStats, directoryName, "MIMIC_Stats.txt");
        }
    }

}
