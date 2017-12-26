package transients.bug

trait Doable {

    static transients = ['forceUpdate']

    boolean forceUpdate = false

    def beforeUpdate() {
        if (!forceUpdate) {
            throw new Exception("Not doable.")
        }
    }

    def beforeInsert() {
        if (!forceUpdate) {
            throw new Exception("Not doable.")
        }
    }

}