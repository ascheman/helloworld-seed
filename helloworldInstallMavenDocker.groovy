/**
 * Created by ascheman on 25.03.17.
 */
job ("helloworld-install-mavendocker") {
    scm {
        github ("devopssquare/helloworld", "master")
    }
    triggers {
        scm("H/10 * * * *")
    }
    steps {
        shell ('docker run -i --rm --name hello-world-install -v ~/.m2/repository:/root/.m2/repository -v "$PWD":/usr/src -w /usr/src maven:alpine mvn clean install')
    }
}
