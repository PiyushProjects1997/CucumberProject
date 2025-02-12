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
        
        stage('Generate Reports') {
            steps {
                // Cucumber reports generate
                cucumber buildStatus: 'UNSTABLE',
                    reportTitle: 'Cucumber Report',
                    fileIncludePattern: '**/cucumber.json',
                    trendsLimit: 10,
                    classifications: [
                        [
                            'key': 'Environment',
                            'value': 'TEST'
                        ]
                    ]
            }
        }
    }
    
    post {
        always {
            // Cleanup workspace
            cleanWs()
        }
        success {
            echo 'Pipeline successfully completed'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}
