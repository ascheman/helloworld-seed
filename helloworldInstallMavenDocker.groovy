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
        shell ('''
volumes="-v "$PWD":/usr/src"
test -d $HOME/.m2 && volumes="$volumes -v $HOME/.m2:/root/.m2"
links=""
test -r $HOME/.docker-nexus-host && links="--link `cat $HOME/.docker-nexus-host`:nexus" 
docker run -i --rm --name hello-world-install $volumes $links -w /usr/src maven:alpine mvn clean install
''')
    }
}
