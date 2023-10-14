import org.testng.annotations.Test;

public class groupClass {

    @Test(groups = {"Sanity"})
    public void test1(){
        System.out.println("This is test 1");
    }

    @Test(groups = {"Regression","Sanity"})

    //@Test(priority = 1, groups = "Regression")

    public void test2(){
        System.out.println("This is test 2");
    }

    @Test(groups = {"Sanity"})
    public void test3(){
        System.out.println("This is test 3");
    }

    @Test(groups = {"Regression"})
    public  void test4(){
        System.out.println("This is test 4");
    }

}
