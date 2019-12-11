package spring.entity;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Bean的生命周期
 */
public class Book  implements BeanNameAware, BeanFactoryAware,
        ApplicationContextAware, InitializingBean, DisposableBean {
    private String bookName;

    public Book(){
        System.out.println( "第一步：Book Initializing ");
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
        System.out.println("第二步：setBookName: Book name has set.");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("第三步：Book.setBeanName invoke");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("第四步：Book.setBeanFactory invoke");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("第五步：Book.setApplicationContext invoke");
    }

    // 自定义初始化方法
    @PostConstruct
    public void springPostConstruct(){
        System.out.println("第六步：@PostConstruct");
    }



    public void afterPropertiesSet() {
        System.out.println("第七步：Book.afterPropertiesSet invoke");
    }


    public void myPostConstruct(){
        System.out.println("第八步：Book.myPostConstruct invoke");
    }

    public String getBookName() {
        System.out.println("第九步：使用bean");
        return bookName;
    }

    // 自定义销毁方法
    @PreDestroy
    public void springPreDestory(){
        System.out.println("第十步：@PreDestory");
    }

    public void destroy() {
        System.out.println("第十一步：Book.destory invoke");
    }


    public void myPreDestory(){
        System.out.println("第十二步Book.myPreDestory invoke");
        System.out.println("---------------destroy-----------------");
    }



    @Override
    protected void finalize() {
        System.out.println("------inside finalize-----");
    }
}