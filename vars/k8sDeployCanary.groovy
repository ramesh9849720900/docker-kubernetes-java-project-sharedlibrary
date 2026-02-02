
def call(String imageTag) {
    sh """
    kubectl apply -f kuberenetes/stockmanager-canary.yaml
    kubectl set image deployment/stockmanager-canary \
      stockmanager=${ECR_REPO}:${imageTag}
    """
}
