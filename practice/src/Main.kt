fun main() {

    val speaker = Speaker()
    speaker.addAudience(audience = Audience())
    speaker.addAudience(audience = Audience())

    speaker.setMessage("what's up")
    speaker.setMessage("Hello Again")
}

// Observer Pattern
// subject , observer and Observable

// Observable
class Speaker() {
    private var message= Message("Hello")

    private val audiences = ArrayList<Audience>()


    fun setMessage(msg:String ) {
       this.message.text=  msg
        notifyAudience()
    }
    fun addAudience(audience: Audience){
       audiences.add(audience)
    }

    fun notifyAudience() {
        for ( audience in audiences ) {
            audience.update(message)
        }
    }


}

class Message (public var text : String){

}



// Observer
class Audience() : CanListen<Message> {
    private var message= Message("")
    override fun update(message: Message) {
        this.message = message
        print("Got a new message:  ${message.text}\n")
    }

}


interface CanListen<T>{
    fun update( a: T)

}

