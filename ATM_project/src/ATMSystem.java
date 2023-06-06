import java.util.*;
public class ATMSystem {
    public static void main(String[] args) {
         ArrayList<Account>accounts=new ArrayList<>();//提供容器，存储用户进行相关操作
        Scanner scanner=new Scanner(System.in);
        while (true) {
            System.out.println("--------欢迎来到抓狗大队通用ATM--------");
            int command;
            System.out.println("1.登录用户");
            System.out.println("2.注册用户");
            System.out.println("3.退出");
            System.out.println("请选择操作:");
            command=scanner.nextInt();
            while(command>3||command<1)
            {
                System.out.println("您输入的操作命令不存在，请重新输入");
                command=scanner.nextInt();
            }
            switch(command)
            {
                case 1:
                    Login(accounts,scanner);//登录
                    break;
                case 2:
                    register(accounts,scanner);//注册
                    break;
                case 3:
                    System.exit(1);
            }
        }

    }

    /**
     * 登录功能
     * @param accounts
     * @param scanner
     */
    private static void Login(ArrayList<Account>accounts,Scanner scanner){
        System.out.println("-----------------登录操作系统-----------------");
        int sum=0;
           if(accounts.size()==0)
           {
               System.out.println("对不起，当前系统中，无任何账户，请先注册");
               return;
           }
        while (true) {
            System.out.println("请输入卡号");
            String cardID=scanner.next();
            //去账户集合中查询，
            Account acc=getAccountByCardID(cardID,accounts);
            if(acc!=null){
                //卡号存在
                System.out.println("请输入登录密码:");
                String passWord=scanner.next();

                if(acc.getPassword().equals(passWord)){
                    //登录成功
                    System.out.println("恭喜您，"+acc.getUserName()+"先生/女士，登录成功,您的卡号是 "+acc.getIDCard());
                    //查询，转账，取款
                    showUserCommand(accounts,acc,scanner);
                    return;//退出登录方法
                }
                else {
                    while(sum<3)
                    {
                    sum++;
                    System.out.println("对不起，您输入的密码有误,您还有"+(3-sum)+"次输入机会");
                    passWord=scanner.next();
                        if(acc.getPassword().equals(passWord))
                            break;
                    }
                    if(sum==3)
                        return;
                }
            }
            else {
                System.out.println("对不起，系统中不存在该卡号");
            }
        }
    }

    /**
     * 展示功能菜单
     */
    private static void showUserCommand(ArrayList<Account>accounts,Account account,Scanner scanner) {

        while (true) {
            System.out.println("--------------用户操作页------------------");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款");
            System.out.println("4.转账");
            System.out.println("5.修改密码");
            System.out.println("6.退出");
            System.out.println("7.注销账户");
            System.out.println("请选择相应操作");
            int n=scanner.nextInt();
            switch(n){
                case 1:
                    //查询，展示当前账户
                    showAccount(account);
                    break;
                case 2:
                    //存储
                    depositAccount(account,scanner);
                    break;
                case 3:
                    //取款
                    withdrawalAccount(account,scanner);
                    break;
                case 4:
                    //转账
                    transferAccount(account,scanner,accounts);
                    break;
                case 5:
                    //修改
                    changeAccount(account,scanner);
                    break;
                case 6:
                    //退出
                    System.out.println("退出成功，欢迎下次光临");
                    return;//退出当前方法
                case 7:
                    //注销
                    destroyAccount(account,scanner);

                    break;
                default:
                    System.out.println("该操作不存在，重新输入~~~~~");
                    break;
            }
        }
    }



    /**
     * 展示用户信息
     */
    private static void showAccount(Account account) {
        System.out.println("----------当前账户信息如下----------");
        System.out.println("卡号: "+account.getIDCard());
        System.out.println("户主: "+account.getUserName());
        System.out.println("余额: "+account.getMoney());
        System.out.println("限额: "+account.getQuotaMoney());
    }

    /**
     * 存储
     *
     * @param account
     * @param scanner
     */
    private static void depositAccount(Account account, Scanner scanner) {
        System.out.println("这位( •̀ ω •́ )y，欢迎使用存储功能，请问您要存多少money");
        System.out.println("您的账户:"+account.getIDCard()+" 目前余额为: "+account.getMoney());
        double deposit=scanner.nextDouble();
        while(deposit<0)
        {
            System.out.println("这位✌别闹,该数据不合法的,相信您是手抖了");
            deposit=scanner.nextDouble();
        }
        account.setMoney(account.getMoney()+deposit);
        System.out.println("感谢( •̀ ω •́ )y,已存入 "+deposit+" 元,当前余额为: "+account.getMoney());
        System.out.println("欢迎下次光临");
        return;
    }

    /**
     * 取款
     *
     * @param account
     * @param scanner
     */
    private static void withdrawalAccount(Account account, Scanner scanner) {
        System.out.println("O(∩_∩)O，( •̀ ω •́ )y是不是要去消费了，欢迎来到取款界面");
        System.out.println("您当前的余额为: "+account.getMoney()+" （卡号:+"+account.getIDCard()+"）");
        double withdrawal=scanner.nextDouble();
        while(withdrawal<0||withdrawal>account.getQuotaMoney())
        {
            if (withdrawal<0)
            System.out.println("该取款数据不合法~~~(＾Ｕ＾)ノ~ＹＯ");
            else
                System.out.println("你的限额为: "+account.getQuotaMoney()+" ,请大佬手下留情");
            withdrawal=scanner.nextDouble();
        }
        account.setMoney(account.getMoney()-withdrawal);
        System.out.println("恭喜取款成功,目前账户余额为: "+account.getMoney());
        System.out.println("谢谢大佬使用☆*: .｡. o(≧▽≦)o .｡.:*☆");
             return;
    }

    /**
     * 转账
     *
     * @param account
     * @param scanner
     * @param accounts
     */
    private static void transferAccount(Account account, Scanner scanner, ArrayList<Account> accounts) {
        System.out.println("欢迎使用转账功能╰(*°▽°*)╯");
        System.out.println("你的卡号信息为: "+account.getIDCard());
        System.out.println("请输入转入户主卡号:");
        String acc=scanner.next();
        Account account1=getAccountByCardID(acc,accounts);
        while(account1==null)
        {
            System.out.println("大佬，该卡号不存在的哟,重新试一下要不？也可以输入（N/n）进行返回");
            acc=scanner.next();
            account1=getAccountByCardID(acc,accounts);
            if (acc.equals("n")||acc.equals("N"))
            {
                return;
            }
        }
        System.out.println("输入转账金额到"+account1.getIDCard()+"该卡号用户");
        double transfer=scanner.nextDouble();
        while(transfer<0||transfer>account.getMoney())
        {
            if (transfer<0)
            System.out.println("该转账金额不合法的哟");
            else if(transfer>account.getMoney())
                System.out.println("您的余额没有这么多啦喵,您当前余额为: "+account.getMoney());
            System.out.println("重新试一试吧");
            transfer=scanner.nextDouble();
        }
        account.setMoney(account.getMoney()-transfer);
        account1.setMoney(account1.getMoney()+transfer);
        System.out.println("转账成功辽！！您当前余额为: "+account.getMoney());
        return;
    }

    /**
     * 更改密码
     *
     * @param account
     * @param scanner
     */
    private static void changeAccount(Account account, Scanner scanner) {
        System.out.println("----------更改密码界面---------");
        System.out.println("请用户输入您的原密码（卡号:"+account.getIDCard()+"）:");
        String okPassWord=scanner.next();
        while(!okPassWord.equals(account.getPassword())){
            System.out.println("密码不正确哟喵~,重新试一试吧");
            okPassWord=scanner.next();
        }
        String againWord;
        while (true) {
            if(okPassWord.equals(account.getPassword())){
                System.out.println("请用户输入您修改后的密码:");
                okPassWord=scanner.next();
                System.out.println("请确认该密码~~~");
                againWord=scanner.next();
                if (againWord.equals(okPassWord))
                {
                    System.out.println("更改密码成功，回车键进行退出");
                    account.setPassword(againWord);
                     scanner.nextInt();
                break;
                }
                else System.out.println("两次密码正确哟，重新试一试吧~~");
             }
        }
    }

    /**
     * 注销账户
     *
     * @param account
     * @param scanner
     */
    private static void destroyAccount(Account account, Scanner scanner) {
        System.out.println("您确定要注销账户?    是/否(Y&y/N&n)");
        String del=scanner.next();
        while(true) {
            if (del.equals("Y") || del.equals("y")) {
                System.out.println("账户注销完成~~~");
                account=null;
                break;

            } else if (del.equals("n") || del.equals("N")) {
                System.out.println("已取消注销操作---");
                break;

            }
            else System.out.println("输入操作有误,重新输入");
            del=scanner.next();
        }
        return;
    }

    /**
     * 注册功能
     * @param accounts
     * @param scanner
     *
     */
    private static void register(ArrayList<Account>accounts,Scanner scanner){
        System.out.println("---------------------开通用户----------------------");
        Account account=new Account();//创建一个账户对象,用于后期封装
        System.out.println("输入你的用户名:");
        String userName=scanner.next();
        account.setUserName(userName);
        while (true) {
            System.out.println("输入账户密码:");
            String password=scanner.next();
            System.out.println("请确认账户密码:");
            String OkPassword=scanner.next();
            if(OkPassword.equals(password))//两次相同才能注册
            {
                account.setPassword(password);
                break;//注册成功就跑路   qwq
            }
            else {
                System.out.println("两次密码不相同，请重新确认~~~");
            }
        }

        System.out.println("请输入单次限额");
        double quotaMoney=scanner.nextDouble();
        while(quotaMoney<0){
            System.out.println("不能为负数，请重新输入");
            quotaMoney=scanner.nextDouble();
        }
        account.setQuotaMoney(quotaMoney);

        ///为账户随机一个八位数且不重复的卡号(最好独立为一个方法)
        String cardID=getRandomCardID(accounts);
        account.setIDCard(cardID);
        //把账户对象添加到账户集合中
        accounts.add(account);
        System.out.println("恭喜您开户成功"+userName+"先生/女士,你的卡号是:"+cardID);
    }

    /**
     *生成卡号
     * @param accounts
     * @return  cardID
     */
    private static String getRandomCardID(ArrayList<Account>accounts) {
        //先生成再说。。。。
        Random random=new Random();
        while (true) {
            String cardID="";
            for (int i = 0; i < 8; i++) {
                cardID+=random.nextInt(10);
            }
            //判断卡号是否重复
            Account acc=getAccountByCardID(cardID,accounts);
            if(acc==null){
                //为true说明没有重复,可以使用
                return cardID;
            }
        }
    }

    /**
     * 判断是否生成了重复的卡号
     * @param cardID
     * @param accounts
     * @return null||账户
     */
    private static Account getAccountByCardID(String cardID,ArrayList<Account>accounts) {
        for (int i = 0; i <accounts.size() ; i++) {
            Account ac=accounts.get(i);
            if(ac.getIDCard().equals(cardID)){
                return ac;
            }
        }
        return null;//查无此号
    }
}
//用户类
class Account{
   private String IDCard;
   private String userName;
   private String password;
   private double money;
   private double quotaMoney;//取限
//   private double LimitedMoney;
   public Account(){}

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getQuotaMoney() {
        return quotaMoney;
    }

    public void setQuotaMoney(double quotaMoney) {
        this.quotaMoney = quotaMoney;
    }
}