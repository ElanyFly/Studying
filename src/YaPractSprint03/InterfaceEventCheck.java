package YaPractSprint03;

public class InterfaceEventCheck {
    public static void main(String[] args) {
        final EventsHandler eventsHandler = new EventsHandler();
        final Event homeScreenEvent = new CriticalCrashEvent("Home");
        final Event favoriteButtonDisabledEvent = new ButtonDisabledEvent("Favorite");

        final Event[] events = {homeScreenEvent, favoriteButtonDisabledEvent};
        eventsHandler.handleErrorEvent(events);
    }

}

interface Event {

    // в интерфейсах, так же, можно объявлять статические константы
    int NON_CRITICAL = 100;
    int CRITICAL = 200;

    // метод будет возвращать код ошибки для корректной обработки события
    int code();

    // сообщение с ошибкой. Поможет быстрее понять, в чём же проблема
    String message();
}

class EventsHandler {   //класс распределяющий ошибки

    // метод handleErrorEvent принимает на вход массив Event, и ему не важно,
    // кто его реализует, важно лишь, то что он умеет выводить код ошибки и сообщение
    public void handleErrorEvent(final Event[] events) {
        for (final Event event : events) {
            if (event.code() == Event.CRITICAL) {
                sendMessageToDutyTeam(event.message());
            } else if (event.code() == Event.NON_CRITICAL) {
                sendMessageToRegularTeam(event.message());
            } else {
                sendMessageToQATeam(event.message());
            }
        }
    }

    private void sendMessageToDutyTeam(final String message) {
        System.out.println("Ошибка '" + message + "' будет исправлена как можно быстрее");
    }

    private void sendMessageToRegularTeam(final String message) {
        System.out.println("Ошибка '" + message + "' будет исправлена в ближайшем обновлении");
    }

    private void sendMessageToQATeam(final String message) {
        System.out.println("Неизвестная ошибка '" + message + "'. Необходимо подробнее изучить проблему");
    }
}

class CriticalCrashEvent implements Event {

    final String screen;

    public CriticalCrashEvent(final String screen) {
        this.screen = screen;
    }

    @Override
    public int code() {
        return Event.CRITICAL;
    }

    @Override
    public String message() {
        return "Crash on screen " + screen;
    }
}

class ButtonDisabledEvent implements Event {

    final String button;

    public ButtonDisabledEvent(final String button) {
        this.button = button;
    }

    @Override
    public int code() {
        return Event.NON_CRITICAL;
    }

    @Override
    public String message() {
        return "Button " + button + " is disabled";
    }
}

