package gormdemo1

class User {

    String name
    String email
    Date dob
    Boolean active = false
    Integer balance = 0

    static hasMany = [friends: User, books: Book]

    static constraints = {
        email(nullable: true)
        dob(nullable: true)
    }

    def afterInsert() {
        log.info("--------In After Insert Of User----------------")
        User.withNewSession {
            UserInvitation userInvitation = new UserInvitation(user: this, code: UUID.randomUUID(), active: false)
            userInvitation.save()
            log.info("--------Created userInvitation for user with invitation id ${userInvitation?.id}")
        }
        log.info("---------------End of After Insert----------------")
    }

    def beforeInsert() {
        log.info "----------Into before Insert------"
    }

    def beforeValidate() {
        log.info "----------Into before Validate------"
    }
}
