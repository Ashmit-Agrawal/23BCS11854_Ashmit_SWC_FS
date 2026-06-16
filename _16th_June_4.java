import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// "Problem Statement:
// A system needs to execute multiple independent tasks efficiently without creating excessive threads.
// Task:
// Use ExecutorService to manage tasks.

// Requirements:

// Create fixed thread pool
// Submit multiple tasks
// Collect results if needed
// Shutdown executor properly"
public class _16th_June_4 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Future<Integer>> results = new ArrayList<>();

        for(int i=1; i<=5; i++) {
            final int taskId = i;
            Future<Integer> result = executor.submit(() -> {
                System.out.println("Executing task " + taskId);
                Thread.sleep(1000); // Simulate work
                return taskId * 10;
            });
            results.add(result);
        }

        for(Future<Integer> result : results) {
            try {
                System.out.println("Result: " + result.get());
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
        }

        executor.shutdown();
    }
}