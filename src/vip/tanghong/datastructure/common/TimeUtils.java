package vip.tanghong.datastructure.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TimeUtils {

    private static final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SSS");

    public interface Task {
        void execute();
    }

    public static void test(String testName, Task task) {
        if(Objects.isNull(task)) {
            return;
        }
        System.out.println("=============开始测试[" + testName + "]==============");

        System.out.println("开始时间: " + fmt.format(new Date()));
        long start = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束时间: " + fmt.format(new Date()));
        double time = (end - start) / 1000.0;
        System.out.println("耗时: " + time + "s");
        System.out.println("===============测试[" + testName + "]结束=============");
    }

}
