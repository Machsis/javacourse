
# 实验四——JAVA多线程

## 实验内容
### 实验一
* 对实验三中的单例模式进行改造，使其支持多线程，并且是线程安全的。
* 实验结果保存在input.txt中
### 实验二 利用4个线程分段求和1~100
* 线程1计算1~25之和；线程2计算26~50之和；以此类推
* 要求线程1完成之后执行线程2，之后执行线程3，最后执行线程4
* 打印每段求和结果，以及最后的总结果。即分别打印第一段求和结果，第二段求和结果，第三段求和结果，第四段求和结果，最终的求和结果

## 实验一代码分析
单个实例及其调用方法
```javascript
    private static SingleCase uniqueInstance;
	public static SingleCase getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new SingleCase();
		}
		return uniqueInstance;
	}
```
标记
```javascript
    private boolean empty;
	private boolean boiled;
	public int ID;
```
启动线程
```javascript
Thread []thread=new Thread[3];
    	for (int i=0;i<3 ;i++ ) {
			thread[i]=new Thread(new SingleCase(i+1));
			thread[i].start();		
		}
```
## 实验二代码分析
变量
```javascript
  public static int sum = 0;
    public static Object LOCK = new Object();
```
重载run方法
```javascript
private int begin;
        private int end;

        @Override
        public void run() {
            synchronized (LOCK) {
                for (int i = begin; i <= end; i++) {
                    sum += i;
                }
                System.out.println("from "+Thread.currentThread().getName()+" sum="+sum);
            }
        }

        public ThreadTest(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
```
启动多线程，调用join方法阻塞直至完成
```javascript
Test add = new Test();
        ThreadTest thread1 = add.new ThreadTest(1, 25);
        ThreadTest thread2 = add.new ThreadTest(26, 50);
        ThreadTest thread3 = add.new ThreadTest(51, 75);
        ThreadTest thread4 = add.new ThreadTest(76, 100);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

         thread1.join();
         thread2.join();
         thread3.join();
         thread4.join();
         System.out.println("total result: "+sum);
```

##### 总结：
* 全文结束，感谢阅读，如有不妥，欢迎指出~

## 关于作者
* 软工一班李明
* 邮件(13799671597@163.com)
* weibo: [@潮鳴ML](http://weibo.com/u/5671356526)