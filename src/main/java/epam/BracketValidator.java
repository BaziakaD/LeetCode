package epam;

public class BracketValidator {

//    На вход передается строка со скобками типа "((()))()()".
//    Нужно написать метод который скажет валидны ли открыты и закрыты скобки.
//    Например следующая строка не валидная ")(" потому что скобка вначале открыта а только потом закрыта.
//    И эта строка не валидна "(()" потому что открыто 2 строки и закрыта одна.

    public static void main(String[] args) {
        System.out.println(validate("((()))()()"));
        System.out.println(validate(")("));
    }

    private static boolean validate(String row) {
        return false;
    }
}