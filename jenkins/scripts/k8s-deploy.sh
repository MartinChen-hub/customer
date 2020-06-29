echo 'deploy start'
kubectl delete -f ./jenkins/deploy.yaml
kubectl apply -f ./jenkins/deploy.yaml
echo 'deploy successfully'

