package gormdemo1

import grails.converters.JSON

class DemoController {

    def index() {}

    def demo() {
        Map response = [
        ]
        render(response as JSON)
    }
}
