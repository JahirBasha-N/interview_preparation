import java.util.*;

/*
When multiple tasks are executed on a single-threaded CPU, the tasks are scheduled based on the principle of pre-emption. When a higher-priority task arrives in the execution queue, then the lower- priority task is pre-empted, i.e. its execution is paused until the higher-priority task is complete.

There are n functions to be executed on a single-threaded CPU, with each function having a unique ID between 0 and n-1. Given an integer n, representing the number of functions to be executed, and an execution log as an array of strings, logs, of size m, determine the exclusive times of each of the functions. Exclusive time is the sum of execution times for all calls to a function. Any string representing an execution log is of the form (function_id}:{"start"|"end"): (timestamp), indicating that the function with ID = function_id, either starts or ends at a time identified by the timestamp value.

Note: While calculating the execution time of a function call, both the starting and ending times of the function call have to be included. The log of the form (function_id): (start): (timestamp) means that the running function is preempted at the beginning of timestamp second. The log of the form (function_id): (end): {timestamp) means that the function function_id is preempted after completing its execution at timestamp second i.e after timestamp second.
 */
public class ExclusiveCpuTimeCalculation {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTimes = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTimestamp = 0;

        for (String log : logs) {
            String[] logData = log.split(":");
            int functionId = Integer.parseInt(logData[0]);
            String event = logData[1];
            int timestamp = Integer.parseInt(logData[2]);

            if (event.equals("start")) {
                if (!stack.isEmpty()) {
                    exclusiveTimes[stack.peek()] += timestamp - prevTimestamp;
                }
                stack.push(functionId);
                prevTimestamp = timestamp;
            } else {
                exclusiveTimes[stack.pop()] += timestamp - prevTimestamp + 1;
                prevTimestamp = timestamp + 1;
            }
        }

        return exclusiveTimes;
    }

    public static void main(String[] args) {
        ExclusiveCpuTimeCalculation solution = new ExclusiveCpuTimeCalculation();
        int n = 3;
        List<String> logs = Arrays.asList("0:start:0", "1:start:2", "1:end:5", "2:start:6", "2:end:8", "0:end:9");

        int[] result = solution.exclusiveTime(n, logs);
        System.out.println(Arrays.toString(result));
    }
}

