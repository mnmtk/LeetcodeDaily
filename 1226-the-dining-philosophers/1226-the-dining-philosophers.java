class DiningPhilosophers {
    int N;
    Semaphore[] forks;

    public DiningPhilosophers() {
        this.N = 5;

        forks = new Semaphore[N];

        for(int i = 0; i < N; i++) {
            forks[i] = new Semaphore(1); // all available
        }

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        int forkRight = (N + philosopher - 1) % N;
        int forkLeft = philosopher;
        
        // to prevent deadlock, we will try to acquire smaller fork first 
        forks[Math.min(forkLeft, forkRight)].acquire();
        forks[Math.max(forkLeft, forkRight)].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();
        
        forks[forkLeft].release();
        forks[forkRight].release();


    }
}