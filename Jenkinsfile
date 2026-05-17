pipeline {
    agent any
    
    stages {
        stage('Clean') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" -B -U clean'
            }
        }
        stage('Compile') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" -B -U compile'
            }
        }
        stage('Install Snapshot Artifacts') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" -B -U -DskipTests install'
            }
        }
        stage('Test') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" -B -U test -Dmaven.test.failure.ignore=true'
            }
        }
        stage('PMD') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" -B -U pmd:pmd'
            }
        }
        stage('JaCoCo') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" -B -U jacoco:report'
            }
        }
        stage('Javadoc') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" -B -U javadoc:javadoc -Dmaven.javadoc.failOnError=false -DadditionalJOption=-Xdoclint:none'
            }
        }
        stage('Site') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" -B -U site'
            }
        }
        stage('Package') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" -B -U package -DskipTests'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/site/**/*.*', fingerprint: true, allowEmptyArchive: true
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true, allowEmptyArchive: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true, allowEmptyArchive: true
            junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
        }
    }
}
