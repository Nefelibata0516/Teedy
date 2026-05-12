pipeline {
    agent any
    
    stages {
        stage('Clean') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" clean'
            }
        }
        stage('Compile') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" compile'
            }
        }
        stage('Test') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" test -Dmaven.test.failure.ignore=true'
            }
        }
        stage('PMD') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" pmd:pmd'
            }
        }
        stage('JaCoCo') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" jacoco:report'
            }
        }
        stage('Javadoc') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" javadoc:javadoc'
            }
        }
        stage('Site') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" site'
            }
        }
        stage('Package') {
            steps {
                bat '"D:\\Program Files\\apache-maven-3.9.15\\bin\\mvn" package -DskipTests'
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
