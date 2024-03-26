package YaPractSprint03;
import java.util.ArrayList;
import java.util.List;

public class InterfacesExercise {
    public static void main(String[] args) {

        Article article1 = new Article("Всё о звездах.");
        Article article2 = new Article("Кто убил кролика Роджера? Загадка века.");
        Article article3 = new Article("Маленькие радости большой девочки.");
        List<Article> articles = List.of(article1, article2, article3);

        NewspaperPublisher newspaperPublisher = new NewspaperPublisher(articles);

        OfflineSubscriber subscriber1 = new OfflineSubscriber("ул.Мартовская, д.13");
        WebSite subscriber2 = new WebSite("ссылка");
        WebSite subscriber3 = new WebSite("другая ссылка");

        newspaperPublisher.subscribe(subscriber1);
        newspaperPublisher.subscribe(subscriber2);
        newspaperPublisher.subscribe(subscriber3);
        newspaperPublisher.subscribe(subscriber1);

        newspaperPublisher.startWork();

    }

}

class Article {

    final String getArticle;

    Article(final String getArticle) {
        this.getArticle = getArticle;
    }
}

// создайте интерфейс Subscriber
// интерфейс должен иметь всего один метод `void send()`, который принимает на вход объект класса `Article`
interface Subscriber {
    void send(Article article);
}

class OfflineSubscriber implements Subscriber/* класс должен реализовывать интерфейс Subscriber */ {

    private final String address;

    public OfflineSubscriber(final String address) {
        this.address = address;
    }

    @Override
    public void send(Article article) {
        System.out.println(article.getArticle + " была доставлена по адресу: " + address);
    }
    // метод send интерфейса Subscriber должен выводить текст "{article.getArticle}
    // была доставлена по адресу: {address}"
}

class WebSite implements Subscriber/* класс должен реализовывать интерфейс Subscriber */ {

    private final String url;

    public WebSite(final String url) {
        this.url = url;
    }

    @Override
    public void send(Article article) {
        System.out.println(article.getArticle + " опубликована на страничке: " + url);
    }

    // метод send интерфейса Subscriber должен выводить текст
    // "{article.getArticle} опубликована на страничке: {address}"
}

class NewspaperPublisher {

    private final List<Article> articles;

    List<Subscriber> subscribers = new ArrayList<>();
    // для отправки статей подписчикам, вам необходимо хранить их в списке
    // создайте пустой список подписчиков List<Subscriber>

    public NewspaperPublisher(final List<Article> articles) {
        this.articles = articles;
    }

    public void subscribe(Subscriber subscriber) {
        for (int i = 0; i < subscribers.size(); i++) {
            if (subscribers.contains(subscriber)){
                System.out.println("Такой подписчик уже есть в списке.");
                return;
            }
        }
        subscribers.add(subscriber);
    }
    //- При вызове метода subscribe() класса NewspaperPublisher новый подписчик должен добавлять в список подписчиков без дубликатов

    // Создайте метод subscribe() принимающий на вход любой объект, реализующий интерфейс Subscriber.
    // При вызове метода subscribe() новый подписчик должен добавляться в список подписчиков.
    // В списке подписчиков не должно быть дубликатов! Вы можете проеверить, есть ли данный подписчик
    // в списке методом List.contains().


    public void unsubscribe(Subscriber subscriber) {
        for (int i = 0; i < subscribers.size(); i++) {
            subscribers.remove(subscriber);

        }
    }
    // Создайте метод unsubscribe() принимающий на вход любой объект, реализующий интерфейс Subscriber.
    // При вызове данного метода подписчик должен удаляться из списка подписчиков.

    public void startWork() {
        for (int i = 0; i < subscribers.size(); i++) {
            Subscriber subscriber = subscribers.get(i);
            for (int j = 0; j < articles.size(); j++) {
                subscriber.send(articles.get(j));
            }
        }
    }
    // Создайте метод startWork().
    // Метод должен отправлять все статьи, которые хранятся в данный момент в списке articles,
    // всем подписчикам из списка.
    // Для отправки используйте метод send() класса Subscriber.

    public void publishNewArticle(Article article) {
        articles.add(article);
        for (int i = 0; i < subscribers.size(); i++) {
            Subscriber subscriber = subscribers.get(i);
            subscriber.send(article);
        }
    }

    // Создайте метод publishNewArticle(). Метод принимает на вход объект класса Article.
    // Метод должен добавлять новую статью в список статей articles, а затем рассылать её
    // всем подписчикам из списка.
}
