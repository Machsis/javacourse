
# ʵ���塪��JAVA��IO����
## ʵ������

### ʵ��һ ����IO����
* �Ӽ��̽����ֽ���
* д�뵽��ǰĿ¼�µ�src.txt�ļ���
* ��src.txt�ļ����ݸ��Ƶ���ǰĿ¼��dest.txt�ļ���
* ��dest.txt�ļ�������ʾ����Ļ��
* ʵ����������input.txt��
### ʵ��� ��ȡϵͳ���ļ���
* ��ȡĳ��Ŀ¼�µ�Ŀ¼��Ϣ��Ŀ¼�ӿ���̨���롣
Ŀ¼��Ϣ������Ŀ¼�µ������ļ����ļ��е��б�����ÿ���ļ�����ʾ�����ƣ��޸����ڡ�����ÿ���ļ���ʾ�����ƣ��޸����ںʹ�С��
Ŀ¼����Ϣд�����ļ��С�
* ע�⣬�ļ���Ϣ���Ȱ����ͷ��࣬�ļ�����ǰ���ļ��ں󣬲������Ǹ��԰����ļ����ַ�����˳������
��չ�Լ���ѧ���֣�����JAVA��GUI��Swing�ȣ�����һ�����׵��ļ��������
* ʵ����������input.txt��
### ʵ���� ����������IO
* �ô�����Ͳ���������ַ���ʵ���ļ����ƣ����ȽϺ�ʱ�����
* ʵ����������input.txt��
### ʵ���� �������л�
* ��Student��ʾѧ�������԰���{studentID, name, sex} (ѧ�ţ��������Ա�)��ʹ�����л���������Student��ѧ����Ϣ���ļ�list.txt���룬������ѧ���������С�ע�⣬�����������Ա������֯��String���ͣ���ѧ�ſ�����StringҲ������Long��
* ʹ��ObjectOutputStream���Ѿ������ѧ����Ϣд�����ļ���student.bin���С�
* ʹ��ObjectInputStream����student.bin���еĶ�����Ϣ���������ʾ�ڿ���̨�С�
* ʵ����������input.txt��

## �������
ǰ����ʵ��ûʲô��˵�����ĸ�ʵ�����������⣬��һ������������ʦ�ĵ�list.txt�ļ���scanner.hasNext()����-1��
����˵û�ж�ȡ���κζ����������Լ��½���һ��������ȥ
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
�ڶ�����������ObjectInputStream��reader.hasNext()��ȡ���л�����Ȼ��һֱ����-1����֪��ʲôԭ�������������ͨ����
```javascript
for(Student student:stuList){
    	student=(Student) reader.readObject();
		System.out.println(student.num+"\t"+student.name+"\t"+student.sex);
````
* ȫ�Ľ�������л�Ķ������в��ף���ӭָ��~

## ��������
* ��һ������
* �ʼ�(13799671597@163.com)
* weibo: [@���QML](http://weibo.com/u/5671356526)


