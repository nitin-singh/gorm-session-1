package gormdemo1

class UserInvitation {
    String code
    Boolean active

    static belongsTo = [user: User]
}
