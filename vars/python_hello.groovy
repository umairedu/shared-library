def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    node {
      def cmdArray = ["python", "-c", "print('hello')"]
      def cmd = cmdArray.execute()
      cmd.waitForOrKill(1000)
      println cmd.text
    }
}
