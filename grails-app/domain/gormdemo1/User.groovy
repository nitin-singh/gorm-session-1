package gormdemo1

class User {
    String name
    String email
    Date dob
    Integer balance = 0

    static constraints = {
        email(nullable: true)
        dob(nullable: true)
    }
    
    def afterInsert() {
        log.info "----------Into After Insert------"
    }

    def beforeInsert() {
        log.info "----------Into before Insert------"
    }

    def beforeValidate() {
        log.info "----------Into before Validate------"
    }
}