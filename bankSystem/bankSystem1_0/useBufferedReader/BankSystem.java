package bankSystem.useBufferedReader;

import java.io.*;
import java.text.DecimalFormat;
public class BankSystem {
    private String[] userInformation; //记录登录系统的用户信息
    private String filePath = "E:\\Study\\java面试题\\练习题数据库\\userInformation.txt";

    private File file;

    public BankSystem(){
        init();
    }

    public String login(String username,String password){
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String user = br.readLine();
            String[] value = user.split("-");
            while(user != null){
                if(value[0].equals(username) && value[1].equals(password)){
                    userInformation = value;
                    return "登录成功";
                }
                value = user.split("-");
                user = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "用户名或密码错误";
    }

    private void init(){
        file = new File(filePath);
    }

    public float balance(){ //查询余额
        return Float.parseFloat(userInformation[2]);
    }

    public boolean deposit(float money){       //存款
        if(!isLegal(money))return false;
        userInformation[2] = count(money,true);
        modifyInformation(joint(userInformation),0);
        return true;
    }

    public boolean withdrawal(float money){        //取款
        if(!isLegal(money))return false;
        userInformation[2] = count(money,false);
        modifyInformation(joint(userInformation),0);
        return true;
    }

    public String transfer(float money,String toUserName){         //转账
        if(!isLegal(money))return "输入金额为负数";
        String getToUser = getUser(toUserName); //获取数据库中到账人信息
        if(Float.parseFloat(userInformation[2]) < money){
            return "余额不足";
        }
        if(getToUser == null){
            return "未找到到账人";
        }
        String[] toUser = getToUser.split("-");
        DecimalFormat f = new DecimalFormat(".0");
        float newMoney = new Float(Float.parseFloat(toUser[2])+money);
        toUser[2] = f.format(newMoney);
        modifyInformation(joint(toUser),0);   //更新到账人的信息
        withdrawal(money);
        modifyInformation(joint(userInformation),0);  //更新转账人信息
        return "转账成功";
    }

    public String opening(String name,String password,Float money){    //开户
        if(getUser(name) != null){return "您之前已开户";}
        if(!isLegal(money)){return "输入金额为负数";}
        userInformation = new String[3];
        userInformation[0] = name;
        userInformation[1] = password;
        userInformation[2] = money.toString();
        String result = modifyInformation(joint(userInformation),1);
        if("开户成功".equals(result)) return result;
        return "开户失败";
    }

    public String cancellation(String name){   //销户
        return modifyInformation(getUser(name),2);
    }
    //计算处理余额 true为加 false为减 返回保留一位小数的String
    private String count(float dealMoney,boolean addOrSub){
        DecimalFormat f = new DecimalFormat("0.0");
        float newMoney;
        if(addOrSub){   //存款
            newMoney = new Float(balance()+dealMoney);
        }else{      //取款
            newMoney = new Float(balance()-dealMoney);
        }
        return f.format(newMoney);
    }

    private String getName(String user){    //得到名字 如"张三-12345-1243.1"中的"张三"
        String[] value = user.split("-");
        return value[0];
    }

    private String getUser(String name){       //得到指定用户的信息
        if(name == null){return "非法用户名";}
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String user = br.readLine();
            while(user != null){
                if(name.equals(getName(user))){
                    return user;
                }
                user = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    private boolean isLegal(float money){    //判断输入的金额是否合法
        if(money >= 0) return true;
        return false;
    }

    private String modifyInformation(String updater,int flag){   //修改数据库中用户消息 0为就改 1 为开户 2为销户
        String result = "";   //记录修改结果
        FileReader fr;
        BufferedReader br;
        FileWriter fw;
        BufferedWriter bw;
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String user = br.readLine();
            String oldFilePath = file.getAbsolutePath();
            //创建一个名字是旧文件名加1的文件 如：旧文件old.text --> old1.txt
            File newFile = new File(oldFilePath.substring(0, oldFilePath.indexOf(".")).concat("1.txt"));
            fw = new FileWriter(newFile);
            bw = new BufferedWriter(fw);
            while(user != null){
                if(getName(user).equals(getName(updater))){
                    if(flag == 0) {
                        bw.newLine();
                        bw.write(updater);
                        bw.flush();
                        user = br.readLine();
                        continue;
                    }else if(flag == 2){
                        if(!updater.substring(updater.lastIndexOf("-")+1).equals("0.0")){   //判断金额是否为0
                            result = "金额不为0，销户失败";
                            bw.newLine();
                            bw.write(updater);
                            bw.flush();
                            user = br.readLine();
                            continue;
                        }
                        user = br.readLine();
                        result = "销户成功";
                        continue;
                    }
                }
                if(!user.endsWith("开始")) bw.newLine();
                bw.write(user);
                bw.flush();
                user = br.readLine();
            }
            if(flag == 1){  //开户
                bw.newLine();
                bw.write(updater);
                bw.flush();
                result = "开户成功";
            }
            fr.close();
            br.close();
            bw.close();
            fw.close();
            file.delete();
            newFile.renameTo(new File(oldFilePath));
        }catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }

    private String joint(String[] strings){ //将userInformation拼接
        if(strings == null){return null;}
        StringBuilder builder = new StringBuilder(strings[0]);
        for(int i = 1;i < strings.length;i++){
            builder.append("-").append(strings[i]);
        }
        return new String(builder);
    }
}