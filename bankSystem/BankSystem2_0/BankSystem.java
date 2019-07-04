package bankSystem2_0;

import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;

public class BankSystem {
    private SystemBao dao = new SystemBao();
    private HashMap<String,User> users = dao.getUsers();

    public String login(String username,String password) {
        User user = users.get(username);
        if(user != null && user.getPassword().equals(password)){
            return "登录成功";
        }
        return "登录失败";
    }


    public Float balance(String username){ //查询余额
        return users.get(username).getMoney();
    }

    public boolean deposit(String username,Float money){       //存款
        if(!isLegal(money))return false;
        User user = users.get(username);
        user.setMoney(user.getMoney()+money);
        dao.update(username,user);
        return true;
    }

    public boolean withdrawal(String username,Float money){        //取款
        if(!isLegal(money))return false;
        User user = users.get(username);
        user.setMoney(user.getMoney()-money);
        dao.update(username,user);
        return true;
    }

    public String transfer(String username,Float money,String toUserName){         //转账
        if(!isLegal(money))return "输入金额为负数";
        User user = users.get(username);
        User toUser = users.get(toUserName);
        if(toUser == null){
            return "未找到到账人";
        }
        if(user.getMoney() < money){
            return "余额不足";
        }
        user.setMoney(user.getMoney()-money);//更新user的金额
        toUser.setMoney(toUser.getMoney()+money); //更新到账人的金额
        dao.update(username,user);
        dao.update(toUserName,toUser);
        return "转账成功";
    }

    public String opening(String username,String password,Float money){    //开户
        if(users.get(username) != null){return "您之前已开户";}
        if(!isLegal(money)){return "输入金额为负数";}
        User user = new User(username,password,money);
        users.put(username,user);   //更新users
        dao.update(username,user);  //更新数据库
        return "开户成功";
    }

    public void cancellation(String username) {   //销户
        dao.remove(username);
    }

    private boolean isLegal(float money){    //判断输入的金额是否合法
        if(money >= 0) return true;
        return false;
    }

}