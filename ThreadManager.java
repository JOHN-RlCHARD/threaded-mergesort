public class ThreadManager {
    private static ThreadManager instance;
    private final int maxProcessors;
    private int availableProcessors;

    private ThreadManager() {
        maxProcessors = Runtime.getRuntime().availableProcessors();
        availableProcessors = maxProcessors;
    }

    public static ThreadManager getInstance() {
        if (instance == null) {
            instance = new ThreadManager();
        }
        return instance;
    }

    public static boolean isAnyThreadAvailable() {
        return (getInstance().availableProcessors > 0);
    }

    public static int getAvailableProcessors() {
        return getInstance().availableProcessors;
    }

    public static void useProcessor() {
        if (isAnyThreadAvailable()) {
            System.out.println("Processor being used.");
            getInstance().availableProcessors--;
        }
    }

    public static void releaseProcessor() {
        if (getInstance().availableProcessors < getInstance().maxProcessors) {
            System.out.println("Processor released.");
            getInstance().availableProcessors++;
        }
    }
}
