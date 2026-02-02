def call(String imageTag) {
    sh """
      aws ecr get-login-password --region us-east-1 \
      | docker login --username AWS --password-stdin ${AWS_ACCOUNT_ID}.dkr.ecr.eu-north-1.amazonaws.com

      docker build -t stockmanager:${imageTag} .
      docker tag stockmanager:${imageTag} ${ECR_REPO}:${imageTag}
      docker push ${ECR_REPO}:${imageTag}
    """
}

