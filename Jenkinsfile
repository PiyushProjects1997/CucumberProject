pipeline {
    agent any
    
    tools {
        maven 'MyMaven'  // Jenkins mein configured Maven
        jdk 'MyJava'     // Jenkins mein configured JDK
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Git repository se code checkout
                git branch: 'main', 
                    url: 'https://github.com/PiyushProjects1997/CucumberProject.git'
            }
        }
        
        stage('Build') {
            steps {
                // Maven clean & compile
                bat 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                // Run Cucumber tests
                bat 'mvn test'
            }
        }
    }
    
    post {
        failure {
            emailext (
                subject: "Jenkins Build Failed: ${currentBuild.fullDisplayName}",
                body: """
                    Job Failed - "${env.JOB_NAME}"
                    Build Number - ${env.BUILD_NUMBER}
                    Build URL - ${env.BUILD_URL}
                """,
                to: 'aapka.gmail@gmail.com'
            )
        }
        success {
            emailext (
                subject: "Jenkins Build Success: ${currentBuild.fullDisplayName}",
                body: """
                    Job Success - "${env.JOB_NAME}"
                    Build Number - ${env.BUILD_NUMBER}
                    Build URL - ${env.BUILD_URL}
                """,
                to: 'aapka.gmail@gmail.com'
            )
        }
    }
}
