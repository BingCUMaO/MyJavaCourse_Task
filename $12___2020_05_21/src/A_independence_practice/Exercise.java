package A_independence_practice;

/**
 * 独立实践  8.6.3
 *
 * 计时工人工资计算（版本6）
 *
 * 在8.3.3小姐独立实践“计时工人工资计算”的程序中，声明一个
 * 含有4个元素的Employee类型的数组employees，将employee1、
 * employee2、hourlyworker1和hourlyworker2设置为employees数
 * 组的四个元素的值。
 * 通过printEmployeeInfo(Employee[] employees) 方法，迭代数组
 * employees，使每个元素调用toString方法，输出每个对象属性的
 * 值。
 * 从输出结果看，它们调用的是各自对象的toString方法（这就是
 * 多态性），而不都是Employee类的toString方法，为什么？
 */
public class Exercise {

    /**
     * 答：
     * 对于employee1与employee2，它们本身在内存中所储存的类型为Employee，
     * 因此调用的是Employee类中本身的toString方法。
     * 对于hourlyworker1与hourlyworker2，它们在内存中所储存的类型为HourlyWorker，
     * 同时，HourlyWorker继承于Employee，所以在不重写HourlyWorker类的toString的
     * 情况下指向其基类Employee的toString。但由于HourlyWorker重写了Employee的
     * toString方法，因此，当调用hourlyworker1与hourlyworker2的toString方法时，所调
     * 用的是HourlyWorker的toString方法，而非Employee的toString方法。
     */
}
