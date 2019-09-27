import matplotlib.pyplot as plt
import numpy as np


def plot_multiple(x, y, color_list, label_list):
    plt.figure()
    # plt.legend(loc="best")
    for i in range(len(y)):
        plt.plot(x, y[i], '-o', color=color_list[i], label=label_list[i])
    return plt


def plot_bar_graph(x):
    n_groups = 5
    means_rhc = x[0] # (90, 55, 40, 65)
    means_sa = x[1] # (85, 62, 54, 20)
    means_ga = x[2]
    means_mimic = x[3]

    # create plot
    fig, ax = plt.subplots()
    index = np.arange(n_groups)
    bar_width = 0.2
    opacity = 0.8

    rects1 = plt.bar(index, means_rhc, bar_width,
                 alpha=opacity,
                 color='r',
                 label='RHC')

    rects2 = plt.bar(index + bar_width, means_sa, bar_width,
                 alpha=opacity,
                 color='b',
                 label='SA')

    rects3 = plt.bar(index + 2 * bar_width, means_mimic, bar_width,
                     alpha=opacity,
                     color='m',
                     label='GA')

    rects4 = plt.bar(index + 3 * bar_width, means_mimic, bar_width,
                     alpha=opacity,
                     color='g',
                     label='MIMIC')

    plt.xlabel('Problem Size')
    plt.ylabel('Optimal Value Achieved')
    plt.title('Optimal Values Achieved by Algorithm')
    plt.xticks(index + bar_width, ('10', '20', '30', '40', '50'))
    plt.legend()

    plt.tight_layout()
    return plt

