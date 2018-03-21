package gormdemo1

import grails.converters.JSON

class DemoController {

    def index() {}

    def init() {
        User user = new User(name: "Nitin", dob: new Date() - 1000, balance: 1000, email: "nitin.kumar@tothenew.com")
        10.times {
            user.addToBooks(new Book(name: "Book ${it}"))
        }

        user.save(flush: true)
        render "Created Data"
    }

    def demo() {
        //removing book only from collection
        User u = User.get(1)
        Book b = Book.get(1)
        u.removeFromBooks(b)
        u.save(flush: true)
        Map response = [
                user1Books: u.books*.id.sort(),
                allBooks  : Book.list()*.id.sort()
        ]
        render(response as JSON)
    }

    def demo2() {
//        removing book from collection and also deleting it.
        User u = User.get(1)
        Book b = Book.get(1)
        u.removeFromBooks(b)
        b.delete()
        u.save(flush: true)
        Map response = [
                user1Books: u.books*.id.sort(),
                allBooks  : Book.list()*.id.sort()
        ]
        render(response as JSON)
    }

    def demo3() {
//        list all books.
        Map response = [
                user1Books: User.get(1).books*.id.sort()
        ]
        render response as JSON
    }
}
