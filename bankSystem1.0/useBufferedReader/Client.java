package bankSystem.useBufferedReader;

import java.util.Scanner;


public class Client {   //客户端程序
    public static void main(String[] args){
       // boolean flag = true;//判断是否再执行
        Scanner input = new Scanner(System.in);
        BankSystem bs = new BankSystem();
        System.out.println("请输入：\n\tA.登录\tB.开户");
        char isLogin = input.nextLine().charAt(0);
        switch (isLogin){
            case 'a':
            case 'A':
                System.out.print("请输入：\n\t账户名：");
                String username = input.nextLine();
                System.out.print("\t密码：");
                String password = input.nextLine();
                String login = bs.login(username.trim(),password.trim());//登录
                if(login.equals("登录成功")){
                    System.out.println(login);
                    System.out.println("请输入你的操作：");
                    System.out.println("\tA.查询余额\tB.存款\tC.取款\tD.转账\tE.销户");
                    char option = input.nextLine().charAt(0);
                    float money;//记录用户输入金额
                    switch (option){
                        case 'a':
                        case 'A':
                            System.out.println(username+"先生/女生，您的金额为："+bs.balance());
                            break;
                        case 'b':
                        case 'B':
                            System.out.print("请输入存款金额：");
                            money = input.nextFloat();
                            if(bs.deposit(money)){
                                System.out.println("\n存款成功");

                            }else{
                                System.out.println("\n输入存款金额为负数");
                            }
                            break;
                        case 'c':
                        case 'C':
                            System.out.print("请输入取款金额：");
                            money = input.nextFloat();
                            if(bs.withdrawal(money)){
                                System.out.println("\n存款成功");

                            }else{
                                System.out.println("\n金额不足或输入金额为负数");
                            }
                            break;
                        case 'd':
                        case 'D':
                            System.out.print("请输入到账人姓名：");
                            String toUser = input.nextLine();
                            System.out.print("\n请输入转账金额：");
                            money = input.nextFloat();
                            System.out.println("\n"+bs.transfer(money,toUser));
                            break;
                        case 'e':
                        case 'E':
                            System.out.println("是否真的销户？Y/N");
                            char result = input.nextLine().charAt(0);
                            switch (result){
                                case 'y':
                                case 'Y':
                                    System.out.println(bs.cancellation(username));
                                    break;
                                case 'n':
                                case 'N':
                                    break;
                                    default:
                                        break;
                            }
                            default:
                                break;
                    }
                }else{
                    System.out.println(login);
                }
                break;
            case 'b':
            case 'B':
                System.out.println("正在开户！！！");
                System.out.println("请输入用户名：");
                String name = input.nextLine();
                System.out.println("请输入密码：");
                String initPassword = input.nextLine();
                System.out.println("请输入预存金额：");
                float money = input.nextFloat();
                System.out.println(bs.opening(name,initPassword,money));
                break;
                default:
                    System.out.println("输入错误");
                    break;
        }
    }
}
