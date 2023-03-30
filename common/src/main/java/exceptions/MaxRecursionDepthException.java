package exceptions;

/**
 * Thrown when find recursion of executed scripts.
 * @author Kirill Markov
 * @version 1.0
 */
public class MaxRecursionDepthException extends RuntimeException {
    /**
     * message for exception
     */
    private static final String msg =
            """
                  Не надо шутить с рекурсией. Здесь другие правила.
                  Это не Google, это не Yandex. Пользователь, твой компьютер здесь порвут на части.
                  Тысячи отборных студентов ИТМО. Они все разнесут. Они весь код перелопатят за один час.
                  Они взорвут все твои устройства, всех твоих друзей, коллег. Пользователь, ты ковбой.
                  Ты остановись, б..., ты кончай, ты рекурсию спрячь подальше на склад и забудь про нее.
                  У нас был один чудак, запустил рекурсию, б..., и рухнула Великая Российская империя.
                  И другой чудак был, тоже рекурсию запустил, и рухнул Советский Союз. И ты повторишь ту же ошибку.
                  Ты рекурсию забудь, рекурсия отработала свое. Ты подумай о будущем программы. Она гибнет.
                  """;
    /**
     * Constructs new MaxRecursionDepthException with specified message.
     */
    public MaxRecursionDepthException() {
        super(msg);
    }
}