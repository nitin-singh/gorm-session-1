package gormdemo1

class Book {

    String name

    static belongsTo = [user: User]
}
