/**
 * Created by ascheman on 2016-06-11
 */

mavenJob ("dukecon_html5_${branch}") {
    scm {
        github ("ascheman/helloworld", "master")
    }
    triggers {
        scm("H/10 * * * *")
    }
    goals ('clean test')
}
