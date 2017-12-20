package transients.bug

class Somethin {

    String persisted
    String notPersisted = "test"

    static transients = ['notPersisted']

    static constraints = {
    }
}
