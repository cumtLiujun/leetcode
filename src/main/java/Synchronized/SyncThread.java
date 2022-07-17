package Synchronized;
/*
1、实例方法，锁住的是该类的实例对象
public synchronized void method() {
    todo
}
2、静态方法，锁住的是类对象
public  static synchronized void method() {

}
# 代码块
3、类的实例对象
synchronized (this) {
}
4、类的类对象
synchronized(classname.class) {
}
5、锁住配置的实例对象
String lock = "";
synchronized(lock){
}
 */
public class SyncThread implements Runnable {

    private static int count;
    public SyncThread() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        Thread thread1 = new Thread(syncThread,"syncThread1");
        Thread thread2 = new Thread(syncThread, "syncThread2");

        thread1.start();

        thread2.start();
    }
}
