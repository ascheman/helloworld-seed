/**
 * Created by ascheman on 2016-06-11
 */

mavenJob ("helloworld") {
    scm {
        github ("ascheman/helloworld", "master")
    }
    triggers {
        scm("H/10 * * * *")
    }
    goals ('clean test')
}
