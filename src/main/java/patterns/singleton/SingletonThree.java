package patterns.singleton;

/**
 * 线程安全的延迟加载单例
 */
public class SingletonThree {
    private  static SingletonThree instance;
    private SingletonThree(){
        //防止通过反射初始化实例
        if (instance == null) {
            instance = this;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static synchronized SingletonThree getInstance(){
        if(instance==null){
            instance=new SingletonThree();
        }
        return instance;
    }
}