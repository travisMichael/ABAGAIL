from visualizationUtils import plot_multiple
from StatsLoader import load_rhc, load_sa, load_ga, load_mimic


def test_sa():
    sa_problem_size_list, sa_max_score_achieved_list, _ = load_sa("FlipFlop/SA_Stats.txt", 4)

    # max_score vs problem_size
    # number of evaluation to achieve max score vs # problem_size
    # time taken to achieve max score vs # problem_size
    plt = plot_multiple(
        sa_problem_size_list,
        sa_max_score_achieved_list,
        ["r", "b", "m", "g"],
        ["model 1", "model 2", "model 3", "model 4"]
    )
    plt.show()
    print("done")


def test_ga():
    ga_problem_size_list, ga_max_score_achieved_list, _ = load_ga("FlipFlop/GA_Stats_salesman_cross_over.txt", 5)
    # max_score vs problem_size
    # number of evaluation to achieve max score vs # problem_size
    # time taken to achieve max score vs # problem_size
    plt = plot_multiple(
        ga_problem_size_list,
        ga_max_score_achieved_list,
        ["r", "b", "m", "g", "y"],
        ["model 1", "model 2", "model 3", "model 4", "model 5"]
    )
    plt.show()
    print("done")


def test_mimic():
    mimic_problem_size_list, mimic_max_score_achieved_list, _ = load_mimic("FlipFlop/MIMIC_Stats.txt", 5)
    # max_score vs problem_size
    # number of evaluation to achieve max score vs # problem_size
    # time taken to achieve max score vs # problem_size
    plt = plot_multiple(
        mimic_problem_size_list,
        mimic_max_score_achieved_list,
        ["r", "b", "m", "g", "y"],
        ["model 1", "model 2", "model 3", "model 4", "model 5"]
    )
    plt.ylabel('Evaluation Score')
    plt.xlabel('Problem Size')
    plt.title('MIMIC Traveling Salesman Results')
    plt.legend(loc="best")
    plt.show()
    print("done")


def test_best():
    problem_size_list, _, rhc_best_score_list = load_rhc("FlipFlop/RHC_Stats.txt", 1)
    _, _, sa_best_score_list = load_sa("FlipFlop/SA_Stats.txt", 4)
    _, _, ga_best_score_list = load_ga("FlipFlop/GA_Stats_single_cross_over.txt", 5)
    _, _, mimic_best_score_list = load_mimic("FlipFlop/MIMIC_Stats.txt", 5)

    best_scores = [rhc_best_score_list, sa_best_score_list, ga_best_score_list, mimic_best_score_list]
    # best_scores = [rhc_best_score_list, sa_best_score_list, ga_best_score_list]

    plt = plot_multiple(
        problem_size_list,
        best_scores,
        ["r", "b", "m", "g"],
        ["RHC", "SA", "GA", "MIMIC"]
    )
    plt.show()
    print("done")


if __name__ == "__main__":
    # print(len(sys.argv))
    # data_set = sys.argv[1]
    test_mimic()

