package q13;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by user on 19-May-15.
 */
public class SubTask extends RecursiveTask<Long> {
    public static final int THRESHOLD = 10;
    private List<Integer> numbers;

    public SubTask(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    protected Long compute() {
        if(numbers.size() > THRESHOLD) {
            List<SubTask> subTasks = createSubTask();
            for(SubTask subTask : subTasks) {
                subTask.fork();
            }
            Long sum = 0L;
            for(SubTask subTask : subTasks) {
                sum += subTask.join();
            }
            return sum;
        } else {
            Long n = 0L;
            for(Integer number : numbers) {
                n += number;
            }
            return n;
        }
    }

    private List<SubTask> createSubTask() {
        List<SubTask> subTasks = new LinkedList<>();
        int division = numbers.size() /2;

        SubTask subTask1 = new SubTask(numbers.subList(0,division));
        subTasks.add(subTask1);
        SubTask subTask2 = new SubTask(numbers.subList(division,numbers.size()));
        subTasks.add(subTask2);

        return subTasks;
    }
}
