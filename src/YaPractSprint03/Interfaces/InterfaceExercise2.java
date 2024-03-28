package YaPractSprint03.Interfaces;

public class InterfaceExercise2 {
}

abstract class LibraryItem {
    String title;
    String text;
    String owner;
    String library;

    public void read() {
        System.out.println("Читаем:");
        System.out.println(title);
        System.out.println(text);
    }


//    public void takeFromLibrary(String newOwnerName) {
//        owner = newOwnerName;
//    }
//
//    public void returnToLibrary() {
//        owner = "";
//    }

//    public String getCurrentLibrary() {
//        return library;
//    }
//
//    public void moveToNewLibrary(String libraryName) {
//        library = libraryName;
//    }
}

interface Transportable {
    String getCurrentLibrary();
    void moveToNewLibrary(String libraryName);

    //В интерфейс Transportable перенесем методы перемещения книг между библиотеками:
// String getCurrentLibrary() и void moveToNewLibrary(String libraryName).
}

interface Ownable {
    void takeFromLibrary(String newOwnerName);
    void returnToLibrary();

    //В интерфейс Ownable перенесем методы void takeFromLibrary(String newOwnerName) и
// void returnToLibrary() нужные для взятия и возврата книги в библиотеку.
}

class Book extends LibraryItem implements Transportable, Ownable{

    @Override
    public String getCurrentLibrary() {
        return super.library;
    }

    @Override
    public void moveToNewLibrary(String libraryName) {
        super.library = libraryName;
    }

    @Override
    public void takeFromLibrary(String newOwnerName) {
        super.owner = newOwnerName;
    }

    @Override
    public void returnToLibrary() {
        super.owner = "";
    }
    //- Книги (Book) можно забирать домой, читать в читальном зале, их могут перевезти в другую библиотеку.
}

class Journal extends LibraryItem implements Transportable{
    // - Журналы (Journal) отличаются тем, что их нельзя забрать домой, они доступны только в читальном зале.

    @Override
    public String getCurrentLibrary() {
        return super.library;
    }

    @Override
    public void moveToNewLibrary(String libraryName) {
        super.library = libraryName;
    }
}

class EBook extends LibraryItem {
    // - Электронные книги (EBook) нельзя перевезти в другую библиотеку,
    // они доступны сразу везде. Забрать домой их так же не получится.

}