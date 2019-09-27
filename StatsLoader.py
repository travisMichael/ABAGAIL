

def initialize_list_of_lists(n):
    list = []

    for i in range(n):
        list.append([])
    return list


def load_rhc(file, number_of_models):
    print("Loading sa stats...")

    with open(file) as fp:
        line = fp.readline()
        cnt = 1
        problem_size_list = []
        max_score_achieved_list = initialize_list_of_lists(number_of_models)
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


def load_sa(file, number_of_models):
    print("Loading sa stats...")

    with open(file) as fp:
        line = fp.readline()
        cnt = 1
        problem_size_list = []
        max_score_achieved_list = initialize_list_of_lists(number_of_models)
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


def load_ga(file, number_of_models):
    print("Loading ga stats...")

    with open(file) as fp:
        line = fp.readline()
        cnt = 1
        problem_size_list = []
        max_score_achieved_list = initialize_list_of_lists(number_of_models)
        best_max_score = []
        evaluation_list = []
        current = None
        best_score = 0.0
        evaluation = 0.0
        while line:
            line_components = line.split(" ")
            if len(line_components) == 2:
                if current is not None:
                    best_max_score.append(best_score)
                    evaluation_list.append(evaluation)
                    best_score = 0.0
                    evaluation = 0.0
                problem_size_list.append(int(line_components[0]))
                current = 0
            else:
                score = float(line_components[3])
                if score > best_score:
                    best_score = score
                    evaluation = float(line_components[4])
                max_score_achieved_list[current].append(score)
                current += 1

            print("Line {}: {}".format(cnt, line))
            line = fp.readline()
            cnt += 1
        best_max_score.append(best_score)
        evaluation_list.append(evaluation)
    return problem_size_list, max_score_achieved_list, best_max_score, evaluation_list


def load_mimic(file, number_of_models):
    print("Loading sa stats...")

    with open(file) as fp:
        line = fp.readline()
        cnt = 1
        problem_size_list = []
        max_score_achieved_list = initialize_list_of_lists(number_of_models)
        best_max_score = []
        evaluation_list = []
        current = None
        best_score = 0.0
        while line:
            line_components = line.split(" ")
            if len(line_components) == 1:
                if current is not None:
                    best_max_score.append(best_score)
                    evaluation_list.append(evaluation)
                    best_score = 0.0
                    evaluation = 0.0
                problem_size_list.append(int(line_components[0]))
                current = 0
            else:
                score = float(line_components[2])
                if score > best_score:
                    best_score = score
                    evaluation = float(line_components[3])
                max_score_achieved_list[current].append(score)
                current += 1
            print("Line {}: {}".format(cnt, line))
            line = fp.readline()
            cnt += 1
        best_max_score.append(best_score)
        evaluation_list.append(evaluation)
    return problem_size_list, max_score_achieved_list, best_max_score, evaluation_list


if __name__ == "__main__":
    # print(len(sys.argv))
    # data_set = sys.argv[1]
    load_ga()

