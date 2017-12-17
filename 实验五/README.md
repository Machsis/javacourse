
# 实验五——JAVA的IO操作
## 实验内容

### 实验一 基本IO操作
* 从键盘接收字节流
* 写入到当前目录下的src.txt文件中
* 将src.txt文件内容复制到当前目录下dest.txt文件中
* 将dest.txt文件内容显示到屏幕上
* 实验结果保存在input.txt中
### 实验二 获取系统的文件树
* 获取某个目录下的目录信息，目录从控制台输入。
目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小。
目录的信息写出到文件中。
* 注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序。
扩展以及自学部分：利用JAVA的GUI（Swing等）创建一个简易的文件浏览器。
* 实验结果保存在input.txt中
### 实验三 带缓冲区的IO
* 用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况。
* 实验结果保存在input.txt中
### 实验四 对象序列化
* 类Student表示学生，属性包括{studentID, name, sex} (学号，姓名，性别)，使用序列化技术定义Student。学生信息从文件list.txt读入，并按照学号升序排列。注意，这里姓名和性别可以组织成String类型，而学号可以是String也可以是Long。
* 使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中。
* 使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中。
* 实验结果保存在input.txt中

## 代码分析
前三个实验没什么好说，第四个实验遇到点问题，第一个问题是用老师的的list.txt文件，scanner.hasNext()返回-1，
就是说没有读取到任何东西，无奈自己新建了一个拷贝进去
```javascript
File file=new File("1.txt");
    	Scanner scanner=new Scanner(file);
		List<Student> stuList=new ArrayList();
		while(scanner.hasNext()){
			String No=scanner.next();
			String name=scanner.next();
			String sex=scanner.next();
			stuList.add(new Student(No,name,sex));
		}
```
第二个问题是用ObjectInputStream的reader.hasNext()读取序列化对象，然而一直返回-1，不知道什么原因，无奈用下面变通方法
```javascript
for(Student student:stuList){
    	student=(Student) reader.readObject();
		System.out.println(student.num+"\t"+student.name+"\t"+student.sex);
````
* 全文结束，感谢阅读，如有不妥，欢迎指出~

## 关于作者
* 软工一班李明
* 邮件(13799671597@163.com)
* weibo: [@潮鳴ML](http://weibo.com/u/5671356526)


