pipeline {
    agent any
    
    tools {
        maven 'MAVEN_HOME'  // Jenkins mein configured Maven
        jdk 'JAVA_HOME'     // Jenkins mein configured JDK
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Git repository se code checkout
                git branch: 'main', 
                    url: 'http://localhost:8081/'
            }
        }
        
        stage('Build') {
            steps {
                // Maven clean & compile
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                // Run Cucumber tests
                sh 'mvn test'
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
