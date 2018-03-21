package gormdemo1

import grails.converters.JSON

class DemoController {

    def index() {
        Map response = [
                allUsers: User.list([sort: 'dob', order: 'desc', max: 5, offset: 0])
        ]
        render response as JSON
    }

    def demo() {
        Map response = [
                sorted5users: User.list([sort: 'dob', order: 'desc', max: 5, offset: 0])
        ]
        render response as JSON
    }

    def demo2() {
        Map response = [
                usersOfId12345: User.getAll([1, 2, 3, 4, 5])
        ]
        render response as JSON
    }

    def demo3() {
        Map response = [
                findAllByName                          : User.findAllByName("user 1", [sort: 'dob', order: 'desc', max: 5, offset: 0]),
                findAllByNameIlikeAndBalanceGreaterThan: User.findAllByNameIlikeAndBalanceGreaterThan("%user%", 4000, [sort: 'dob', order: 'desc', max: 5, offset: 0]),
                findAllByNameIlikeOrBalanceGreaterThan : User.findAllByNameIlikeOrBalanceGreaterThan("%user%", 4000, [sort: 'dob', order: 'desc', max: 5, offset: 0])
        ]
        render response as JSON
    }
}
