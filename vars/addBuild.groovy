    def callMe() {
        steps.echo("Test")
        steps.echo("${steps.env.BRANCH_NAME}")
        steps.sh("ls -al")
    }
