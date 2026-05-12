pipeline {
    agent any
    
    environment {
        // 设置环境变量，根据您的实际安装路径修改
        MAVEN_HOME = 'C:\\Program Files\\apache-maven-3.9.9'
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-11.0.24'
        PATH = "${MAVEN_HOME}\\bin;${JAVA_HOME}\\bin;%PATH%"
    }
    
    stages {
        stage('Clean') {
            steps {
                // 使用完整路径调用 mvn
                bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" clean'
            }
        }
        stage('Compile') {
            steps {
                bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" compile'
            }
        }
        stage('Test') {
            steps {
                bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" test -Dmaven.test.failure.ignore=true'
            }
        }
        stage('PMD') {
            steps {
                bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" pmd:pmd'
            }
        }
        stage('JaCoCo') {
            steps {
                bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" jacoco:report'
            }
        }
        stage('Javadoc') {
            steps {
                bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" javadoc:javadoc'
            }
        }
        stage('Site') {
            steps {
                bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" site'
            }
        }
        stage('Package') {
            steps {
                bat '"C:\\Program Files\\apache-maven-3.9.9\\bin\\mvn" package -DskipTests'
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
