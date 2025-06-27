package IntermediateCourse.Streams;

import java.util.Random;

public class CrystalBall {

    //method of asking (that has inside thinking and answering)
    public void ask(Question question) {
        System.out.println(Thread.currentThread().getName() +
                " - Good question! You asked: " + question.getQuestion());
        this.think(question);
        System.out.println(Thread.currentThread().getName() + " - Answer: " + this.answer());
    }

    //method that performs logic of thinking and answering
    private void think(Question question) {
        System.out.println(Thread.currentThread().getName() + " - Hmm... Thinking");
        try {
            Thread.sleep(this.getSleepTimeInMs(question.getDifficulty()));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(Thread.currentThread().getName() + " - Done!");
    }

    //method gives a random answer
    private String answer() {
        String[] answers = {
                "Signs point to yes!",
                "Certainly!",
                "No opinion",
                "Answer is a little cloudy. Try again.",
                "Surely.",
                "No.",
                "Signs point to no.",
                "It could very well be!"
        };
        return answers[new Random().nextInt(answers.length)];
    }

    //gets sleep time based on difficulty
    private int getSleepTimeInMs(Question.Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return 1000;
            case MEDIUM:
                return 2000;
            case HARD:
                return 3000;
            default:
                return 500;
        }
    }
}