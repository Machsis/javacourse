
# ʵ���ġ���JAVA���߳�

## ʵ������
### ʵ��һ
* ��ʵ�����еĵ���ģʽ���и��죬ʹ��֧�ֶ��̣߳��������̰߳�ȫ�ġ�
* ʵ����������input.txt��
### ʵ��� ����4���̷ֶ߳����1~100
* �߳�1����1~25֮�ͣ��߳�2����26~50֮�ͣ��Դ�����
* Ҫ���߳�1���֮��ִ���߳�2��֮��ִ���߳�3�����ִ���߳�4
* ��ӡÿ����ͽ�����Լ������ܽ�������ֱ��ӡ��һ����ͽ�����ڶ�����ͽ������������ͽ�������Ķ���ͽ�������յ���ͽ��

## ʵ��һ�������
����ʵ��������÷���
```javascript
    private static SingleCase uniqueInstance;
	public static SingleCase getInstance(){
		if(uniqueInstance==null){
			uniqueInstance=new SingleCase();
		}
		return uniqueInstance;
	}
```
���
```javascript
    private boolean empty;
	private boolean boiled;
	public int ID;
```
�����߳�
```javascript
Thread []thread=new Thread[3];
    	for (int i=0;i<3 ;i++ ) {
			thread[i]=new Thread(new SingleCase(i+1));
			thread[i].start();		
		}
```
## ʵ����������
����
```javascript
  public static int sum = 0;
    public static Object LOCK = new Object();
```
����run����
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
�������̣߳�����join��������ֱ�����
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

##### �ܽ᣺
* ȫ�Ľ�������л�Ķ������в��ף���ӭָ��~

## ��������
* ��һ������
* �ʼ�(13799671597@163.com)
* weibo: [@���QML](http://weibo.com/u/5671356526)