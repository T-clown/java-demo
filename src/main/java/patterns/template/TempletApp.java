package patterns.template;

public class TempletApp {
    public static void main(String[] args) {
        useTemplet("1", new Callback<Integer, String>() {
            @Override
            public Integer doSomething(String t) {
                int a= Integer.parseInt(t);
                return a+1;
            }
        });
    }

    public static void useTemplet(String str, Callback<Integer, String> callback) {
        System.out.println("固定代码");

        Integer result = callback.doSomething(str);
        System.out.println(result);

        System.out.println("固定代码");
    }
}
