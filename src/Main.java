public class Main {

    static boolean complete = false;

    public static void main(String[] args) {
        int number = (int) (Math.random() * 1000000);
        Thread timer = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    int i = 0;
                    while (!complete) {
                        System.out.println(i);
                        i++;
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {

                }
            }
        });
        timer.start();
        Thread tryToGuess = new Thread(new Runnable() {
            @Override
            public void run() {
                int guess = 0;
                while (!complete) {
                    guess = (int) (Math.random() * 1000000);
                    if (guess == number) {
                        System.out.println(guess);
                        complete = true;
                    }
                }
            }
        });
        tryToGuess.start();
    }
}
