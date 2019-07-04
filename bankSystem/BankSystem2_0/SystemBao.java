package bankSystem2_0;

import java.io.*;
import java.util.HashMap;

public class SystemBao {
    private HashMap<String,User> users = new HashMap<>();//临时记录用户信息
    private File file = new File("src/bankSystem2_0/user.txt");

    public HashMap<String,User> getUsers(){   //读取数据库
        FileReader fr = null;
        BufferedReader br = null;
        try{
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String user = br.readLine();
            while(user != null){
                String[] value = user.split("-");
                users.put(value[0],new User(value[0],value[1],Float.parseFloat(value[2])));
                user = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    public void update(String username,User user){   //更新users的信息
        users.put(username,user);
        commit();
    }
    public void remove(String username){   //移除用户
        users.remove(username);
        commit();
    }

    public void commit(){   //提交更新数据库
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            for(User user: users.values()){
                StringBuilder builder = new StringBuilder(user.getUsername());
                builder.append("-").append(user.getPassword()).append("-").append(user.getMoney());
                bw.write(new String(builder));
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
