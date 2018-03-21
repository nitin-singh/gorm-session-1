package gormdemo1

import grails.converters.JSON

class DemoController {

    def index() {}

    def demo() {
        Map response = [
                userTotalCount: User.count()
        ]
        render(response as JSON)
    }

    def demo2() {
        Map response = [
                countByName: User.countByName("nitin")
        ]
        render(response as JSON)
    }

    def demo3() {
        Map response = [
                countByNameAndBalance: User.countByNameIlikeAndBalanceIsNotNull("%user%")
        ]
        render(response as JSON)
    }

    def demo4() {
        Map response = [
                countByNameIlikeOrBalanceInList: User.countByNameIlikeOrBalanceInList("%user%", [1000, 2000, 3000])
        ]
        render(response as JSON)
    }
}
