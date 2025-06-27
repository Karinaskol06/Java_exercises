package IntermediateCourse.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FortuneTeller {
    public static void main(String[] args) {

        //list of questions asked, each with a difficulty level
        List<Question> questions = Arrays.asList(
                new Question(Question.Difficulty.EASY, "Am I a good coder?"),
                new Question(Question.Difficulty.MEDIUM, "Will I be able to finish this course?"),
                new Question(Question.Difficulty.EASY, "Will it rain tomorrow?"),
                new Question(Question.Difficulty.EASY, "Will it snow today?"),
                new Question(Question.Difficulty.HARD, "Are you really all-knowing?"),
                new Question(Question.Difficulty.HARD, "Do I have any hidden talents?"),
                new Question(Question.Difficulty.HARD, "Will I live to be greater than 100 years old?"),
                new Question(Question.Difficulty.MEDIUM, "Will I be rich one day?"),
                new Question(Question.Difficulty.MEDIUM, "Should I clean my room?")
        );

        //new instance of crystal ball called c
        CrystalBall c = new CrystalBall();

        //converts questions into a stream and applies function to each question
        List<Thread> threads = questions.stream().map(q -> {
            //creating thread for each question
            Thread t = new Thread(() -> {
                //each thread calls ask func to make crystal ball think (ask meth from CB class)
                c.ask(q);
            });
            return t;
            //threads are collected into a list
        }).collect(Collectors.toList());

        //all threads start simultaneously
        threads.stream().forEach(t -> t.start());

        //creating supervisor thread (checks if thread are still running)
        Thread supervisor = createSupervisor(threads);
        supervisor.start();
    }

    public static Thread createSupervisor(List<Thread> threads) {
        //new supervisor thread
        Thread supervisor = new Thread(() -> {
            while (true) {
                //uses streams to get the list of currently running threads
                List<String> runningThreads = threads.stream()
                        .filter(t -> t.isAlive())
                        .map(t -> t.getName())
                        .toList();

                System.out.println(Thread.currentThread().getName() +
                        " - Currently running threads: " + runningThreads);

                if (runningThreads.isEmpty()) {
                    break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(Thread.currentThread().getName() + " - All threads completed!");
        });
        supervisor.setName("Supervisor");
        return supervisor;
    };
}