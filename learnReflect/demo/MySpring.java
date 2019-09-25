package demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class MySpring {
    public Object getBean(String className){
        Scanner input = new Scanner(System.in);
        System.out.println("正在为" + className + "类创建对象并赋值");
        Object object = null;
        try {
            //获取方法传递进来的参数对应的类
            Class clazz = Class.forName(className);
            //通过clazz创建一个对象
            object = clazz.newInstance();
            //在这里做一个自动DI注入 对象中的所有属性 set
            // 找到每一个不同对象中的所有set方法  给所有属性赋值
            //自己通过拼接字符串的方式处理名字
            //1.通过clazz找寻类中的所有私有属性 ------>获取属性名  ---->set属性
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                //获取属性名
                String fieldName = field.getName();
                //2.手动的拼串 拼接属性对应的set方法名  如setName
                String firstLatter = fieldName.substring(0,1).toUpperCase(); //属性首字母大写
                String otherLatter = fieldName.substring(1); //属性除了首字母之外的其他字母
                StringBuilder builder = new StringBuilder("set");
                builder.append(firstLatter);
                builder.append(otherLatter);
                //3.获取field对应的属性类型 ---->找寻set方法时候传递参数用
                Class fieldClass = field.getType();
                //4.通过处理好的set方法名 找寻类中的set方法
                Method setMethod = clazz.getMethod(builder.toString(),fieldClass);
                //5.找到的setMethod——执行 属性就赋值成功了
                System.out.println("请输入" + fieldName + "属性的值");
                String value = input.nextLine();
                //需要执行属性对应的set方法 给属性赋值 方法就结束了
                //属性的值现在接手过来（Scanner 文件内读取） 全都是String类型
                //执行set方法的时候 方法需要的值不一定都是String类型  有可能为Integer  但需要属性类型的值
                //如何将所有的String类型的值 ——————>转化为属性类型的值
                //八个包类有七个都含有带String的构造方法
                // new Integer(String)  new String(String)
                //可以利用包装类带属性的构造方法解决  属性类型对应的带String参数的构造方法
                Constructor constructor = fieldClass.getConstructor(String.class);
                setMethod.invoke(object,constructor.newInstance(value));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


        return object;
    }
}
