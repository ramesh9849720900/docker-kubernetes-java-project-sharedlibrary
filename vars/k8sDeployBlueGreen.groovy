
def call(String color, String imageTag) {
    sh """
    kubectl apply -f kubernetes/stockmanager-${color}.yaml
    kubectl set image deployment/stockmanager-${color} \
      stockmanager=${ECR_REPO}:${imageTag}
    """
}
