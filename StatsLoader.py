

def load_rhc(problem):
    print("Loading sa stats...")

    with open(problem + '/RHC_Stats.txt') as fp:
        line = fp.readline()
        cnt = 1
        problem_size_list = []
        max_score_achieved_list = [[]]
        best_max_score = []
        current = None
        best_score = 0.0
        while line:
            line_components = line.split(" ")
            if len(line_components) == 1:
                if current is not None:
                    best_max_score.append(best_score)
                    best_score = 0.0
                problem_size_list.append(int(line_components[0]))
                current = 0
            else:
                score = float(line_components[0])
                if score > best_score:
                    best_score = score
                max_score_achieved_list[current].append(score)
                current += 1
            print("Line {}: {}".format(cnt, line))
            line = fp.readline()
            cnt += 1
        best_max_score.append(best_score)

    return problem_size_list, max_score_achieved_list, best_max_score


def load_sa(problem):
    print("Loading sa stats...")

    with open(problem + '/SA_Stats.txt') as fp:
        line = fp.readline()
        cnt = 1
        problem_size_list = []
        max_score_achieved_list = [[], [], [], []]
        best_max_score = []
        current = None
        best_score = 0.0
        while line:
            line_components = line.split(" ")
            if len(line_components) == 2:
                if current is not None:
                    best_max_score.append(best_score)
                    best_score = 0.0
                problem_size_list.append(int(line_components[0]))
                current = 0
            else:
                score = float(line_components[2])
                if score > best_score:
                    best_score = score
                max_score_achieved_list[current].append(score)
                current += 1
            print("Line {}: {}".format(cnt, line))
            line = fp.readline()
            cnt += 1
        best_max_score.append(best_score)

    return problem_size_list, max_score_achieved_list, best_max_score


def load_ga(problem):
    print("Loading ga stats...")

    with open(problem + '/GA_Stats_salesman_cross_over.txt') as fp:
        line = fp.readline()
        cnt = 1
        problem_size_list = []
        max_score_achieved_list = [[], [], [], [], []]
        best_max_score = []
        current = None
        best_score = 0.0
        while line:
            line_components = line.split(" ")
            if len(line_components) == 2:
                if current is not None:
                    best_max_score.append(best_score)
                    best_score = 0.0
                problem_size_list.append(int(line_components[0]))
                current = 0
            else:
                score = float(line_components[3])
                if score > best_score:
                    best_score = score
                max_score_achieved_list[current].append(score)
                current += 1

            print("Line {}: {}".format(cnt, line))
            line = fp.readline()
            cnt += 1
        best_max_score.append(best_score)
    return problem_size_list, max_score_achieved_list, best_max_score


def load_mimic(problem):
    print("Loading sa stats...")

    with open(problem + '/MIMIC_Stats.txt') as fp:
        line = fp.readline()
        cnt = 1
        problem_size_list = []
        max_score_achieved_list = [[]]
        best_max_score = []
        current = None
        best_score = 0.0
        while line:
            line_components = line.split(" ")
            if len(line_components) == 1:
                if current is not None:
                    best_max_score.append(best_score)
                    best_score = 0.0
                problem_size_list.append(int(line_components[0]))
                current = 0
            else:
                score = float(line_components[2])
                if score > best_score:
                    best_score = score
                max_score_achieved_list[current].append(score)
                current += 1
            print("Line {}: {}".format(cnt, line))
            line = fp.readline()
            cnt += 1
        best_max_score.append(best_score)

    return problem_size_list, max_score_achieved_list, best_max_score


if __name__ == "__main__":
    # print(len(sys.argv))
    # data_set = sys.argv[1]
    load_ga()

