To regenerate the experiments and plots from the analysis paper, you will need to clone 2 projects. The first project
has been forked from the ABIGAIL repository. I added code to TravelingSalesmanTest.java, FlipFlopTest.java, and
MaxKColoring.java to gather statistics around 4 different randomized optimization algorithms. The project also
contains python programs to read in the statistic data and create various plots about the data. To gather the stats
and generate the plots, run the following commands:


git clone https://github.com/travisMichael/ABAGAIL.git


cd ABAGAIL
ant
java -cp ABAGAIL.jar opt.test.MaxKColoringTest
java -cp ABAGAIL.jar opt.test.FlipFlopTest
java -cp ABAGAIL.jar opt.test.TravelingSalesmanTest


The python files were developed with version 3.6.8, so please make sure you have that version or later installed. Run
the programs with the following commands:

python generateAllPlots.py

The plots and stats can be found in the following directories:

FlipFlop
KColoring
TravelingSalesman


The second project uses the same repository as the first repository, but a different branch was created to keep them
separate. I also needed to make some modifications to mlrose, so that I could gather some statistic easier. I copied
the files from the mlrose repo and placed them in a directory called mlrosevariation. To train the neural networks and
generate the plots from the analyses paper, run the following commands:

git clone https://github.com/travisMichael/cardiovascular.git

git checkout hw2

Run the following commands to train the models and generate the training plots:

python train.py randomizedOptimization
python test.py randomizedOptimization

The plots can be found under the optimization directory.