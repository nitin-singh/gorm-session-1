package gormdemo1

import grails.converters.JSON

class DemoController {

    def index() {}

    def demo1() {
        Map response = [
                findById1: User.findById(1L),
                findById2: User.findById(1L)
        ]
        render(response as JSON)
    }

    def demo2() {
        Map response = [
                getById1: User.get(1L),
                getById2: User.get(1L)
        ]
        render(response as JSON)
    }

    def demo3() {
        Map response = [
                findByName               : User.findByName("user 1"),
                findByNameIlikeAndBalance: User.findByNameIlikeAndBalance("%user%", 5000),
                findByNameLikeOrBalance  : User.findByNameLikeOrBalance("%user%", 5000),
                findByNameIlikeOrBalance : User.findByNameIlikeOrBalance("%user%", 5000, [sort: 'balance', order: 'desc'])

        ]
        render response as JSON
    }
}
