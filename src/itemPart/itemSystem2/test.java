package itemPart.itemSystem2;

public class test {
    //测试一下这个super


    public static void main(String[] args) {
        simpleFactory s1 = new simpleFactory();
        medicine m1 = s1.buildMedicineCureAll();
        System.out.println(m1.getHeal());
        System.out.println(m1.getPrice());
        System.out.println(m1.getUrl());
    }
}
