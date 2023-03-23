SOURCE_IMAGE = os.getenv("SOURCE_IMAGE", default='tapacr.azurecr.io/example-java-app-source')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='.')
NAMESPACE = os.getenv("NAMESPACE", default='default')
OUTPUT_TO_NULL_COMMAND = os.getenv("OUTPUT_TO_NULL_COMMAND", default=' > /dev/null ')

k8s_custom_deploy(
    'example-java-app',
    apply_cmd="tanzu apps workload apply -f config/workload.yaml --update-strategy replace --debug --live-update" +
               " --local-path " + LOCAL_PATH +
               " --source-image " + SOURCE_IMAGE +
               " --namespace " + NAMESPACE +
               " --yes " +
               OUTPUT_TO_NULL_COMMAND +
               " && kubectl get workload example-java-app --namespace " + NAMESPACE + " -o yaml",
    delete_cmd="tanzu apps workload delete -f config/workload.yaml --namespace " + NAMESPACE + " --yes",
    deps=['pom.xml', './target/classes'],
    container_selector='workload',
    live_update=[
      sync('./target/classes', '/workspace/BOOT-INF/classes')
    ]
)
allow_k8s_contexts('arn:aws:eks:us-west-1:087368549112:cluster/ncarlos-20220321')
k8s_resource('example-java-app', port_forwards=["8080:8080"],
            extra_pod_selectors=[{'carto.run/workload-name': 'example-java-app', 'app.kubernetes.io/component': 'run'}])
