from generateTravelingSalesmanPlots import plot_sa_ts, plot_ga_ts, plot_mimic_ts, plot_best_ts
from generateFlipFlopPlots import plot_sa_ff, plot_ga_ff, plot_mimic_ff, plot_best_ff
from generateKColoringPlots import plot_best_kc, plot_evaluations_kc


if __name__ == "__main__":
    # print(len(sys.argv))
    # data_set = sys.argv[1]
    plot_sa_ts()
    plot_ga_ts()
    plot_mimic_ts()
    plot_best_ts()
    plot_sa_ff()
    plot_ga_ff()
    plot_mimic_ff()
    plot_best_ff()
    plot_best_kc()
    plot_evaluations_kc()
