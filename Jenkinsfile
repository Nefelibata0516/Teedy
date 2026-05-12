pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }
        stage('Compile') {
            steps {
                bat 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test -Dmaven.test.failure.ignore=true'
            }
        }
        stage('PMD') {
            steps {
                bat 'mvn pmd:pmd'
            }
        }
        stage('JaCoCo') {
            steps {
                bat 'mvn jacoco:report'
            }
        }
        stage('Javadoc') {
            steps {
                bat 'mvn javadoc:javadoc'
            }
        }
        stage('Site') {
            steps {
                bat 'mvn site'
            }
        }
        stage('Package') {
            steps {
                bat 'mvn package -DskipTests'
            }
        }
    }
    post {
        always {
            // 归档站点文档（如果存在）
            archiveArtifacts artifacts: '**/target/site/**/*.*', fingerprint: true, allowEmptyArchive: true
            // 归档 JAR 文件
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true, allowEmptyArchive: true
            // 归档 WAR 文件
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true, allowEmptyArchive: true
            // 收集测试报告（只有存在时才执行）
            junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
        }
    }
}
