import java.io.*;
import java.util.*;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO 自动生成的方法存根
		int Max_Task = 0;
		List<Task> taskCome = new ArrayList();
		int i;
		int ID, arrivalTime, serviceTime;
		System.out.println("choose your Task_num");
		Scanner scanner = new Scanner(System.in);
		Max_Task = scanner.nextInt();
		scanner.close();
		if (Max_Task <= 0)
			return;
		Task[] task = new Task[Max_Task];
		for (i = 0; i < Max_Task; i++)
			task[i] = new Task();
		Scanner input = new Scanner(new File("input.txt"));
		System.out
				.println("TaskID\tArrivalTime\tServiceTime\tStartingTime\tFinishingTime\tTurnAroundTime\tWeightTurnAround");
		if (Max_Task != 1)
			for (i = 0; i < Max_Task; i++) {
				ID = input.nextInt();
				arrivalTime = input.nextInt();
				serviceTime = input.nextInt();
				task[i].resolve(new Task(ID, arrivalTime, serviceTime));
			}
		ID = input.nextInt();
		arrivalTime = input.nextInt();
		serviceTime = input.nextInt();
		taskCome.add(new Task(ID, arrivalTime, serviceTime));
		while (!taskCome.isEmpty()) {
			boolean is_not_resolve = true;
			int fast = 0;
			Collections.sort(taskCome, new Comparator<Task>() {
				public int compare(Task o1, Task o2) {
					return o1.serviceTime - o2.serviceTime;
				}
			});
			if (is_not_resolve) {
				for (i = 0; i < Max_Task - 1; i++) {
					if (task[i + 1].finishingTime < task[fast].finishingTime)
						fast = i + 1;
				}
				task[fast].resolve(taskCome.get(0));

			}
			if (input.hasNextInt()) {
				for (i = 0; i < taskCome.get(0).serviceTime; i++) {
					try {
						ID = input.nextInt();
						arrivalTime = input.nextInt();
						serviceTime = input.nextInt();
						taskCome.add(new Task(ID, arrivalTime, serviceTime));
					}

					catch (Exception e) {
						break;
					}
				}

			}
			taskCome.remove(0);
		}
		input.close();

	}
}
