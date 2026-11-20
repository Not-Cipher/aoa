import java.util.Arrays;
import java.util.Scanner;

class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        String[] jobs = new String[n];
        int[] deadline = new int[n];
        int[] profit = new int[n];

        System.out.println("Enter job IDs separated by spaces:");
        for (int i = 0; i < n; i++) {
            jobs[i] = sc.next();
        }

        System.out.println("Enter deadlines separated by spaces:");
        for (int i = 0; i < n; i++) {
            deadline[i] = sc.nextInt();
        }

        System.out.println("Enter profits separated by spaces:");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }

        Job[] jobsList = new Job[n];
        for (int i = 0; i < n; i++) {
            int jobNumber;
            try {
                String jobId = jobs[i];
                if (jobId.length() > 1
                        && (jobId.charAt(0) == 'J' || jobId.charAt(0) == 'j')) {
                    jobId = jobId.substring(1);
                }
                jobNumber = Integer.parseInt(jobId);
            } catch (NumberFormatException e) {
                jobNumber = i + 1;
            }
            jobsList[i] = new Job(jobNumber, deadline[i], profit[i]);
        }

        Arrays.sort(jobsList, (a, b) ->
                Integer.compare(b.profit, a.profit));

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, jobsList[i].deadline);
        }

        String[] slots = new String[maxDeadline + 1];
        int totalProfit = 0;
        int jobsScheduled = 0;

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(maxDeadline, jobsList[i].deadline); j > 0; j--) {
                if (slots[j] == null) {
                    slots[j] = "J" + jobsList[i].id;
                    totalProfit += jobsList[i].profit;
                    jobsScheduled++;
                    break;
                }
            }
        }

        System.out.printf("Job Schedule (  %-10s  %-6s  %-6s  ):%n",
                "Job ID", "Deadline", "Profit");
        for (int i = 0; i < n; i++) {
            System.out.printf("  %-10s  %-6d  %-6d\n",
                    "J" + jobsList[i].id,
                    jobsList[i].deadline,
                    jobsList[i].profit);
        }

        System.out.print("\nJob Sequence: ");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slots[i] != null) {
                System.out.print(slots[i] + " ");
            }
        }
        System.out.println();

        System.out.println("Total jobs scheduled : " + jobsScheduled);
        System.out.println("Maximum total profit : " + totalProfit);

        sc.close();
    }
}
