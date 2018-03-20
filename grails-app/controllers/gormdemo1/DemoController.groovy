package gormdemo1

import grails.converters.JSON

class DemoController {

    def index() {}

    def demo() {
        User user = new User(name: "Nitin", email: "nitin.kumar@tothenew.com", dob: new Date() - 100, balance: 555)
        user.name = null
        user.validate()
        Map response = [
                email    : user.validate(['email']),
                name     : user.validate(['name']),
                hasErrors: user.hasErrors(),
                allErrors: user.errors.allErrors
        ]
        render(response as JSON)
    }
}
