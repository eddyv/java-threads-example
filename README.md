# Java Threads Example

This repo demonstrates how to use Java threads to run multiple tasks in parallel.

## Voting for the best design

In this situation, we are implementing a polling system where candidates can vote for their
favourite design. For this polling system we implement two runnables. One runnable to simulate
voting, and one for counting. Each design will have a thread to deal with voting, and a thread to
deal with counting.

Votes are given out randomly between 0-5s. The counting thread will report results in 2s intervals.

### Running the program
Clone this repository and run the below command in the root directory of the project.

```bash
./mvnw exec:java -Dexec.mainClass="org.example.Main"
```
