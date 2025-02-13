from visualizationUtils import plot_multiple
from StatsLoader import load_rhc, load_sa, load_ga, load_mimic


def plot_sa_ts():
    sa_problem_size_list, sa_max_score_achieved_list, _ = load_sa("TravelingSalesman/SA_Stats.txt", 4)

    # max_score vs problem_size
    # number of evaluation to achieve max score vs # problem_size
    # time taken to achieve max score vs # problem_size
    plt = plot_multiple(
        sa_problem_size_list,
        sa_max_score_achieved_list,
        ["r", "b", "m", "g"],
        ["model 1", "model 2", "model 3", "model 4"]
    )
    # plt.show()
    plt.xlabel('Problem Size')
    plt.ylabel('Optimal Value Achieved')
    plt.title('Optimal Values Achieved for SA Algorithms')
    plt.legend()
    # plt.show()
    plt.savefig("TravelingSalesman/SA_plot.png")

    print("done")


def plot_ga_ts():
    ga_problem_size_list, ga_max_score_achieved_list, _, _ = load_ga("TravelingSalesman/GA_Stats_salesman_cross_over.txt", 5)
    # max_score vs problem_size
    # number of evaluation to achieve max score vs # problem_size
    # time taken to achieve max score vs # problem_size
    plt = plot_multiple(
        ga_problem_size_list,
        ga_max_score_achieved_list,
        ["r", "b", "m", "g", "y"],
        ["model 1", "model 2", "model 3", "model 4", "model 5"]
    )
    # plt.show()
    plt.xlabel('Problem Size')
    plt.ylabel('Optimal Value Achieved')
    plt.title('Optimal Values Achieved for GA Algorithms')
    plt.legend()
    # plt.show()
    plt.savefig("TravelingSalesman/GA_plot.png")
    print("done")


def plot_mimic_ts():
    mimic_problem_size_list, mimic_max_score_achieved_list, _, _ = load_mimic("TravelingSalesman/MIMIC_Stats.txt", 5)
    # max_score vs problem_size
    # number of evaluation to achieve max score vs # problem_size
    # time taken to achieve max score vs # problem_size
    plt = plot_multiple(
        mimic_problem_size_list,
        mimic_max_score_achieved_list,
        ["r", "b", "m", "g", "y"],
        ["model 1", "model 2", "model 3", "model 4", "model 5"]
    )
    # plt.ylabel('Evaluation Score')
    # plt.xlabel('Problem Size')
    # plt.title('MIMIC Traveling Salesman Results')
    # plt.legend(loc="best")
    # plt.show()
    plt.xlabel('Problem Size')
    plt.ylabel('Optimal Value Achieved')
    plt.title('Optimal Values Achieved for MIMIC Algorithms')
    plt.legend()
    # plt.show()
    plt.savefig("TravelingSalesman/MIMIC_plot.png")
    print("done")


def plot_best_ts():
    problem_size_list, _, rhc_best_score_list = load_rhc("TravelingSalesman/RHC_Stats.txt", 1)
    _, _, sa_best_score_list = load_sa("TravelingSalesman/SA_Stats.txt", 4)
    _, _, ga_best_score_list, _ = load_ga("TravelingSalesman/GA_Stats_salesman_cross_over.txt", 5)
    _, _, mimic_best_score_list, _ = load_mimic("TravelingSalesman/MIMIC_Stats.txt", 5)

    best_scores = [rhc_best_score_list, sa_best_score_list, ga_best_score_list, mimic_best_score_list]
    # best_scores = [rhc_best_score_list, sa_best_score_list, ga_best_score_list]

    plt = plot_multiple(
        problem_size_list,
        best_scores,
        ["r", "b", "m", "g"],
        ["RHC", "SA", "GA", "MIMIC"]
    )

    plt.xlabel('Problem Size')
    plt.ylabel('Optimal Value Achieved')
    plt.title('Optimal Values Achieved by Algorithm')
    plt.legend()
    # plt.show()
    plt.savefig("TravelingSalesman/best_model_plot.png")
    print("done")


if __name__ == "__main__":
    # print(len(sys.argv))
    # data_set = sys.argv[1]
    plot_sa_ts()

