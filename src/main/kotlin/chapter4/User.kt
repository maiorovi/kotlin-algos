package chapter4

import javax.print.attribute.standard.MediaSize

open class User (val nickName: String,
            val isSubscribed: Boolean = true)

class TwitterUser(nickname: String) : User(nickname)

interface OtherUser {
    val nickname: String
}

class PrivateUser(override val nickname: String) : OtherUser

class SubscribingUser(val email: String): OtherUser {
    override val nickname get() = email.substringBefore("@")
}

